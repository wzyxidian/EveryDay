
/**
 * @author zhiyong wang
 *递归生成码表
 *这种方法基于格雷码是反射码的事实，利用递归的如下规则来构造：
 *
 *    1位格雷码有两个码字
 *    (n+1)位格雷码中的前2n个码字等于n位格雷码的码字，按顺序书写，加前缀0
 *    (n+1)位格雷码中的后2n个码字等于n位格雷码的码字，按逆序书写，加前缀1[3] 
 *    n+1位格雷码的集合 = n位格雷码集合(顺序)加前缀0 + n位格雷码集合(逆序)加前缀1
 *
 *2位格雷码	3位格雷码	4位格雷码	4位自然二进制码
 *00
 *01
 *11
 *10
 *	
 *000
 *001
 *011
 *010
 *110
 *111
 *101
 *100
 *	
 *0000
 *0001
 *0011
 *0010
 *0110
 *0111
 *0101
 *0100
 *1100
 *1101
 *1111
 *1110
 *1010
 *1011
 *1001
 *1000
 *	
 *0000
 *0001
 *0010
 *0011
 *0100
 *0101
 *0110
 *0111
 *1000
 *1001
 *1010
 *1011
 *1100
 *1101
 *1110
 *1111
 */
public class GrayCode {

	public String[] getGrayCode(int n){
		String[] grayCode = new String[(int) Math.pow(2, n)];
		if(n == 1){
			grayCode[0] = "0";
			grayCode[1] = "1";
			return grayCode;
		}
		String[] grayCodePre = getGrayCode(n - 1);
		for(int i = 0; i < grayCodePre.length;i++){
			grayCode[i] = "0" + grayCodePre[i];
			grayCode[grayCode.length - 1 - i] = 1 + grayCodePre[i];
		}
		return grayCode;
	}
}
