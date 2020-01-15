package com.demo.action;


import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import java.io.*;

public class DownloadAction {

    public String execute(){
        ServletContext context = ServletActionContext.getServletContext();
        String path = context.getRealPath("/img")+"/"+fileName;
        File inFile = new File(path);
        InputStream is = null;
        try {
            is = new FileInputStream(inFile);//创建文件输入流大小的字节数组
            byte bytes[] = new byte[is.available()];//写入字节数组中
            is.read(bytes);//将塞满字节的字节数组写入ByteArrayInputStream
            inputStream = new ByteArrayInputStream(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return "success";
    }
    //使用ByteArrayInputStream可以避免流关闭后丢失
    private ByteArrayInputStream  inputStream;
    //设置文件下载名称，与struts.xml中的配置文件${fileName}对应
    private String fileName;
    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }
    public void setInputStream(ByteArrayInputStream inputStream) {
        this.inputStream = inputStream;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
