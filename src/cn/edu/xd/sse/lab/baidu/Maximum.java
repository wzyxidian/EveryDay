package cn.edu.xd.sse.lab.baidu;

import java.util.Scanner;

/**
 * @author zhiyong wang
 * 题目：最大映射
 * 题目描述：
 * 
 * 有 n 个字符串，每个字符串都是由 A-J 的大写字符构成。现在你将每个字符映射为一个 0-9 的数字，
 * 不同字符映射为不同的数字。这样每个字符串就可以看做一个整数，
 * 唯一的要求是这些整数必须是正整数且它们的字符串不能有前导零。
 * 现在问你怎样映射字符才能使得这些字符串表示的整数之和最大？
 * 
 * 输入描述：
 * 
 * 每组测试用例仅包含一组数据，每组数据第一行为一个正整数 n ， 
 * 接下来有 n 行，每行一个长度不超过 12 且仅包含大写字母 A-J 的字符串。
 *  n 不大于 50，且至少存在一个字符不是任何字符串的首字母。
 *  
 *  输出描述:
 *  
 *  输出一个数，表示最大和是多少。
 *  
 *  
 *  输入例子:
 *  
 *  2
 *  ABC
 *  BCA
 *  
 *  
 *  输出例子:
 *  
 *  1875
 *  
 *  这个题关键点：用权重的思想来标记每一个字符，出现在个位标记为1，出现在十位标记为10，依次进行标记所有串，然后求和
 *  		   就能得到每个字符出现的权重。【注：这里有个地方要注意：至少有一个字符不能出现在首位，因为不能出现最大值为0的情况
 *  								所以要对每个字符用flag进行标记是否出现在首位，将没有出现的首位的最小值置为0】
 */
public class Maximum {
	static int[] num = new int[10];           //分别用来记录A-J每个字符映射的值
	static boolean[] flag = new boolean[10];  //分别用来标记A-J每个字符出现在字符串第一个位置的情况
    static long[] weight = new long[10];      //用来记录每个字符的权重
    
    /**
     * 实现思路：
     * 		第一步：计算出每个字符的权重。
     * 			
     *      第二步：根据权重计算出每个字符对应的数字
     *      	
     *      第三步：根据映射后的数字求得所有的字符串和
     * @param args
     */
    public static void main(String[] args) {
    	//获得输入
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();          //字符串个数
		String[] str = new String[num];    //用来存放字符串数组
		int i = 0;
		//通过控制台获得所有的字符串
		while(i < num){
			str[i] = scan.next();
			i++;
		}
		getWeight(str);      //得到每个字符的权重
		select();            //根据字符权重得到每个字符的映射
		sum(str);            //计算所有字符串映射为数字后的和
	}
    
    /**
     * 获得每个字符的权重
     * 方法：字符出现在个位的权重是1，十位的权重是10，百位的权重是100。。。。，
     * 		这样将每个字符在所有字符串中出现的情况进行统计，就得到了每个字符的权重
     * 		同时将出现在第一个位置的字符对应的flag位标记为true
     * @param str 输入的所有的字符串数组
     */
    private static void getWeight(String[] str){
    	for(int i = 0; i < str.length; i++){
    		char[] strTemp = str[i].toCharArray();
    		long tump = 1;
    		flag[strTemp[0] - 'A'] = true;
    		for(int j = strTemp.length - 1; j >= 0; j--){
    			weight[strTemp[j] - 'A'] += tump;
    			tump *= 10;
    		}
    	}
    }
    
    /**
     * 对字符进行映射选择
     * 方法：首先要得到权值小而且不能出现在首字母的字符，将其权值设为0，映射为0
     * 	         然后根据字符的权值，从大到小进行映射到num数组中，num的下标就是字符距离A的长度，num中的值就是字符对应的映射
     */
    private static void select(){
    	int k = -1;
    	long min = Long.MAX_VALUE;
    	for(int l = 0; l < weight.length; l++){
    		if(weight[l] < min && !flag[l]){
    			min = weight[l];
				k = l;
    		}	
    	}
    	
		weight[k] = 0;
    	num[k] = 0;		
    	
    	for(int i = 0; i < weight.length; i++){
    		k = -1; //注意这个地方不能赋值为0，不然为不断的替换，所以赋值应该为取值范围之外的数字
        	long max = 0;        	
    		for(int j = 0; j < weight.length; j++){
    			if(weight[j] > max){
    				max = weight[j];
    				k = j;
    			}
    		}
    		if(k != -1){
    			weight[k] = 0;  //选出值来之后将原来的值置为0，免得重复取值
        		num[k] = 9 - i; //根据权值从大到小进行映射
    		}
    		
    	}
    }
    
    /**
     * 进行求和运算
     * 方法：依次求得每个字符串的数值，然后相加。每个字符串的数值用atoi的思想，初值设为0，然后每次 * 10加上当前的值，一直循环到最后一位
     * @param str
     */
    private static void sum(String[] str){
    	long result = 0;
    	for(int i = 0; i < str.length; i++){
    		long resultTemp = 0;
    		for(int j = 0; j < str[i].length();j++){
    			resultTemp = resultTemp * 10 + num[str[i].charAt(j) -'A'];
    		}
    		result += resultTemp;
    	}
    	System.out.println(result);
    }   
}