package ListenerDemo;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class TC001 {

    @Test(groups="sanity")
    public void test1(){
        System.out.println("test1");
        Assert.assertTrue(true);
    }
    @Test(groups="sanity")
    public void test2(){
        System.out.println("test2");
        Assert.assertTrue(true);
    }
    @Test(groups="sanity")
    public void test3(){
        System.out.println("test3");
        Assert.assertTrue(true);
    }
    @Test(groups="sanity")
    public void test4(){
        System.out.println("test4");
        Assert.assertTrue(true);
    }
    @Test(groups="sanity")
    public void test5(){
        System.out.println("test5");
        Assert.assertTrue(true);
    }
    @Test(groups="sanity")
    public void test6(){
        System.out.println("test6");
        Assert.assertTrue(true);
    }
    @Test(groups="sanity")
    public void test7(){
        System.out.println("test7");
        Assert.assertTrue(false);
    }
    @AfterSuite
    public void emailToQALead(){

    }
}
