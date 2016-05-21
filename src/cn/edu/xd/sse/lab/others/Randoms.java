package cn.edu.xd.sse.lab.others;

import java.util.Random;

/**
 * Created by zhiyongwang on 2016/5/19.
 * 求随机数的方法
 * java 的随机数测试程序。共3种获取随机数的方法：
 * 6*   (01)、通过System.currentTimeMillis()来获取一个当前时间毫秒数的long型数字。
 * 7*   (02)、通过Math.random()返回一个0到1之间的double值。
 * 8*   (03)、通过Random类来产生一个随机数，这个是专业的Random工具类，功能强大。
 */
public class Randoms {

    /**
     * 通过System的currentTimeMillis()返回随机数
     */
    public void testSystemCurrentTimeMillis() {
        long l = System.currentTimeMillis();
        int ran = (int) (l % 100);
        System.out.println("---- System.currentTimeMillis() ----" + ran);
    }

    /**
     * 通过Math的random()返回随机数
     */
    public void testMathRandom() {
        double d = Math.random();
        int ran = (int) (d * 100);
        System.out.println("---- Math.random() ----" + ran);
    }

    /**
     * Random的API测试
     */
    public void testRandomAPI() {
        Random random = new Random();
        boolean b = random.nextBoolean();
        int i1 = random.nextInt();
        int i2 = random.nextInt(100);
        long l = random.nextLong();
        float f = random.nextFloat();
        double d = random.nextDouble();
        byte[] bt = new byte[5];
        random.nextBytes(bt);
        System.out.println("---random.nextInt()---" + i1);
        System.out.println("---random.nextInt(100)---" + i2);
        System.out.println("---random.nextLong()---" + l);
        System.out.println("---random.nextFloat()---" + f);
        System.out.println("---random.nextDouble()---" + d);
        System.out.println("---random.nextBoolean()---" + String.valueOf(b));
        for (byte bb : bt) {
            System.out.println(bb);
        }
    }
}
