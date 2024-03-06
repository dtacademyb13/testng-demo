package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priority {



    @Test (priority = 0, enabled = false)
    public void testA(){
        System.out.println("A");
    }

    @Ignore
    @Test (priority = -34)
    public void testB(){
        System.out.println("B");
    }

    @Test (priority = 1000, groups = "smoke")
    public void testC(){
        System.out.println("C");
    }

    @Test
    public void testD(){
        System.out.println("D");
    }

    @Test (priority = 2)
    public void testE(){
        System.out.println("E");
    }
}
