package com.myzf.dao.impl;

import com.myzf.dao.JdDao;
import com.myzf.entity.Jd;
import com.myzf.entity.Qx;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdDaoImpl implements JdDao {
    private QxDaoImpl qxDaoImpl=new QxDaoImpl();

    /**
     * 获取所有街道集合
     * @return
     */
    public List<Jd> findAll(){
        return findList("select * from tbl_jd");
    }

    /**
     * 根据主键获取街道对象
     * @param id
     * @return
     */
    public Jd findById(int id){
        String sql="select * from tbl_jd where jdid="+id;
        List<Jd> list=findList(sql);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    /**
     * 根据sql语句获取街道集合
     * @param sql
     * @return
     */
    private List<Jd> findList(String sql){
        List<Jd> list=new ArrayList<>();
        ResultSet resultSet=ConnectionManager.executeQuery(sql);
        try {
             int jdid;
             String jd;
             Qx qx;//区县外键对象
            while (resultSet.next()){
                jdid=resultSet.getInt("jdid");
                jd=resultSet.getString("jd");
                int qxid=resultSet.getInt("qxid");
                qx= qxDaoImpl.findById(qxid);//根据qxid获取区县对象
                Jd jdObj=new Jd(jdid,jd,qx);
                list.add(jdObj);
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

        return  list;
    }

}
