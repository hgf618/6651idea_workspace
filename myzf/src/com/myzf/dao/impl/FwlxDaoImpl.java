package com.myzf.dao.impl;

import com.myzf.dao.FwlxDao;
import com.myzf.entity.Fwlx;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 房屋类型连接数据库
 */
public class FwlxDaoImpl implements FwlxDao {

    /**
     * 获取所有房屋类型集合
     * @return
     */
    public List<Fwlx> findAll(){
        return findList("select * from tbl_fwlx");
    }

    /**
     * 根据主键获取房屋类型对象
     * @param id
     * @return
     */
    public Fwlx findById(int id) {
        String sql = "select * from tbl_fwlx where lxid=" + id;
        List<Fwlx> list=findList(sql);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    private List<Fwlx> findList(String sql) {
        List<Fwlx> list = new ArrayList<>();
        ResultSet resultSet = ConnectionManager.executeQuery(sql);
        try {
            int lxid;
            String fwlx;
            while (resultSet.next()) {
                lxid = resultSet.getInt("lxid");
                fwlx = resultSet.getString("fwlx");
                Fwlx fwlxObj = new Fwlx(lxid, fwlx);
                list.add(fwlxObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ConnectionManager.closeAll(resultSet,resultSet.getStatement(),resultSet.getStatement().getConnection());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }
}

