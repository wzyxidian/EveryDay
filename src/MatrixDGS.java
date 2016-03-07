import java.io.IOException;
import java.util.Scanner;


//连接矩阵有向图的深度优先遍历
public class MatrixDGS {
	 private char[] mVexs;       // 顶点集合
	    private int[][] mMatrix;    // 邻接矩阵

	    /* 
	     * 创建图(自己输入数据)
	     */
	    public MatrixDGS() {

	        // 输入"顶点数"和"边数"
	        System.out.printf("input vertex number: ");
	        int vlen = readInt();
	        System.out.printf("input edge number: ");
	        int elen = readInt();
	        if ( vlen < 1 || elen < 1 || (elen > (vlen*(vlen - 1)))) {
	            System.out.printf("input error: invalid parameters!\n");
	            return ;
	        }
	        
	        // 初始化"顶点"
	        mVexs = new char[vlen];
	        for (int i = 0; i < mVexs.length; i++) {
	            System.out.printf("vertex(%d): ", i);
	            mVexs[i] = readChar();
	        }

	        // 初始化"边"
	        mMatrix = new int[vlen][vlen];
	        for (int i = 0; i < elen; i++) {
	            // 读取边的起始顶点和结束顶点
	            System.out.printf("edge(%d):", i);
	            char c1 = readChar();
	            char c2 = readChar();
	            int p1 = getPosition(c1);
	            int p2 = getPosition(c2);

	            if (p1==-1 || p2==-1) {
	                System.out.printf("input error: invalid edge!\n");
	                return ;
	            }

	            mMatrix[p1][p2] = 1;
	        }
	    }

	    /*
	     * 创建图(用已提供的矩阵)
	     *
	     * 参数说明：
	     *     vexs  -- 顶点数组
	     *     edges -- 边数组
	     */
	    public MatrixDGS(char[] vexs, int[][] edges) {
	        
	        // 初始化"顶点数"和"边数"
	        int vlen = vexs.length;
	        int elen = edges.length;

	        // 初始化"顶点"
	        mVexs = new char[vlen];
	        for (int i = 0; i < mVexs.length; i++)
	            mVexs[i] = vexs[i];

	        // 初始化"边"
	        mMatrix = new int[vlen][vlen];
	        for (int i = 0; i < vlen; i++) {
	          for(int j=0;j<vlen;j++)
	        	  mMatrix[i][j] = edges[i][j];
	        }
	    }

	    /*
	     * 返回ch位置
	     */
	    private int getPosition(char ch) {
	        for(int i=0; i<mVexs.length; i++)
	            if(mVexs[i]==ch)
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

	    /*
	     * 深度优先遍历图
	     */
	    public void DFS(){
	    	boolean[] visited = new boolean[mVexs.length];//顶点的访问标志
	    	//初始化所有的顶点都没有被访问过
	    	for(int i=0;i<visited.length;i++)
	    		visited[i] = false;
	    	System.out.println("DFS遍历结果");
	    	for(int i=0;i<mVexs.length;i++){
	    		if(!visited[i])
	    			DFS(i,visited);
	    	}
	    }

	    /*
	     * 深度优先遍历递归实现
	     */
	    private void DFS(int i, boolean[] visited){
	    	visited[i] = true;
	    	System.out.println(mVexs[i] + " ");
	    	for(int w=firstVertex(i);w>=0;w=nextVertex(i,w))
	    		if(!visited[w])
	    			DFS(w,visited);
	    }
	    
	    /*
	     * 获取顶点v的第一个邻接顶点
	     */
	    private int firstVertex(int v){
	    	if(v<0 || v>(mVexs.length-1))
	    		return -1;
	    	for(int i=0;i<mVexs.length;i++)
	    		if(mMatrix[v][i] == 1)
	    			return i;
	    	return -1;
	    }

	    /*
	     * 获取顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
	     */
	    private int nextVertex(int v,int w){
	    	if(v<0 || v>(mVexs.length-1)||w<0||w>(mVexs.length-1))
	    		return -1;
	    	for(int i=w+1;i<mVexs.length;i++)
	    		if(mMatrix[v][i] == 1)
	    			return i;
	    	return -1;
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
	    			System.out.println(mVexs[i]+" ");
	    			queue[rear++] = i;
	    		}
	    		while(head != rear){
	    			int j = queue[head++];
	    			for(int k=firstVertex(j);k>=0;k=nextVertex(j,k)){
	    				if(!visited[k]){
	    					visited[k] = true;
	    					System.out.println(mVexs[k] + " ");
	    					queue[rear++] = k;
	    				}
	    			}
	    		}
	    	}
	    }

	    /*
	     * Prim建立最小生成树
	     */
	    public void prim(int start){
	    	int vlen = mVexs.length;
	    	char[] prims = new char[vlen];
	    	int[] weights = new int[vlen];
	    	int index = 0;
	    	prims[index++] = mVexs[start];
	    	for(int i=0;i<vlen;i++){
	    		weights[i]= mMatrix[start][i];
	    	}
	    	weights[start] = 0;
	    	for(int i=0;i<vlen;i++){
	    		if(start == i)
	    			continue;
	    		int j=0;
	    		int k = 0;
	    		int min = Integer.MAX_VALUE;
	    		while(j<vlen){
	    			if(weights[j]!=0&&weights[j]<min){
	    				min = weights[j];
	    				k = j;
	    			}
	    			j++;
	    		}
	    		prims[index++] = mVexs[k];
	    		weights[k] = 0;
	    		for(j=0;j<vlen;j++){
	    			if(weights[j] != 0 && mMatrix[k][j] < weights[j])
	    				weights[j] = mMatrix[k][j];
	    		}
	    	}
	    	
	    	int sum = 0;
	    	for(int i=1;i<index;i++){
	    		int min = Integer.MAX_VALUE;
	    		int n = getPosition(prims[i]);
	    		for(int j=0;j<i;j++){
	    			int m = getPosition(prims[j]);
	    			if(mMatrix[m][n] < min)
	    				min = mMatrix[m][n];
	    		}
	    		sum +=min;
	    	}
	    	//打印最小生成树
	    	System.out.println(mVexs[start]+" "+sum);
	    	for(int i=0;i<index;i++)
	    		System.out.println(prims[i]);
	    }
	    
	    public static void main(String[] args) {
	        char[] vexs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
	        int matrix[][] = {
	                 /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
	          /*A*/ {   0,  12, 100, 100, 100,  16,  14},
	          /*B*/ {  12,   0,  10, 100, 100,   7, 100},
	          /*C*/ { 100,  10,   0,   3,   5,   6, 100},
	          /*D*/ { 100, 100,   3,   0,   4, 100, 100},
	          /*E*/ { 100, 100,   5,   4,   0,   2,   8},
	          /*F*/ {  16,   7,   6, 100,   2,   0,   9},
	          /*G*/ {  14, 100, 100, 100,   8,   9,   0}};
	        MatrixDGS pG;

	        // 自定义"图"(输入矩阵队列)
	        //pG = new MatrixDGS();
	        // 采用已有的"图"
	        pG = new MatrixDGS(vexs, matrix);

	        //pG.print();   // 打印图
	        //pG.DFS();     // 深度优先遍历
	        //pG.BFS();     // 广度优先遍历
	        pG.prim(0);   // prim算法生成最小生成树
	    }
}
