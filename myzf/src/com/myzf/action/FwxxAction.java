package com.myzf.action;

import com.myzf.entity.*;
import com.myzf.entity.entityBiz.FwxxCon;
import com.myzf.service.FwlxService;
import com.myzf.service.FwxxService;
import com.myzf.service.QxService;
import com.myzf.service.impl.FwlxServiceImpl;
import com.myzf.service.impl.FwxxServiceImpl;
import com.myzf.service.impl.QxServiceImpl;
import com.myzf.util.Page;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import java.util.List;
import java.util.Map;

public class FwxxAction {
    private List<Fwxx> fwxxList;
    private List<Qx> qxList;
    private List<Fwlx> fwlxList;
    private Map<Integer,List<Jd>> qxJdMap;//区县街道集合
    private FwxxService fwxxService=new FwxxServiceImpl();
    private QxService qxService=new QxServiceImpl();
    private FwlxService fwlxService=new FwlxServiceImpl();
    private Fwxx fwxx;
    private String msgUrl;
    private Page myPage;
    private FwxxCon fwxxCon;

    /**
     * 查看我的房屋信息
     * @return
     */
    public String findMyList(){
       // User user=(User) ActionContext.getContext().getSession().get("LOGIN_USER");//获取登录用户
        if(myPage==null){
            myPage=new Page();
        }
      //  FwxxCon fwxxCon=new FwxxCon();
      //  fwxx=new Fwxx();
     //   fwxx.setUser(user);
    //    fwxxCon.setFwxx(fwxx);
        myPage.setRowCount(fwxxService.findCountByCon(fwxxCon));//设置满足条件的记录数
        fwxxList= fwxxService.findListByCon(fwxxCon,myPage);//高级搜索并分页


        return "my";
    }

    /**
     * 删除
     * @return
     */
    public String delete(){
        if(fwxxService.delete(fwxx.getFwid())){
            msgUrl="删除成功-FwxxAction_findMyList";
            return "success";
        }else{
            msgUrl="删除失败-FwxxAction_findMyList";
            return "error";
        }
    }

    /**
     * 准备发布
     * @return
     */
    public String toPost(){
        qxList=qxService.findAll();//准备区县集合
        qxJdMap=qxService.findQxJdMap();//准备区县街道Map集合

        for (Integer key:qxJdMap.keySet()){
            System.out.print(key+"=====");
            List<Jd> jdList=qxJdMap.get(key);
            for(Jd jd:jdList){
                System.out.print(jd.getJd()+"\t");
            }
            System.out.println();
        }

        fwlxList=fwlxService.findAll();//准备房屋类型集合
        return "post";
    }

    /**
     * 发布房屋信息
     * @return
     */
    public String post(){
        User user=(User) ActionContext.getContext().getSession().get("LOGIN_USER");
        fwxx.setUser(user);
        if(fwxxService.save(fwxx)){
            msgUrl="房屋信息添加成功-FwxxAction_findMyList";
            return "success";
        }else{
            msgUrl="房屋信息添加失败-javascript:history.back()";
            return "error";
        }
    }

    /**
     * 准备修改
     * @return
     */
    public String toUpdate(){
        fwxx=fwxxService.findById(fwxx.getFwid());
        qxList=qxService.findAll();
        qxJdMap=qxService.findQxJdMap();//准备区县街道Map集合
        fwlxList=fwlxService.findAll();
        return "update";
    }

    /**
     * 修改房屋信息
     * @return
     */
    public String update(){
        if(fwxxService.update(fwxx)){
            msgUrl="房屋信息修改成功-FwxxAction_findMyList";
            return "success";
        }else{
            msgUrl="房屋信息修改失败-javascript:history.back()";
            return "error";
        }
    }


    public List<Fwxx> getFwxxList() {
        return fwxxList;
    }

    public void setFwxxList(List<Fwxx> fwxxList) {
        this.fwxxList = fwxxList;
    }

    public Fwxx getFwxx() {
        return fwxx;
    }

    public void setFwxx(Fwxx fwxx) {
        this.fwxx = fwxx;
    }

    public String getMsgUrl() {
        return msgUrl;
    }

    public void setMsgUrl(String msgUrl) {
        this.msgUrl = msgUrl;
    }

    public List<Qx> getQxList() {
        return qxList;
    }

    public void setQxList(List<Qx> qxList) {
        this.qxList = qxList;
    }

    public List<Fwlx> getFwlxList() {
        return fwlxList;
    }

    public void setFwlxList(List<Fwlx> fwlxList) {
        this.fwlxList = fwlxList;
    }

    public Map<Integer, List<Jd>> getQxJdMap() {
        return qxJdMap;
    }

    public void setQxJdMap(Map<Integer, List<Jd>> qxJdMap) {
        this.qxJdMap = qxJdMap;
    }

    public Page getMyPage() {
        return myPage;
    }

    public void setMyPage(Page myPage) {
        this.myPage = myPage;
    }

    public FwxxCon getFwxxCon() {
        return fwxxCon;
    }

    public void setFwxxCon(FwxxCon fwxxCon) {
        this.fwxxCon = fwxxCon;
    }
}
