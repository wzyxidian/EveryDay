package com.edu.xd.sse.lab.others;

import java.util.NoSuchElementException;


//线性表双向链表存储结构
public class DuLinkList<T> {

	//保存该链表的头结点
	private Node header;
	//保存该链表的尾节点
	private Node tail;
	//保存该链表中已包含的节点数
	private int size;
	//创建空链表
	public DuLinkList(){
		//空链表，header与tail都是null
		header = null;
		tail = null;
	}
	//以指定数据元素来创建链表，该链表只有一个元素
	public DuLinkList(T element){
		header = new Node(element, null, null);
		tail = header;
		size++;
	}

	//判断链式线性表是否为空链表
	public boolean empty(){
		return size == 0;
	}

	//清空线性表
	public void clear(){
		for(Node current = header; current != null;){
			Node next = header.next;
			current.data = null;
			current.prev = null;
			current.next = null;
			current = next;
		}
		header = null;
		tail = null;
		size = 0;
	}

	//获取链式线性表中索引为index处的元素
	public T get(int index){
		return getNodeByIndex(index).data;
	}

	//根据索引index获取指定位置的节点
	private Node getNodeByIndex(int index){
		if(index < 0 || index > size -1){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		if(index < (size >> 1)){
			//从header节点开始遍历
			Node current = header;
			for(int i=0; i < index; i++){
				current = current.next;
			}
			return current;
		}else{
			Node current = tail;
			for(int i = size - 1; i > index; i--){
				current = current.prev;
			}
			return current;
		}
	}

	//查找链式线性表中指定元素的索引
	public int locate(T element){
		Node current = header;
		for(int i=0;i<size && current != null;i++, current = current.next){
			if(current.data.equals(element)){
				return i;
			}
		}
		return -1;
	}

	//返回链表的长度
	public int length(){
		return size;
	}

	//向线性链表的表头插入一个元素
	public void addFirst(T element){
		linkFirst(element);
	}

	//在线性链表表头插入一个元素
	public void linkFirst(T element){
		Node f = header;
		Node newNode = new Node(element,null,f);
		header = newNode;
		if(f == null){
			tail = newNode;
		}else{
			f.prev = newNode;
		}
		size++;
	}

	//向线性链表的表尾插入一个元素
	public void addTail(T element){
		linkTail(element);
	}

	//在线性链表的表尾插入一个元素
	public void linkTail(T element){
		Node t = tail;
		Node newNode = new Node(element, t, null);
		tail = newNode;
		if(t == null){
			header = newNode;
		}else{
			t.next = newNode;
		}
		size++;
	}

	//在线性表中某个元素前面插入一个节点
	public void linkBefore(T element, Node node){
		Node pre = node.prev;
		Node newNode = new Node(element, pre, node);
		node.prev = newNode;
		if(pre == null){
			header = newNode;
		}else{
			pre.next = newNode;
		}
		size++;
	}

	//向线性链表中的指定位置插入一个元素
	public void insert(T element, int index){
		if(index < 0 || index > size){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		if(index == size){
			addTail(element);
		}else{
			linkBefore(element,getNodeByIndex(index));
		}
	}

	//移走线性链表的头结点
	public void removeFirst(){
		Node first = header;
		if(first == null)
			throw new NoSuchElementException("此节点不存在");
		unlinkFirst(first);
	}

	//删除头结点
	public void unlinkFirst(Node node){
		Node next = node.next;
		node.data = null;
		node.next = null;
		header = next;
		if(next == null){
			tail = null;
		}else{
			next.prev = null;
		}
		size--;
	}

	//移走线性链表的尾节点
	public void removeTail(){
		Node last = tail;
		if(last == null)
			throw new NoSuchElementException("此节点不存在");
		unlinkLast(last);
	}

	//删除尾节点
	public void unlinkLast(Node node){
		Node pre = node.prev;
		node.data = null;
		node.prev = null;
		tail = pre;
		if(pre == null){
			header = null;
		}else{
			pre.next = null;
		}
		size--;
	}

	//移走线性表中的任意一个节点
	public void remove(int index){
		if(index < 0 || index >size - 1){
			throw new IndexOutOfBoundsException("线性表越界");
		}
		unlink(getNodeByIndex(index));
	}

	//删除线性表中任意一个元素
	public void unlink(Node node){
		Node pre = node.prev;
		Node next = node.next;
		node.data = null;
		if(pre == null){
			header = next;
		}else{
			pre.next = next;
			node.prev = null;
		}
		if(next == null){
			tail = pre;
		}else{
			next.prev = pre;
			node.next = null;
		}
		size--;
	}

	//定义一个内部类Node，Node实例代表链表的节点
	private class Node {
		//保存节点的数据
		private T data;
		//指向上一个节点的引用
		private Node prev;
		//指向下一个节点的引用
		private Node next;

		//无参数的构造器
		public Node() {

		}

		//初始化全部属性的构造器
		public Node(T data, Node prev, Node next) {
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
	}
}
