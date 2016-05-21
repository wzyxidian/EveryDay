package cn.edu.xd.sse.lab.offer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhiyongwang on 2016/5/20.
 */
public class SumTest {
    Sum sum = new Sum();

    @Before
    public void setUp() throws Exception {
        System.out.println("before sum ----");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after sum -----");
    }

    @Test
    public void sum_Solution() throws Exception {
        sum.sum_Solution(4);
    }

    @Test
    public void sum_Solution1() throws Exception {
        sum.sum_Solution1(4);
    }

}