package com.demo.action;

import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class UploadAction2 {
    private String msg;

    private String fileFileName; //struts2用来封装该文件域对应的文件的文件名,xxxFileName,layui上传的文件域field默认值是file
    private File file; //struts2用来封装页面文件域对应的文件内容xxx


    public String execute(){
      /* HttpServletRequest request= ServletActionContext.getRequest();
        HttpServletResponse response= ServletActionContext.getResponse();
        String type = request.getParameter("type");
        String id = request.getParameter("id");

        //Gson gson=new Gson();
        String uploadPath = request.getContextPath()+"/file/images/";  //文件保存路径
        File files = new File(uploadPath);
        if(!files.isDirectory() && !files.exists()) {
            files.mkdirs();
            System.out.println("nnnnnnnnnnnnnnnnnn");
        }*/

        HttpServletResponse response= ServletActionContext.getResponse();
        ServletContext context = ServletActionContext.getServletContext();
        String uploadPath = context.getRealPath("/file/images/");
        File files = new File(uploadPath);
        if(!files.isDirectory() && !files.exists()) {
            files.mkdirs();
            System.out.println("nnnnnnnnnnnnnnnnnn");
        }



        /**页面控件的文件流**/
        String fileOriginalName="";
        InputStream inStream=null;
        String suffix ="";
        String newFileName = fileFileName;
        try {
            /**获取文件夹下所有文件名**/
            File[] oldFiles = files.listFiles();
            int iFileCout=0;
            boolean bFileFlag = false;
            fileOriginalName=fileFileName.substring(0, fileFileName.lastIndexOf("."));  //获取文件名
            suffix = fileFileName.substring(fileFileName.lastIndexOf("."));  //获取文件后缀
            while(!bFileFlag){
                bFileFlag = true;
                for(int i=0; i<oldFiles.length; i++){
                    if(oldFiles[i].isFile()){
                        if(oldFiles[i].getName().equals(newFileName)){
                            newFileName = fileOriginalName+"_"+iFileCout+suffix;  //在文件名末尾用"_"+自增数字来防止重名文件覆盖,也可以使用时间戳等重命名
                            bFileFlag = false;
                            iFileCout++;
                            break;
                        }
                    }
                }
            }
            inStream=new FileInputStream(file);
            String fileName=uploadPath+File.separator+newFileName; //File.separator代替分隔符, 防止linux和windows环境不同
            System.out.println(fileName+"~~~");
            FileOutputStream fs = new FileOutputStream(fileName);
            int byteread = 0;
            byte[] buffer = new byte[1024];
            while ( (byteread = inStream.read(buffer)) != -1) {
                fs.write(buffer, 0, byteread);
                System.out.println(byteread+"~~~");
            }
            fs.close();  //注意关闭流
            inStream.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        PrintWriter out=null;
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache");
        try {
            out = response.getWriter();
            Map<String,Object> resultMap=new HashMap<String,Object>();
            resultMap.put("newFileName", newFileName);  //上传一个文件后返回的数据
            resultMap.put("msg", "上传成功");  //上传一个文件后返回的数据
            JSONObject jsonObject= JSONObject.fromObject(resultMap);
            out.print(jsonObject);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
