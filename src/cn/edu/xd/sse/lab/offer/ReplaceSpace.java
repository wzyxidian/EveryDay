package cn.edu.xd.sse.lab.offer;

/**
 * @author zhiyong wang
 *
 *
 *题目描述
 *请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 */
public class ReplaceSpace {
	/**
	 * 思路：调用String的replace方法直接进行替换
	 * @param str
	 * @return
	 */
		public String replaceSpace(StringBuffer str){
			if(str == null)
				return null;
			int len = str.length();
			String s = str.toString().replace(" ", "%20");
			return s;
		}
		
}
