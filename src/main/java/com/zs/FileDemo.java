package com.zs;

import java.io.File;
import java.io.IOException;

/**
 * User: chanson-pro
 * Date-Time: 2017-10-31 9:33
 * Description: file API类的基本使用
 */
public class FileDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("E:\\gitProject\\javaio\\imooc");
        //System.out.println(file);
        if (!file.exists()){
            //file.createNewFile();
            file.mkdir();
        }
        else{
            file.delete();
        }
        System.out.println(file.getName());//获取刚创建的文件（或者目录）的名字
        System.out.println(file.getAbsolutePath());// 获取文件（目录）的据对路径
        System.out.println(file.getCanonicalPath());//getCanonicalPath():
        // 返回的是规范化的绝对路径，相当于将getAbsolutePath()中的“.”和“..”解析成对应的正确的路径
        System.out.println(file.getParent());// 获取父目录路径
        System.out.println(file.getParentFile());
    }

}
