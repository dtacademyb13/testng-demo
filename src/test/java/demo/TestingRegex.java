package demo;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestingRegex {



    @Test
    public void test_001_UI(){
        System.out.println("A");
    }


    @Test
    public void test_002_UI(){
        System.out.println("B");
    }

    @Test
    public void test_003_UI(){
        System.out.println("C");
    }

    @Test (groups = "smoke")
    public void tc_001_API(){
        System.out.println("D");
    }

    @Test
    public void tc_002_API(){
        System.out.println("E");
    }
}
