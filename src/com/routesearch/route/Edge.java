package com.routesearch.route;

/**
 * @author XX
 * @since 2016-3-4
 * @version V1.0
 *
 */
public class Edge{
	private double weight;  //weight of the edge
	private int index;      //index of the vertex
	private int startV;		//start vertex of the edge
	private int endV;	    //end vertex of the edge
	
	/**
	 * @param weight
	 */
	public void setMyWeight(int weight) {
		this.weight = weight;
	}
	
	/**
	 * @return weight
	 */
	public double getMyWeight() {
		return weight;
	}

	/**
	 * @param startV
	 */
	public void setStart(int startV) {
		this.startV = startV;
	}

	/**
	 * @return startV
	 */
	public int getStart() {
		return startV;
	}
	
	/**
	 * @param endV
	 */
	public void setEnd(int endV) {
		this.endV = endV;
	}

	/**
	 * @return endV
	 */
	public int getEnd() {
		return endV;
	}
	
	/**
	 * @param index
	 */
	public void setIndex(int index) {
		// TODO Auto-generated method stub
		this.index = index;
	}
	
	/**
	 * @return index
	 */
	public int getIndex() {
		return index;
	}
}