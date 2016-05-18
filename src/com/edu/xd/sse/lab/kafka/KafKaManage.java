package com.edu.xd.sse.lab.kafka;

import java.io.*;
import java.util.ArrayList;
import java.util.Properties;

/**
 * Created by Administrator on 2016/5/16.
 * manage the kakfa, including start, stop
 */
public class KafKaManage {

    private String kafkaPath = "";
    private String startKafka = "";
    private String stopKafka = "";

    /**
     * consturcture init the configuration
     * 通过构造函数获得所需要的配置文件信息
     */
    public KafKaManage() {
        String config = System.getProperty("user.dir") + "/config/kafka.properties";
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(config));
            Properties pro = new Properties();
            pro.load(is);
            kafkaPath = pro.getProperty("kafkaPath");
            startKafka = pro.getProperty("startKafka");
            stopKafka = pro.getProperty("stopKafka");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 默认zookeeper是已经启动好的
     * 第一步写执行脚本文件
     * 第二步启动/关闭kafka
     * 第三步监测kafka是否已经启动/关闭成功
     */
    public boolean operateKafka(String command) throws FileNotFoundException {
        //编写脚本文件
        StringBuffer sb = new StringBuffer();
        sb.append("#!/bin/sh");
        sb.append(System.getProperty("line.separator"));
        sb.append("cd " + kafkaPath);
        sb.append(System.getProperty("line.separator"));
        if (command.equals("start"))
            sb.append(startKafka);
        else if (command.equals("stop"))
            sb.append(stopKafka);
        sb.append(System.getProperty("line.separator"));
        PrintWriter printWriter = new PrintWriter(kafkaPath + "operateKafka.sh");
        printWriter.write(sb.toString().toCharArray());
        printWriter.flush();
        printWriter.close();

        //启动/关闭kafka
        ScriptExecute.executeCommand(kafkaPath + "operateKafka.sh", "");

        //监测kafka是否启动/关闭成功
        boolean flag = false;
        ArrayList<String> jpsInfo = ScriptExecute.executeCommand("", "jps");
        for (int i = 0; i < jpsInfo.size(); i++) {
            if (jpsInfo.get(i).contains("Kafka"))
                flag = true;
        }
        if (flag && command.equals("start"))
            return true;
        else return !flag && command.equals("stop");
    }

}
