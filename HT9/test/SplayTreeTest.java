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
public class SplayTreeTest {
    
    public SplayTreeTest() {
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
     * Test of get method, of class SplayTree.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        SplayTree<String,String> SPTree = null;
        SPTree = new SplayTree<>();
        SPTree.put("BOY", "CHICO");
        String actual1 = SPTree.get("BOY");
        String expected1 = "CHICO";
        
        assertEquals(expected1, actual1);
    }

    /**
     * Test of put method, of class SplayTree.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        SplayTree<String,String> SPTree = null;
        SPTree = new SplayTree<>();
        SPTree.put("CRAZY","LOCO");
        
        String actual1 = SPTree.get("CRAZY");
        String expected1 = "LOCO";
        
        if(actual1 != null){
            if(expected1.equals(actual1)){
                assertEquals(expected1, actual1);
            }else{
            fail("The test case is a prototype.");
            }
        }
    }
    
}
