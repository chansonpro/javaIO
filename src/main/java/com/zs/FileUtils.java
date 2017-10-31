package com.zs;

import java.io.File;

/**
 * User: chanson-pro
 * Date-Time: 2017-10-31 10:03
 * Description: file的一些工具类，包含过滤、遍历等操作
 */
public class FileUtils {

    /**
     * 列出给定目录（及其子目录）下的所有文件
     * @param dir 路径
     */
    public static void listDrectory(File dir){
        if (!dir.exists()){
            throw new IllegalArgumentException("目录" + dir + "不存在");
        }
        if (!dir.isDirectory()){
            throw new IllegalArgumentException(dir+"不是目录");
        }
        //String[] filenames = dir.list();
        //返回的是字符串数组，列出当前目录下的所有子目录和文件，不包含子目录下的内容

        //如果要遍历子目录下的内容就需要构造成File对象做递归操作，
        // File提供了直接返回File对象的API
        File[] files = dir.listFiles();
        //返回的是File数组，列出当前目录下的所有子目录和文件，不包含子目录下的内容
        if (files != null && files.length>0){
            for (File file:files) {
                if (file.isDirectory()){
                    listDrectory(file);
                }else{
                    System.out.println(file);
                }
            }
        }
    }
}
