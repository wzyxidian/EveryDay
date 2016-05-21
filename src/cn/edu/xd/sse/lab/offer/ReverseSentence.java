package cn.edu.xd.sse.lab.offer;

/**
 * Created by zhiyongwang on 2016/5/19.
 * 题目：翻转单词顺序列
 * 题目描述：牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。
 * 后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 */
public class ReverseSentence {

    /**
     * 方法一：
     * 思路： 采用旋转字符串方法，第一次将整个字符串进行前后交换，第二次将里面所有的以空格分离的字符串进行前后交换
     * 具体做法：首先判断字符串是否为null或者字符串是否仅仅包含空格
     * 然后将整个字符串进行前后交换
     * 接下来从头开始往后遍历字符串，定义两个自变量i:用来指向空格隔开的字符串的首个字母，j指向最后一个字母
     * 或者如果字符串不是以空格结束的话，j指向整个字符串的最后一个字母
     * 对每个空格隔离开的字符串进行前后交换
     *
     * @param str
     * @return
     */
    public String reverseSentence(String str) {
        if (str == null)
            return "";
        if (str.trim().equals(""))
            return str;
        char[] ch = str.toCharArray();
        int length = ch.length;
        exchange(ch, 0, length - 1);
        for (int i = 0, j = 0; j < length; j++) {
            if (ch[i] != ' ' && ch[j] == ' ') {
                exchange(ch, i, j - 1);
                ++j;
                i = j;
            }
            if (ch[i] != ' ' && j == length - 1) {
                exchange(ch, i, j);
            }
            if (ch[i] == ' ')
                i++;
        }
        return String.valueOf(ch);
    }

    /**
     * 对字符串的前后字符进行交换
     *
     * @param ch
     * @param start
     * @param end
     */
    private void exchange(char[] ch, int start, int end) {
        for (int i = start, j = end; i <= j; ++i, --j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
        }
    }

    /**
     * 方法二：
     * 思路
     * 首先判断字符串是否是null，或者是否是仅仅包含空格
     * 然后通过String的split以空格为分隔符，将字符串分成一个字符串数组，
     * 新建一个StringBuffer对象sb，从后往前遍历字符串数组，将其append到sb中，同时append上一个空格，
     * 注意最后一个字符串append之后，不再添加空格
     *
     * @param str 待处理的字符串
     * @return
     */
    public String reverseSentence1(String str) {
        if (str == null)
            return null;
        if (str.trim().equals(""))
            return str;
        String[] strArray = str.split(" ");
        int length = strArray.length;
        StringBuffer sb = new StringBuffer();
        for (int i = length - 1; i >= 0; i--) {
            if (i == 0) {
                sb.append(strArray[i]);
            } else {
                sb.append(strArray[i]).append(" ");
            }
        }
        return sb.toString();
    }
}
