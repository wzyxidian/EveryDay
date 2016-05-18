package com.edu.xd.sse.lab.kafka;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

/**
 * Created by Administrator on 2016/5/16.
 * fetch the infomation about topic, including topic name, topic number, topic partition, topic replication, all of IP
 */
public class KafkaTopicInfo {

    private String getAllIp = "";
    private String getAllTopicCommand = "";
    private String getEveryTopicCommand = "";
    private String kafkaPath = "";

    /**
     * consturcture init the configuration
     * 通过构造函数获得配置文件的信息
     */
    public KafkaTopicInfo() {
        String config = System.getProperty("user.dir") + "config/kafka.properties";
        try {
            InputStream is = new BufferedInputStream(new FileInputStream(config));
            Properties pro = new Properties();
            pro.load(is);
            getAllIp = pro.getProperty("AllIp");
            getAllTopicCommand = pro.getProperty("getAllTopicCommand");
            getEveryTopicCommand = pro.getProperty("getEveryTopicCommand");
            kafkaPath = pro.getProperty("kafkaPath");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取topic 信息的信息，结果是ArrayList<ArrayList<String>>
     * 大数据结构里面存放了四个list：
     * 第一个是集群中所有的ip信息
     * 第二个是集群中所有的topic名称
     * 第三个是每个topic详情，三个为一组：topic名称，patition个数，replication个数
     * 第四个是每台节点上kafka的状态
     *
     * @return 结果是ArrayList<ArrayList<String>>
     * 大数据结构里面存放了三个list：
     * 第一个是集群中所有的ip信息
     * 第二个是集群中所有的topic名称
     * 第三个是每个topic详情，三个为一组：topic名称，patition个数，replication个数
     */
    public ArrayList<ArrayList<String>> getTopicInfo() {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        //first step: get AllIp
        ArrayList<String> allIp = new ArrayList<String>();
        String[] ip = getAllIp.split(",");
        Collections.addAll(allIp, ip);
        result.add(allIp);
        //second step: get AllTopic
        ArrayList<String> allTopic = ScriptExecute.executeCommand(kafkaPath, getAllTopicCommand);
        result.add(allTopic);
        //third step: get EveryTopic
        ArrayList<String> topicInfomation = new ArrayList<String>();
        for (int i = 0; i < allTopic.size(); i++) {
            ArrayList<String> evertyTopicInfo = ScriptExecute.executeCommand(kafkaPath, getEveryTopicCommand + " " + allTopic.get(i));
            String[] topicInfo = evertyTopicInfo.get(0).split("  ");
            for (int j = 0; j < topicInfo.length - 1; j++) {
                topicInfomation.add(topicInfo[j].split(":")[1]);
            }
            result.add(topicInfomation);
        }
        //forth step: get every node's kafka status
        boolean flag = false;
        ArrayList<String> status = new ArrayList<String>();
        ArrayList<String> jpsInfo = ScriptExecute.executeCommand("", "jps");
        for (int i = 0; i < jpsInfo.size(); i++) {
            if (jpsInfo.get(i).contains("Kafka"))
                flag = true;
        }
        if (flag)
            status.add("running");
        else
            status.add("stop");
        result.add(status);
        return result;
    }
}
