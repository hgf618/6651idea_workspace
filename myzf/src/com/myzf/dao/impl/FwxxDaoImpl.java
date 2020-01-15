package com.myzf.dao.impl;

import com.myzf.dao.FwxxDao;
import com.myzf.dao.UserDao;
import com.myzf.entity.Fwlx;
import com.myzf.entity.Fwxx;
import com.myzf.entity.Jd;
import com.myzf.entity.User;
import com.myzf.entity.entityBiz.FwxxCon;
import com.myzf.util.Page;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * 房屋信息连接数据库
 */
public class FwxxDaoImpl implements FwxxDao {
    private UserDaoImpl userDaoImpl=new UserDaoImpl();
    private JdDaoImpl jdDaoImpl=new JdDaoImpl();
    private FwlxDaoImpl fwlxDaoImpl=new FwlxDaoImpl();
    @Override
    public List<Fwxx> findAll() {
        return findList("select * from tbl_fwxx",null);
    }

    @Override
    public Fwxx findById(int id) {
        List<Fwxx> list=findList("select * from tbl_fwxx where fwid="+id,null);
        return list!=null&&list.size()>0?list.get(0):null;
    }

    /**
     * 根据sql查询房屋信息集合
     * @param sql
     * @return
     */
    private List<Fwxx> findList(String sql,List<Object> paramList){
        List<Fwxx> list=new ArrayList<>();
        ResultSet resultSet=null;
        if(paramList!=null&&paramList.size()>0){
            resultSet=ConnectionManager.executeQuery(sql, paramList);
        }else{
            resultSet= ConnectionManager.executeQuery(sql);
        }

        try {
             int fwid;
             User user;//用户外键对象
             Jd jd;//街道外键的对象
             Fwlx fwlx;//房屋类型外键对象
             int shi;
             int ting;
             String fwxx;
             int zj;
             String title;
             Timestamp date;
             String telephone;
             String lxr;
            while (resultSet.next()){
                fwid=resultSet.getInt("fwid");
                int uid=resultSet.getInt("uid");
                user=userDaoImpl.findById(uid);//根据ui获取用户对象
                int jdid=resultSet.getInt("jdid");
                jd=jdDaoImpl.findById(jdid);//根据jdid获取街道对象
                int lxid=resultSet.getInt("lxid");
                fwlx=fwlxDaoImpl.findById(lxid);//根据lxid获取房屋类型对象
                shi=resultSet.getInt("shi");
                ting=resultSet.getInt("ting");
                fwxx=resultSet.getString("fwxx");
                zj=resultSet.getInt("zj");
                title=resultSet.getString("title");
                date=resultSet.getTimestamp("date");
                telephone=resultSet.getString("telephone");
                lxr=resultSet.getString("lxr");
                Fwxx fwxxObj=new Fwxx(fwid, user, jd, fwlx, shi, ting, fwxx, zj, title, date, telephone, lxr);
                list.add(fwxxObj);
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



    @Override
    public boolean save(Fwxx fwxx) {
        String sql="insert into tbl_fwxx(uid,jdid,lxid,shi,ting,fwxx,zj,title,telephone,lxr) values(?,?,?,?,?,?,?,?,?,?)";
        List<Object> paramList=new ArrayList<>();
        paramList.add(fwxx.getUser().getUid());
        paramList.add(fwxx.getJd().getJdid());
        paramList.add(fwxx.getFwlx().getLxid());
        paramList.add(fwxx.getShi());
        paramList.add(fwxx.getTing());
        paramList.add(fwxx.getFwxx());
        paramList.add(fwxx.getZj());
        paramList.add(fwxx.getTitle());
        paramList.add(fwxx.getTelephone());
        paramList.add(fwxx.getLxr());
        return ConnectionManager.executeUpdate(sql, paramList);
    }

    @Override
    public boolean update(Fwxx fwxx) {
        String sql="update tbl_fwxx set jdid=?,lxid=?,shi=?,ting=?,fwxx=?,zj=?,title=?,date=?,telephone=?,lxr=? where fwid=?";
        List<Object> paramList=new ArrayList<>();
        paramList.add(fwxx.getJd().getJdid());
        paramList.add(fwxx.getFwlx().getLxid());
        paramList.add(fwxx.getShi());
        paramList.add(fwxx.getTing());
        paramList.add(fwxx.getFwxx());
        paramList.add(fwxx.getZj());
        paramList.add(fwxx.getTitle());
        paramList.add(fwxx.getDate());
        paramList.add(fwxx.getTelephone());
        paramList.add(fwxx.getLxr());
        paramList.add(fwxx.getFwid());
        return ConnectionManager.executeUpdate(sql, paramList);
    }

    @Override
    public boolean delete(int id) {
        String sql="delete from tbl_fwxx where fwid=?";
        List<Object> paramList=new ArrayList<>();
        paramList.add(id);
        return ConnectionManager.executeUpdate(sql,paramList);
    }


    /**
     * 查询满足条件的记录数
     * @param fwxxCon
     * @return
     */
    public int findCountByCon(FwxxCon fwxxCon){
        String sql="select count(*) from tbl_fwxx  where 1=1 ";
        List<Object> paramList=new ArrayList<>();
       sql+=getSqlCon(fwxxCon,paramList);//添加条件字符串
        System.out.println(sql+"=======");
        return ConnectionManager.executeCount(sql,paramList);

    }

    /**
     * 查询满足条件的集合并分页
     * @param fwxxCon
     * @param page
     * @return
     */
    public List<Fwxx> findListByCon(FwxxCon fwxxCon, Page page){
        List<Object> paramList=new ArrayList<>();
        String sql="select * from tbl_fwxx  where 1=1 ";
        sql+=getSqlCon(fwxxCon,paramList);//添加条件字符串
        if(page!=null){
            int startIndex=(page.getPageNo()-1)*page.getPageSize();
            sql+=" limit ?,?";
            paramList.add(startIndex);
            paramList.add(page.getPageSize());
        }
        System.out.println(sql+"~~~~");
        return findList(sql,paramList);
    }

    /**
     * 根据查询条件返回条件字符串
     * @param fwxxCon
     * @return
     */
    private String getSqlCon(FwxxCon fwxxCon,List<Object> paramList){
        String sqlCon="";
        if(fwxxCon!=null){
            if(fwxxCon.getFwxx()!=null){
                Fwxx fwxx=fwxxCon.getFwxx();
                if(fwxx.getTitle()!=null&&!fwxx.getTitle().equals("")){
                    sqlCon+=" and title  like ?";
                    paramList.add("%"+fwxx.getTitle()+"%");
                }
                if(fwxx.getShi()!=0) {
                    sqlCon+=" and shi = ?";
                    paramList.add(fwxx.getShi());
                }
                if(fwxx.getTing()!=0) {
                    sqlCon+=" and ting = ?";
                    paramList.add(fwxx.getTing());
                }

                if(fwxx.getJd()!=null){
                    if(fwxx.getJd().getJdid()!=0) {
                        sqlCon += " and jdid=?"  ;
                        paramList.add(fwxx.getJd().getJdid());
                    }else if(fwxx.getJd().getQx()!=null&&fwxx.getJd().getQx().getQxid()!=0){
                        sqlCon +=" and jdid in (select jdid from tbl_jd where qxid=?)";
                        paramList.add(fwxx.getJd().getQx().getQxid());
                    }
                }

                if(fwxx.getUser()!=null&&fwxx.getUser().getUid()!=0){
                    sqlCon+=" and uid=?";
                    paramList.add(fwxx.getUser().getUid());
                }
            }
            if(fwxxCon.getZj1()!=0){
                sqlCon+=" and zj>=?";
                paramList.add(fwxxCon.getZj1());
            }
            if(fwxxCon.getZj2()!=0){
                sqlCon+=" and zj<=?";
                paramList.add(fwxxCon.getZj2());
            }

            if(fwxxCon.getLxids()!=null&&fwxxCon.getLxids().length>0){
                String lxidStr="";
                for(int lxid:fwxxCon.getLxids()){
                    lxidStr+=lxid+",";
                }
                sqlCon+=" and lxid in (?)";//  4,2,1
                paramList.add(lxidStr.substring(0, lxidStr.length()-1));
            }

            if(fwxxCon.getDays()!=0){
                sqlCon+=" and  datediff(now(),date)<=?";
                paramList.add(fwxxCon.getDays());
            }
        }
        return sqlCon;
    }


}
