package cn.edu.xd.sse.lab.offer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhiyongwang on 2016/5/21.
 */
public class StrToIntTest {
    @Before
    public void setUp() throws Exception {
        System.out.println("stoi Start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("stoi end");
    }

    @Test
    public void strToInt() throws Exception {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.strToInt("2323d34"));
    }

}