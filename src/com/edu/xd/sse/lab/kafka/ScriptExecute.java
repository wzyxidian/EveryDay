package com.edu.xd.sse.lab.kafka;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by zhiyongwang on 2016/5/18.
 */
public class ScriptExecute {

    /**
     * linux 具体执行指令
     * 这里有个特例，如果是启动/关闭kafka的时候，执行的是sh文件
     *
     * @param path
     * @param command
     * @return
     */
    public static ArrayList<String> executeCommand(String path, String command) {
        ArrayList<String> list = new ArrayList<String>();
        try {
            Runtime.getRuntime().exec("chmod 777 " + path + " -R");//以防没有权限执行下面的指令
            Process pro = Runtime.getRuntime().exec(path + command);
            BufferedReader br = new BufferedReader(new InputStreamReader(pro.getInputStream()));
            String line;
            while ((line = br.readLine()) != null) {
                list.add(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.print("command error");
        }
        return list;
    }
}
