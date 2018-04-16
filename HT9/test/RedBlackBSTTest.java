/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author David
 */
public class RedBlackBSTTest {
    
    public RedBlackBSTTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of get method, of class RedBlackBST.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        RedBlackBST<String,String> RBTree = null;
        RBTree = new RedBlackBST<>();
        RBTree.put("ICE", "HIELO");
        String actual1 = RBTree.get("ICE");
        String expected1 = "HIELO";
        
        assertEquals(expected1, actual1);
    }
    
    /**
     * Test of put method, of class RedBlackBST.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        RedBlackBST<String,String> RBTree = null;
        RBTree = new RedBlackBST<>();
        RBTree.put("CHILD","NINO");
        
        String actual1 = RBTree.get("CHILD");
        String expected1 = "NINO";
        
        if(actual1 != null){
            if(expected1.equals(actual1)){
                assertEquals(expected1, actual1);
            }else{
            fail("The test case is a prototype.");
            }
        }
    }       
}
