
/** 
 * Java实现KMP算法 
 *  
 * 思想：每当一趟匹配过程中出现字符比较不等，不需要回溯i指针，  
 * 而是利用已经得到的“部分匹配”的结果将模式向右“滑动”尽可能远  
 * 的一段距离后，继续进行比较。 
 *  
 * 时间复杂度O(n+m) 
 *  
 */  
public class KMP {

	//通过计算返回字串t的next数组
	public int[] get_next(char[] t){
		int lengthT = t.length;
		int[] next = new int[lengthT];
		next[0] = -1;
		int i = 0;
		int j = -1;
		while(i < lengthT-1){
			//t.charAt(i)表示后缀的单个字符,t.charAt(j)表示前缀的单个字符
			if(j == -1 || t[i] == t[j]){
				++i;
				++j;
				next[i] = j;
			}else{
				//若字符不相同，则j值回溯
				j = next[j];
			}
		}
		return next;
	}
	//改进版求next
	public int[] get_nextval(char[] t){
		int[] nextval = new int[t.length];
		nextval[0] = -1;
		int i = 0;
		int j = -1;
		while(i < t.length - 1){
			if(j == -1 || t[i] == t[j]){
				++i;
				++j;
				if(t[i] != t[j]){
					nextval[i] = j;
				}else{
					nextval[i] = nextval[j];
				}
			}else{
				j = nextval[j];
			}
		}
		return nextval;
	}
	//s是主串，t是子串，匹配成功返回下标，匹配不成功返回-1
	public int kmp_Index(char[] s, char[] t){
		int[] next = get_nextval(t);
		int i = 0;
		int j = 0;
		while(i <= s.length - 1 && j <= t.length - 1){
			if(j == -1 || s[i] == t[j]){
				++i;
				++j;
			}else{
				j = next[j];
			}
		}
		if(j < t.length){
			return -1;
		}else{
			return i - t.length;
		}
			
		
	}
	public static void main(String[] args) {
		KMP kmp = new KMP();
		String s = "abbabbbbcab";
		String ss = "babbb";
		char[] s1 = s.toCharArray();
		char[] ss1 = ss.toCharArray();
		System.out.println(kmp.kmp_Index(s1, ss1));;
		
	}
}
