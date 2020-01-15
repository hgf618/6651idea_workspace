package com.demo.action;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UploadAction {


    public String execute(){
        System.out.println(uname+"====");
        //根据获取ServletContext对象获取项目路径
        ServletContext context = ServletActionContext.getServletContext();
        String newFileName=new Random().nextInt(99999999)+""+new SimpleDateFormat("yyyyMMddsss").format(new Date())+"_"+mfFileName;
        String path = context.getRealPath("/file")+"/"+newFileName;
        File f = new File(path);
        //如果文件不存在则创建文件
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            //使用FileUtils类实现文件拷贝
            FileUtils.copyFile(mf,f);

        } catch (IOException e) {
            e.printStackTrace();
        }


        return "success";
    }
    /*
    Struts2会把表单中的文件DOM自动注入Action中文件对象变量
    */
    private File mf; //文件对象
    /*
    如果File对象名为 XXX
    文件名格式必须是 XXXFileName
    请求头文件格式必须是 XXXContentType
    同样，都需要getter和setter方法
        */
    private String mfFileName; //文件名
    private String mfContentType;//文件请求头文件
    private String uname;
    public File getMf() {
        return mf;
    }
    public void setMf(File mf) {
        this.mf = mf;
    }
    public String getMfFileName() {
        return mfFileName;
    }
    public void setMfFileName(String mfFileName) {
        this.mfFileName = mfFileName;
    }
    public String getMfContentType() {
        return mfContentType;
    }
    public void setMfContentType(String mfContentType) {
        this.mfContentType = mfContentType;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }
}
