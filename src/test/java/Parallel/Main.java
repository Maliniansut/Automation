package Parallel;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {

    @BeforeTest
    public void beforeMethod(){
        long id= Thread.currentThread().getId();
        System.out.println("Before Test Method Thread id is:"+id+getClass().getSimpleName());
    }
    @Test
    public void testMethodsOne(){
        long id= Thread.currentThread().getId();
        System.out.println("Simple Test Method One Thread id is:"+id+getClass().getSimpleName());
    }
    @Test
    public void testMethodsTw0(){
        long id= Thread.currentThread().getId();
        System.out.println("Simple Test Method Two Thread id is:"+id+getClass().getSimpleName());
    }

    @AfterTest
    public void afterMethod(){
        long id = Thread.currentThread().getId();
        System.out.println("After Test Method Thread is is:"+id+getClass().getSimpleName());
    }

}
