package com.myzf.action;

import com.myzf.entity.Fwlx;
import com.myzf.entity.Fwxx;
import com.myzf.entity.Jd;
import com.myzf.entity.Qx;
import com.myzf.entity.entityBiz.FwxxCon;
import com.myzf.service.FwlxService;
import com.myzf.service.FwxxService;
import com.myzf.service.QxService;
import com.myzf.service.impl.FwlxServiceImpl;
import com.myzf.service.impl.FwxxServiceImpl;
import com.myzf.service.impl.QxServiceImpl;
import com.myzf.util.Page;

import java.util.List;
import java.util.Map;

/**
 * 首页控制器
 */
public class IndexAction {
    private List<Fwxx> fwxxList;//房屋信息列表集合
    private List<Qx> qxList;
    private List<Fwlx> fwlxList;
    private Map<Integer,List<Jd>> qxJdMap;//区县街道集合
    private FwxxService fwxxService=new FwxxServiceImpl();
    private QxService qxService=new QxServiceImpl();
    private FwlxService fwlxService=new FwlxServiceImpl();
    private Fwxx fwxx;//房屋信息实体对象
    private FwxxCon fwxxCon;//搜索条件实体
    private Page myPage;//分页实体


    /**
     * 查询
     * @return
     */
    public String search(){
        if(myPage==null){
            myPage=new Page();
        }
        myPage.setRowCount(fwxxService.findCountByCon(fwxxCon));//设置满足条件的记录数
        fwxxList= fwxxService.findListByCon(fwxxCon,myPage);//高级搜索并分页

        qxList=qxService.findAll();//准备区县集合
        qxJdMap=qxService.findQxJdMap();//准备区县街道Map集合
        for (Integer qxid:qxJdMap.keySet()){
            if(qxid!=0){//除了不限区县外，其他区县下都在第一个位置添加一个不限--街道
                List<Jd> jdList=qxJdMap.get(qxid);
                jdList.add(0, new Jd(0, "不限--", null));
            }
        }

        fwlxList=fwlxService.findAll();//准备房屋类型集合
        fwlxList.remove(0);//去掉房屋类型中的 不限-- 类型
        return  "index";
    }


    /**
     * 查看详情
     * @return
     */
    public String detail(){
       fwxx=fwxxService.findById(fwxx.getFwid());
        return "detail";
    }

    ////////////////getters and setters//////////////////////////
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

    public FwxxCon getFwxxCon() {
        return fwxxCon;
    }

    public void setFwxxCon(FwxxCon fwxxCon) {
        this.fwxxCon = fwxxCon;
    }

    public Page getMyPage() {
        return myPage;
    }

    public void setMyPage(Page myPage) {
        this.myPage = myPage;
    }
}
