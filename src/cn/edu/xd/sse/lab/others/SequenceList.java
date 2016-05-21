package cn.edu.xd.sse.lab.others;

import java.util.Arrays;

//线性表的顺序存储 抽象类的实现
public class SequenceList<T> {
	private int DEFAULT_SIZE = 10;
	//保存数组的长度
	private int capacity;
	//定义一个数组用于保存顺序线性表的元素
	private Object[] elementData;
	//保存顺序表中元素的当前个数
	private int size;
	//以默认数组长度创建空顺序线性表
	public SequenceList(){
		capacity = DEFAULT_SIZE;
		elementData = new Object[capacity];
	}
	//以一个初始化元素来创建顺序线性表
	public SequenceList(T element){
		this();
		elementData[0] = element;
		size++;
	}
	 //以指定长度的数组来创建顺序线性表
	public SequenceList(T element, int initSize){
		capacity = DEFAULT_SIZE;
		//把capacity设置为大于initSize的最小的1.5的n次方
		while(capacity < initSize){
			capacity = capacity + capacity >> 1;
		}
		elementData = new Object[capacity];
		elementData[0] = element;
		size++;
	}
	//判断顺序线性表是否为空
	public boolean empty(){
		return size == 0;
	}
	//清空线性表
	public void clear(){
		Arrays.fill(elementData , null);
		/*等价于
		for(int i=0;i<size;i++){
			elementData[i] = null;
		}
		*/
        size = 0;  
	}
	//获取顺序线性表中索引为i处的元素
	public T get(int i){
		if(i<0 ||i>size-1){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		return (T) elementData[i];
	}
	//查找顺序线性表中指定元素的索引
	public int locate(T element){
		for(int i=0;i<size;i++){
			if(elementData[i].equals(element)){
				return i;
			}
		}
		return -1;
	}
	//获取线性表的大小
	public int length(){
		return size;
	}
	//向顺序线性表中的指定位置插入一个元素
	public void insert(T element, int index){
		if(index <0 || index > size){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		ensureCapacity(size + 1);
		//将index处以后的所有元素向后移动一格
		System.arraycopy(elementData, index, elementData, index+1, size - index);
		elementData[index] = element;
		size++;
	}
	//动态增加容量
	private void ensureCapacity(int minCapacity){
		//如果数组原有的长度小于目前所需要的长度
		if(minCapacity > capacity){
			while(minCapacity > capacity){
				capacity = capacity + capacity >> 1;
			}
			elementData = Arrays.copyOf(elementData, capacity);
		}
	}
	//在顺序线性表的最后添加一个元素
	public void add(T element){
		ensureCapacity(size + 1);
		elementData[size++] = element;
	}
	//删除顺序线性表中指定索引处的元素
	public T delete(int index){
		if(index < 0 || index < size){
			throw new IndexOutOfBoundsException("线性表索引越界");
		}
		T oldValue = (T) elementData[index];
		int numMoved = size -index - 1;
		if(numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index, numMoved);
		//清空最后一个元素
		elementData[--size] = null;
		return oldValue;
	}
	//点出顺序线性表的最后一个元素
	public T remove(){
		return delete(size-1);
	}
}
