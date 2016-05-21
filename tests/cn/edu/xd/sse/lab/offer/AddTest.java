package cn.edu.xd.sse.lab.offer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhiyongwang on 2016/5/21.
 */
public class AddTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("before");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("after");
    }

    @Test
    public void add() throws Exception {
        Add add = new Add();
        System.out.println(add.add(12, 13));
    }

}