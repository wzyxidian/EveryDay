import java.io.IOException;
import java.util.Scanner;


//无向图邻接表的遍历
public class ListUDGS {
	// 邻接表中表对应的链表的顶点
    private class ENode {
        int ivex;       // 该边所指向的顶点的位置
        int weight;     //该边的权值
        ENode nextEdge; // 指向下一条弧的指针
    }

    // 邻接表中表的顶点
    private class VNode {
        char data;          // 顶点信息
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    };

    private VNode[] mVexs;  // 顶点数组
    private int vlen;//顶点个数；
    private int elen;//边的个数

    /* 
     * 创建图(自己输入数据)
     */
    public ListUDGS() {

        // 输入"顶点数"和"边数"
        System.out.printf("input vertex number: ");
        vlen = readInt();
        System.out.printf("input edge number: ");
        elen = readInt();
        if ( vlen < 1 || elen < 1 || (elen > (vlen*(vlen - 1)))) {
            System.out.printf("input error: invalid parameters!\n");
            return ;
        }
        
        // 初始化"顶点"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            System.out.printf("vertex(%d): ", i);
            mVexs[i] = new VNode();
            mVexs[i].data = readChar();
            mVexs[i].firstEdge = null;
        }

        // 初始化"边"
        //mMatrix = new int[vlen][vlen];
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            System.out.printf("edge(%d):", i);
            char c1 = readChar();
            char c2 = readChar();
            int weight = readInt();
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);
            // 初始化node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            node1.weight = weight;
            // 将node1链接到"p1所在链表的末尾"
            if(mVexs[p1].firstEdge == null)
              mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // 初始化node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            node2.weight = weight;
            // 将node2链接到"p2所在链表的末尾"
            if(mVexs[p2].firstEdge == null)
              mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }

    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     edges -- 边数组
     */
    public ListUDGS(char[] vexs, EData[] edges) {
        
        // 初始化"顶点数"和"边数"
        vlen = vexs.length;
        elen = edges.length;

        // 初始化"顶点"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }

        // 初始化"边"
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            char c1 = edges[i].start;
            char c2 = edges[i].end;
            int weight = edges[i].weight;
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(c1);
            int p2 = getPosition(c2);

            // 初始化node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            node1.weight = weight;
            // 将node1链接到"p1所在链表的末尾"
            if(mVexs[p1].firstEdge == null)
              mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
            // 初始化node2
            ENode node2 = new ENode();
            node2.ivex = p1;
            node2.weight = weight;
            // 将node2链接到"p2所在链表的末尾"
            if(mVexs[p2].firstEdge == null)
              mVexs[p2].firstEdge = node2;
            else
                linkLast(mVexs[p2].firstEdge, node2);
        }
    }

    /*
     * 将node节点链接到list的最后
     */
    private void linkLast(ENode list, ENode node) {
        ENode p = list;

        while(p.nextEdge!=null)
            p = p.nextEdge;
        p.nextEdge = node;
    }

    /*
     * 返回ch位置
     */
    private int getPosition(char ch) {
        for(int i=0; i<mVexs.length; i++)
            if(mVexs[i].data==ch)
                return i;
        return -1;
    }

    /*
     * 读取一个输入字符
     */
    private char readChar() {
        char ch='0';

        do {
            try {
                ch = (char)System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } while(!((ch>='a'&&ch<='z') || (ch>='A'&&ch<='Z')));

        return ch;
    }

    /*
     * 读取一个输入字符
     */
    private int readInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    // 边的结构体
    private static class EData {
        char start; // 边的起点
        char end;   // 边的终点
        int weight; // 边的权重

        public EData(char start, char end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }
    /*
     * 深度优先遍历图
     */
    public void DFS(){
    	boolean[] visited = new boolean[mVexs.length];//顶点访问标记
    	//初始化所有的顶点都没有被访问
    	for(int i=0;i<mVexs.length;i++)
    		visited[i] = false;
    	System.out.println("DFS遍历结果");
    	for(int i=0;i<mVexs.length;i++){
    		if(!visited[i])
    			DFS(i,visited);
    	}   	
    }

    /*
     * 深度优先搜索递归实现
     */
    private void DFS(int i, boolean[] visited){
    	ENode node;
    	visited[i] = true;
    	System.out.println(mVexs[i]+" ");
    	node = mVexs[i].firstEdge;
    	while(node != null){
    		if(!visited[node.ivex]){
    			DFS(node.ivex,visited);
    		}
    		node = node.nextEdge;
    	}
    }

    /*
     * 广度优先遍历
     */
    public void BFS(){
    	int head = 0;
    	int rear = 0;
    	int[] queue = new int[mVexs.length];
    	boolean[] visited = new boolean[mVexs.length];
    	for(int i=0;i<mVexs.length;i++)
    		visited[i] = false;
    	for(int i=0;i<mVexs.length;i++){
    		if(!visited[i]){
    			visited[i] = true;
    			System.out.println(mVexs[i] + " ");
    			queue[rear++] = i;
    		}
    		while(head != rear){
    			int j = queue[head++];
    			ENode node = mVexs[j].firstEdge;
    			while(node != null){
    				if(!visited[node.ivex]){
    					visited[node.ivex] = true;
    					System.out.println(mVexs + " ");
    					queue[rear++] = node.ivex;
    				}
    				node = node.nextEdge;
    			}
    		}
    	}
    }

    /*
     * Prim最小生成树
     */
    public void prim(int start){
    	int index = 0;
    	int vlen = mVexs.length;
    	char[] prims = new char[vlen];
    	int[] weights = new int[vlen];
    	prims[index++] = mVexs[start].data;
    	for(int i=0;i<vlen;i++)
    		weights[i] = getWeight(start,i);
    	weights[start] =  0;
    	for(int i=0;i<vlen;i++){
    		if(start == i)
    			continue;
    		int j = 0;
    		int k = 0;
    		int min = Integer.MAX_VALUE;
    		while(j<vlen){
    			if(weights[j] != 0 && weights[j] < min){
        			min = weights[j];
        			k = j;
        		}
    			j++;
    		}
    		prims[index++] = mVexs[k].data;
    		weights[k] = 0;
    		for(j=0;j<vlen;j++){
    			int tmp = getWeight(k,j);
    			if(weights[j] != 0 && tmp < weights[j])
    				weights[j] = tmp;
    		}
    		
    		int sum = 0 ;
    		for(i=0;i<index;i++){
    			min = Integer.MAX_VALUE;
    			int n = getPosition(prims[i]);
    			for(j=0;j<i;j++){
    				int m = getPosition(prims[j]);
    				int tem = getWeight(n, m);
    				if(tem < min){
    					min = tem;
    				}
    			}
    			sum += min;
    		}
    		
    	}
    }
    
    /*
     * 取得边的最小值
     */
    private int getWeight(int start, int end){
    	if(start == end)
    		return 0;
    	ENode node = mVexs[start].firstEdge;
    	while(node != null){
    		if(node.ivex == end)
    			return node.weight;
    		node = node.nextEdge;
    	}
    	return Integer.MAX_VALUE;
    }

    /*
     * 克鲁斯卡尔（Kruskal)最小生成树
     */
    public void kruskal(){
    	int index = 0;
    	EData[] rets = new EData[elen];//结果数组，用于保存kruskal最小生成树的边
    	int[] vends = new int[elen];//用于存放已有最小生成树中每个顶点在该最小树中的终点
    	EData[] edges;
    	//获取图中所有的边
    	edges = getEdges();
    	sortEdges(edges);
    	for(int i=0;i<elen;i++){
    		int p1 = getPosition(edges[i].start);
    		int p2 = getPosition(edges[i].end);
    		
    		int m = getVend(vends,p1);
    		int n = getVend(vends,p2);
    		if(m != n){
    			vends[m] = n;
    			rets[index++] = edges[i];
    		}
    	}
    }
    
    /*
     * 获取图中所有的边
     */
    private EData[] getEdges(){
    	int index = 0;
    	EData[] edges = new EData[elen];
    	for(int i=0;i<vlen;i++){
    		ENode node = mVexs[i].firstEdge;
    		while(node != null){
    			if(node.ivex > i){
    				edges[index++] = new EData(mVexs[i].data,mVexs[node.ivex].data,node.weight);
    			}
    			node = node.nextEdge;
    		}
    	}
    	return edges;
    }

    /*
     * 对所有的边进行排序
     */
    private void sortEdges(EData[] edges){
    	for(int i=0;i<elen;i++){
    		for(int j=i+1;j<elen;j++){
    			if(edges[i].weight > edges[j].weight){
    				EData temp = edges[i];
    				edges[i] = edges[j];
    				edges[j] = edges[i];
    			}    				    			
    		}
    	}
    }

    /*
     * 得到i的终点
     */
    private int getVend(int[] vends, int i){
    	if(vends[i] != 0)
    		i = vends[i];
    	return i;
    }

    /*
     * Dijkstra最短路径
     * 即，统计图中"顶点vs"到其它各个顶点的最短路径。
     *
     * 参数说明：
     *     vs -- 起始顶点(start vertex)。即计算"顶点vs"到其它顶点的最短路径。
     *     prev -- 前驱顶点数组。即，prev[i]的值是"顶点vs"到"顶点i"的最短路径所经历的全部顶点中，位于"顶点i"之前的那个顶点。
     *     dist -- 长度数组。即，dist[i]是"顶点vs"到"顶点i"的最短路径的长度。
     */
    public void dijkstra(int vs, int[] prev, int[] dist){
    	 // flag[i]=true表示"顶点vs"到"顶点i"的最短路径已成功获取。
    	boolean[] flag = new boolean[mVexs.length];
    	
    	// 初始化
    	for(int i=0;i<mVexs.length;i++){
    		flag[i] = false;// 顶点i的最短路径还没获取到。
    		prev[i] = 0; // 顶点i的前驱顶点为0。
    		dist[i] = getWeight(vs,i);// 顶点i的最短路径为"顶点vs"到"顶点i"的权。
    	}
    	
    	// 对"顶点vs"自身进行初始化
    	flag[vs] = true;
    	dist[vs] = 0;
    	int k=0;
    	 // 遍历mVexs.length-1次；每次找出一个顶点的最短路径。
    	for(int i=0;i<mVexs.length;i++){
    		 // 寻找当前最小的路径；
            // 即，在未获取最短路径的顶点中，找到离vs最近的顶点(k)。
    		int min = Integer.MAX_VALUE;
    		for(int j=0;j<mVexs.length;j++){
    			if(flag[j] == false && dist[j] < min){
    				min = dist[j];
    				k = j;
    			}
    		}
    		
    		flag[k] = true;
    		for(int j=0;j<mVexs.length;j++){
    			int temp = getWeight(k,j);
    			temp = (temp == Integer.MAX_VALUE) ? Integer.MAX_VALUE : temp + min;
    			if(flag[j] == false && temp < dist[j]){
    				dist[j] = temp;
    				prev[j] = k;
    			}
    		}    		
    	}
    }
    
    /*
     * floyd最短路径。
     * 即，统计图中各个顶点间的最短路径。
     *
     * 参数说明：
     *     path -- 路径。path[i][j]=k表示，"顶点i"到"顶点j"的最短路径会经过顶点k。
     *     dist -- 长度数组。即，dist[i][j]=sum表示，"顶点i"到"顶点j"的最短路径的长度是sum。
     */
    public void floyd(int[][] path, int[][] dist){
    	 // 初始化
    	for(int i=0;i<mVexs.length;i++){
    		for(int j=0;j<mVexs.length;j++){
    			path[i][j] = j; // "顶点i"到"顶点j"的最短路径是经过顶点j。
    			dist[i][j] = getWeight(i,j); // "顶点i"到"顶点j"的路径长度为"i到j的权值"。
    		}
    	}
    	
    	for(int k=0;k<mVexs.length;k++){
    		for(int i=0;i<mVexs.length;i++){
    			for(int j=0;j<mVexs.length;j++){
    				 // 如果经过下标为k顶点路径比原两点间路径更短，则更新dist[i][j]和path[i][j]
    				int temp = (dist[i][k]==Integer.MAX_VALUE || dist[k][j]== Integer.MAX_VALUE) ? Integer.MAX_VALUE :dist[i][k]+dist[k][j];
    				if(temp <dist[i][j]){
    					 // "i到j最短路径"对应的值设，为更小的一个(即经过k)
    					dist[i][j] = temp;
    					// "i到j最短路径"对应的路径，经过k
    					path[i][j] = path[i][k];
    				}
    					
    					
    			}
    		}
    	}
    }
    
    public static void main(String[] args) {
        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        EData[] edges = {
                   // 起点 终点 权
            new EData('A', 'B', 12), 
            new EData('A', 'F', 16), 
            new EData('A', 'G', 14), 
            new EData('B', 'C', 10), 
            new EData('B', 'F',  7), 
            new EData('C', 'D',  3), 
            new EData('C', 'E',  5), 
            new EData('C', 'F',  6), 
            new EData('D', 'E',  4), 
            new EData('E', 'F',  2), 
            new EData('E', 'G',  8), 
            new EData('F', 'G',  9), 
        };
        ListUDGS pG;

        // 自定义"图"(输入矩阵队列)
        //pG = new ListUDG();
        // 采用已有的"图"
        pG = new ListUDGS(vexs, edges);

        //pG.print();   // 打印图
        //pG.DFS();     // 深度优先遍历
        //pG.BFS();     // 广度优先遍历
        //pG.prim(0);   // prim算法生成最小生成树

        pG.kruskal();   // Kruskal算法生成最小生成树
    }
}
