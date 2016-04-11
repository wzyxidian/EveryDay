package com.routesearch.route;

import java.util.List;

/**
 * @author zhiyong wang
 *
 */
public class BFSNode{

	private int vertex;
	private BFSNode bfsNode;
	/**
	 * @param bfsNode
	 * @param vertex
	 */
	BFSNode(BFSNode bfsNode, int vertex) {
		this.bfsNode = bfsNode;
		this.vertex = vertex;
	}

	/**
	 * @return
	 * 不知道该怎么写，感觉返回的结果是以该顶点为尾的所有边的集合，但是没有看到进行初始化
	 */
	public List<Edge> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param vertex
	 * @return
	 * 这个状态没有看到进行初始化
	 */
	public boolean testState(int vertex) {
		// TODO Auto-generated method stub
		return Route.dataState[vertex];
	}

	/**
	 * @return
	 */
	public int getNode() {
		// TODO Auto-generated method stub
		return vertex;
	}

	/**
	 * @return
	 * 这个也没有看懂在什么地方获取的
	 */
	public int getConditionNum() {
		return 0;
	}

	/**
	 * @return
	 */
	public int getWeight() {
		return new Edge().getIndex();
	}
	
}