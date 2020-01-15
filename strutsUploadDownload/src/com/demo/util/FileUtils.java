package com.demo.util;

import java.io.*;

public class FileUtils {

    /**
     * 文件拷贝
     * @param fileSource
     * @param target
     */
    public static void copy(File fileSource, File target){
        try {
            FileInputStream fis = new FileInputStream(fileSource);
            DataInputStream dis=new DataInputStream(fis);
            FileOutputStream fos = new FileOutputStream(target);
            DataOutputStream dos=new DataOutputStream(fos);
            int temp;
            while((temp=dis.read())!=-1) {
                dos.write(temp);
            }
            dos.flush();
            fos.close();
            dis.close();
            fis.close();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
