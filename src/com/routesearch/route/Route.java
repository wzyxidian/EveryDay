/**
 * 实现代码文件
 * 
 * @author XXX
 * @since 2016-3-4
 * @version V1.0
 */
package com.routesearch.route;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.jgrapht.graph.ClassBasedEdgeFactory;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;

public final class Route
{
    /**
     * 你需要完成功能的入口
     * 
     * @author XXX
     * @since 2016-3-4
     * @version V1
     */
	//邻接矩阵
	private static int[][] dataMatrix  = new int[600][600];
	//节点访问状态图
	public static boolean[] dataState = new boolean[600];
	//图
	protected static DefaultDirectedWeightedGraph<Integer, Edge> graph;
	//起点和终点
	protected static int startV;
	protected static int endV;
	//条件点
	protected static int[] conditionV;
	//总的节点数
	protected static int sumV;
	private static int edgeNum;
	private static long startTime;
	private static long endTime;
	
	private static BFSNode resultNode;
	
    public static String searchRoute(String graphContent, String condition)
    {
    	startTime = System.currentTimeMillis();
    	/**
    	 * 初始化
    	 */
    	init(graphContent, condition);
    	/**
    	 * 计算路径
    	 */
    	String resultString = "1|2";
    		resultString = algorithmA();
    	return resultString;

    }
    public static String algorithmA() {
    	dataState[startV] = true;
    	Comparator<BFSNode> OrderIsdn =  new Comparator<BFSNode>(){  
            public int compare(BFSNode o1, BFSNode o2) {  
                int numbera = (o1.getConditionNum() + 1) * 50 - o1.getWeight();  
                int numberb = (o2.getConditionNum() + 1) * 50 - o2.getWeight();  
                if(numberb > numbera) {  
                    return 1;  
                } else if(numberb < numbera) {  
                    return -1;  
                } else {  
                    return 0;  
                }  
            }  
        };  
    	Queue<BFSNode> bfsQueue = new PriorityQueue<BFSNode>(sumV, OrderIsdn);
    	endTime = System.currentTimeMillis();
    	bfsQueue.add(new BFSNode(null , startV));
    	while (!bfsQueue.isEmpty()) {
    		endTime = System.currentTimeMillis();
    		BFSNode peekNode = null;
    		while (!bfsQueue.isEmpty()) {
    			peekNode = bfsQueue.poll();
    			if (peekNode.getWeight() < 600) {
    				break;
    			}
    		}
    		if (peekNode == null) {
    			return "NA";
    		}
    		System.out.println(peekNode.getConditionNum()+"-"+conditionV.length);
    		for(int j = 0; j < sumV; j++) {
    			if(dataMatrix[peekNode.getNode()][j] != 0 && !peekNode.testState(j)) {
    				BFSNode tempNode = new BFSNode(peekNode, j);
    				//找到了
    				if (j == endV && tempNode.getConditionNum() == conditionV.length) {
    					resultNode = tempNode;
    					StringBuffer resultStringBuffer = new StringBuffer();
    			    	resultStringBuffer.append(tempNode.getList().get(0).getIndex());
    			    	for (int i = 1; i < tempNode.getList().size(); ++i) {
    			    		resultStringBuffer.append("|"+tempNode.getList().get(i).getIndex());
    			    	}
    			    	String resultString = resultStringBuffer.toString();
    			    	System.out.println(resultString);
    					return resultString;
    				}
    				bfsQueue.add(tempNode);
                }
    		}
    	}
    	System.out.println("NA");
    	return "NA";
    }
    public static void init(String graphContent, String condition) {
    	/**
    	 * 建立图模型
    	 */
    	graph = new DefaultDirectedWeightedGraph<Integer, Edge>(new ClassBasedEdgeFactory<Integer, Edge>(Edge.class));
    	/**
    	 * 处理condition
    	 */
    	//去掉\n
    	String[] tempCoStrings = condition.split("\n");
    	String[] tempCondition = tempCoStrings[0].split(",");
    	//处理条件数据
    	String[] tempConditionV = tempCondition[2].split("[|]");
    	//条件点数目
    	int conditionNum = tempConditionV.length;
    	//条件点数组
    	conditionV = new int[conditionNum];
    	//初始化条件点数组
    	for (int i = 0; i < tempConditionV.length; ++i) {
    		conditionV[i] = Integer.parseInt(tempConditionV[i]);
    	}
    	boolean flagW = true;
    	if (conditionNum >= 30) {
    		flagW = false;
    	}
    	/**
    	 * 处理graphContent
    	 */
    	String[] tempStrings = graphContent.split("\n");
    	//边的数目
    	edgeNum = tempStrings.length;
    	//初始化图
    	for (int i = 0; i < edgeNum; ++i) {
    		String[] tempV = tempStrings[i].split(",");
    		dataMatrix[Integer.parseInt(tempV[1])][Integer.parseInt(tempV[2])] = Integer.parseInt(tempV[3]);
    		
    		
    		if (!graph.containsVertex(Integer.parseInt(tempV[1]))) {
    			graph.addVertex(Integer.parseInt(tempV[1]));
    			sumV++;
    		}
    		if (!graph.containsVertex(Integer.parseInt(tempV[2]))) {
    			graph.addVertex(Integer.parseInt(tempV[2]));
    			sumV++;
    		}
    		Edge tempEdge = graph.addEdge(Integer.parseInt(tempV[1]), Integer.parseInt(tempV[2]));
    		//判断重复的边
    		if (tempEdge == null) {
    			tempEdge = graph.getEdge(Integer.parseInt(tempV[1]), Integer.parseInt(tempV[2]));
    			if (tempEdge.getMyWeight() > Double.parseDouble(tempV[3])) {
    				tempEdge.setIndex(Integer.parseInt(tempV[0]));
    				if (flagW) {
    					tempEdge.setMyWeight(Integer.parseInt(tempV[3]));
        				graph.setEdgeWeight(tempEdge, Double.parseDouble(tempV[3]));
    				}
    			}
    		}
    		tempEdge.setIndex(Integer.parseInt(tempV[0]));
    		tempEdge.setStart(Integer.parseInt(tempV[1]));
    		tempEdge.setEnd(Integer.parseInt(tempV[2]));
    		if (flagW) {
    			tempEdge.setMyWeight(Integer.parseInt(tempV[3]));
        		graph.setEdgeWeight(tempEdge, Double.parseDouble(tempV[3]));
    		} else {
    			tempEdge.setMyWeight(Integer.parseInt(tempV[3]));
        		graph.setEdgeWeight(tempEdge, 1);
    		}
    	}
    	
    	//将condition中的点加入graph，防止孤立节点
    	for (int i = 0; i < conditionV.length; ++i) {
    		if (!graph.containsVertex(conditionV[i])) {
    			graph.addVertex(conditionV[i]);
    			sumV++;
    		}
    	}
    	/**
    	 * 记录起点和终点
    	 */
    	startV = Integer.parseInt(tempCondition[0]);
    	endV = Integer.parseInt(tempCondition[1]);
    }
    
    
}