package com.myzf.dao.impl;

import com.myzf.dao.QxDao;
import com.myzf.entity.Qx;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 区县连接数据库
 */
public class QxDaoImpl implements QxDao {

    /**
     * 获取所有区县集合
     * @return
     */
    public List<Qx> findAll(){
        return findList("select * from tbl_qx");
    }

    /**
     * 根据主键获取区县对象
     * @param id
     * @return
     */
    public Qx findById(int id) {
        String sql = "select * from tbl_qx where qxid=" + id;
        List<Qx> list=findList(sql);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    private List<Qx> findList(String sql) {
        List<Qx> list = new ArrayList<>();
        ResultSet resultSet = ConnectionManager.executeQuery(sql);
        try {
            int qxid;
            String qx;
            while (resultSet.next()) {
                qxid = resultSet.getInt("qxid");
                qx = resultSet.getString("qx");
                Qx qxObj = new Qx(qxid, qx);
                list.add(qxObj);
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

