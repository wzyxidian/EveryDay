import java.io.IOException;
import java.util.Scanner;


//邻接矩阵的无向图的深度与广度优先遍历
//邻接矩阵的无向图的Prim算法，求最小生成树
public class MatrixUDGS {
	private char[] mVexs;       // 顶点集合
    private int[][] mMatrix;    // 邻接矩阵

    /* 
     * 创建图(自己输入数据)
     */
    public MatrixUDGS() {

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
            mMatrix[p2][p1] = 1;
        }
    }

    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     edges -- 边数组
     */
    public MatrixUDGS(char[] vexs, int[][] edges) {
        
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
     * 深度优先搜索遍历图
     */
    public void DFS(){
    	boolean[] visited = new boolean[mVexs.length]; //顶点访问标记
    	//初始化所有的顶点都没有被访问
    	for(int i=0;i<mVexs.length;i++)
    		visited[i] = false;
    	System.out.println("DFS遍历结果：");
    	for(int i=0;i<mVexs.length;i++){
    		if(!visited[i])
    			DFS(i,visited);
    	}
    	System.out.println("\n");   	
    }
    
    /*
     * 深度优先搜索遍历图的递归实现
     */
    private void DFS(int i, boolean[] visited){
    	visited[i] = true;
    	System.out.println(mVexs[i]+ " ");
    	//遍历该顶点的所有的邻接顶点，若是没有访问过，那么继续往下访问
    	for(int w= firstVertex(i);w>=0;w=nextVertex(i,w)){
    		if(!visited[w])
    			DFS(w,visited);
    	}
    }
    
    /*
     * 返回顶点v的第一个邻接顶点的索引，失败则返回-1
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
     * 返回顶点v相对于w的下一个邻接顶点的索引，失败则返回-1
     */
    private int nextVertex(int v, int w){
    	if(v<0||v>(mVexs.length-1)||w<0||w>(mVexs.length))
    		return -1;
    	for(int i=w+1;i<mVexs.length;i++)
    		if(mMatrix[v][i] == 1)
    			return i;
    	return -1;
    }

    /*
     * 广度优先搜索
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
    			for(int k = firstVertex(j);k>=0;k=nextVertex(j,k))
    				if(!visited[k]){
    					visited[k]= true;
    					System.out.println(mVexs[k]+" ");
    					queue[rear++] = k;
    				}
    		}
    	}
    }

    /*
     * prime最小生成树
     * 
     * 参数说明：
     * 	 start -- 从图中的第start个元素开始，生成最小树
     * 生成最小数的思想：维持两个顶点集合，一个是已经遍历的，一个是没有遍历的，然后取已经遍历的顶点集合到没有遍历的连接线的最小值对应的
     * 顶点作为下一个遍历顶点。
     * 具体实现过程：维持两个数组，第一个数组用来存放遍历的顶点顺序，第二个数组用来存放已经遍历的顶点与没有遍历的顶点之间的连接线的最小值
     */
    public void prim(int start){
    	int vlen = mVexs.length;
    	char[] prims = new char[vlen];//prim最小树的结果数组
    	int[] weights = new int[vlen];//顶点间边的权值
    	int index = 0;//prim最小树的索引，即prims数组的索引，从0个位置开始存放
    	prims[index++] = mVexs[start];//prim最小生成树中第一个数是"图中第start个顶点"，因为是从start开始的。
    	//初始化"顶点的权值数组"，
    	//将每个顶点的权值初始化为"第start个顶点"到"该顶点"的权值
    	for(int i=0;i<vlen;i++)
    		weights[i] = mMatrix[start][i];
    	// 将第start个顶点的权值初始化为0。
        // 可以理解为"第start个顶点到它自身的距离为0"。
    	weights[start] = 0;
    	for(int i=0;i<vlen;i++){
    		//由于从start开始的，因此不需要在对第start个 顶点进行处理
    		if(start == i) 
    			continue;
    		int j = 0;
    		int k = 0;
    		int min = Integer.MAX_VALUE;
    		//在未加入到最小生成树的顶点中，找出权值最小的顶点
    		while(j<vlen){
    			 // 若weights[j]=0，意味着"第j个节点已经被排序过"(或者说已经加入了最小生成树中)。
    			if(weights[j]!=0&&weights[j]<min){
    				min = weights[j];
    				k = j;
    			}
    			j++;
    		}
    		 // 经过上面的处理后，在未被加入到最小生成树的顶点中，权值最小的顶点是第k个顶点。
            // 将第k个顶点加入到最小生成树的结果数组中
    		prims[index++] = mVexs[k];
    		// 将"第k个顶点的权值"标记为0，意味着第k个顶点已经排序过了(或者说已经加入了最小树结果中)。
    		weights[k] = 0;
    		// 当第k个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值。
    		for(j=0;j<vlen;j++){
    			 // 当第j个节点没有被处理，并且需要更新时才被更新。
    			if(weights[j]!=0 && mMatrix[k][j]<weights[j])
    				weights[i] = mMatrix[k][j];
    		}
    	}
    	//计算最小生成树的权值
    	int sum = 0;
    	for(int i=1;i<index;i++){
    		int min = Integer.MAX_VALUE;
    		int n = getPosition(prims[i]);
    		 // 在vexs[0...i]中，找出到j的权值最小的顶点。
    		for(int j=0;j<i;j++){
    			int m = getPosition(prims[j]);
    			if(mMatrix[m][n]<min)
    				min = mMatrix[m][n];
    		}
    		sum += min;
    	}   	
    }
}
