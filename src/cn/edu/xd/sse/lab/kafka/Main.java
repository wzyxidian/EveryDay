package cn.edu.xd.sse.lab.kafka;

/**
 * @author zhiyong wang
 * 
 */
public class Main {

	public static void main(String[] args) {
		Main main = new Main();
		main.stoi("7ab7ab7a2b6ab");
	}

	/**
	 * @param String
	 *            s 输入最原始的字符串
	 * @see 将字符串转换成具体的01串，遇到数字就跳过，不是数字，判断他的前一位是不是0-9，如果是在追加多少个0或1，如果不是，则追加一个0或1
	 */
	public String stos(String s) {
		// 判断输入的特殊情况
		if (s == null || s.length() == 0)
			return null;
		int len = s.length();
		char[] charTemp = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (charTemp[i] >= '0' && charTemp[i] <= '9') {
				continue;
			} else {
				// 当第一位就是字母的时候
				if (i == 0) {
					if (charTemp[i] == 'a')
						sb.append("0");
					else
						sb.append("1");
				} else {
					// 当字母前一位是数字时
					if (charTemp[i - 1] >= '0' && charTemp[i - 1] <= '9') {
						int tempNum = charTemp[i - 1] - '0';
						while (tempNum > 0) {
							if (charTemp[i] == 'a')
								sb.append("0");
							else
								sb.append("1");
							tempNum--;
						}
					}
					// 字母前一位不是数字时
					else {
						if (charTemp[i] == 'a')
							sb.append("0");
						else
							sb.append("1");
					}
				}

			}
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	/**
	 *
	 * @param s
	 * @return 最后的IP地址
	 */
	public String stoi(String s) {

		StringBuilder sb = new StringBuilder();
		String str = stos(s);
		int index = 0;
		// 每8位二进制转换为对应的十进制，然后最后添加“.”
		while (index < 32) {
			String temp = str.substring(index, index + 8);
			String r1 = Integer.valueOf(temp, 2).toString();
			sb.append(r1).append(".");
			index = index + 8;
		}
		// 由于多加了一个点，所以去掉最后一个点
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb.toString());
		return sb.toString();
	}
}
