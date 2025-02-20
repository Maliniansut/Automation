package TestNg;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class TestNg001 {

    @Test
    public void testCase1(){
        Assert.assertEquals(true,true);
    }

    @Test
    public void testCase2(){
        Assert.assertEquals(false,true);
    }
}
