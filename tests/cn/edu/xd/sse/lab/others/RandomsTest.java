package cn.edu.xd.sse.lab.others;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhiyongwang on 2016/5/20.
 * 单元测试
 */
public class RandomsTest {
    Randoms randoms = new Randoms();

    @Before
    public void setUp() throws Exception {
        System.out.println("before----");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after-----");
    }

    @Test
    public void testSystemCurrentTimeMillis() throws Exception {
        randoms.testSystemCurrentTimeMillis();
    }

    @Test
    public void testMathRandom() throws Exception {
        randoms.testMathRandom();
    }

    @Test
    public void testRandomAPI() throws Exception {
        randoms.testRandomAPI();
    }

}