/*
 * TestBinaryTree.java          08/10/2020
 * No copyright, no right
 */ 

package fr._1irda.binarytree.tests;

import fr._1irda.binarytree.BinaryTree;

/**
 * Test class of BinaryTree class methods
 * BinaryTree it's a generic class to build a binary tree with
 * generic values
 */
public class TestBinaryTree {

    /*
     * Add all values 
     */ 
    public static int[] UNIQUE_INT_TO_ADD = { -487, 58, 98, -98, 0, Integer.MIN_VALUE };

    /*
     * Add only the half of the values
     */
    public static int[] SAME_INT_TO_ADD = { -487, Integer.MIN_VALUE, Integer.MIN_VALUE, 0, -487, -0 };

    /*
     * Add all values
     */
    public static double[] UNIQUE_DOUBLE_TO_ADD = { -487.0, 58.4, 98.8, -98.8, -0.0, 0.0 };

    /*
     * Add the half of the values
     */ 
    public static double[] SAME_DOUBLE_TO_ADD = { -87.2, 54.5, Double.MAX_VALUE, Double.MAX_VALUE, -87.2, 54.5 };

    /*
     * Add all values
     */ 
    public static String[] UNIQUE_STR_TO_ADD = { "BinaryTree", "Node", "Integer" };

    /*
     * Add the half of the values
     */
    public static String[] SAME_STR_TO_ADD = { 
        "Integer", "BinaryTree", "BinaryTree", "Node", "Integer", "Node"
    };
 
    /**
     * Add unique int values
     */
    public static int[][] TO_ADD = {                                 
        { 0, 12, 54 },                      // height of tree after adding : 3          
        { 54, 20, -89, -78, 5 },            // height of tree after adding : 5
        { -785 },                           // height of tree after adding : 1   
        { 1, 4 }                            // height of tree after adding : 0
    };

    public static int NB_THROUGH_TEST = 2;
  
    /**
     * Launch tests 
     * @param args unused
     */
    public static void main(String[] args) {
        // tests add node
        testAddNodeUniqueIntValues();
        testAddNodeSameIntValues();
        testAddNodeUniqueDoubleValues();
        testAddNodeSameDoubleValues();
        testAddNodeUniqueStrValues();
        testAddNodeSameStrValues();
        
        // test isPresent
        testIsPresent();

        // test getHeight
        testGetHeight();

        // test removeNode
        testRemoveNode();

        // test through
        testPrefix();
        testInfix();
        testPostfix();

        // test removeNode
        testRemoveNode();
    }

    /**
     * Test method addNode
     * Add only differents integers values
     */
    public static void testAddNodeUniqueIntValues() {
        boolean isAdded;
        int nbSuccess = 0;
        BinaryTree<Integer> bTree = new BinaryTree<Integer>();

        System.out.println("Test : addNodeUniqueIntValues");
        
        for (int i = 0; i < UNIQUE_INT_TO_ADD.length; i++) {
            isAdded = bTree.addNode(UNIQUE_INT_TO_ADD[i]);

            if (isAdded) {
                nbSuccess++;
            }
        }
        System.out.println("Passed tests : " + nbSuccess + "/" + UNIQUE_INT_TO_ADD.length);
    }

    /**
     * Test method addNode
     * Add same integers values
     */
    public static void testAddNodeSameIntValues() {
        boolean isAdded;
        int nbSuccess = 0;
        BinaryTree<Integer> bTree = new BinaryTree<Integer>();

        System.out.println("Test : addNodeSameIntValues");

        for (int i = 0; i < SAME_INT_TO_ADD.length; i++) {
            isAdded = bTree.addNode(SAME_INT_TO_ADD[i]);

            if (isAdded) {
                nbSuccess++;
            }
        }
        System.out.println("Passed tests : " + nbSuccess + "/" + UNIQUE_INT_TO_ADD.length / 2);
    }

    /**
     * Test method addNode
     * Add only differents double values
     */
    public static void testAddNodeUniqueDoubleValues() {
        boolean isAdded;
        int nbSuccess = 0;
        BinaryTree<Double> bTree = new BinaryTree<Double>();

        System.out.println("Test : addNodeUniqueDoubleValues");
        
        for (int i = 0; i < UNIQUE_DOUBLE_TO_ADD.length; i++) {
            isAdded = bTree.addNode(UNIQUE_DOUBLE_TO_ADD[i]);

            if (isAdded) {
                nbSuccess++;
            }
        }
        System.out.println("Passed tests : " + nbSuccess + "/" + UNIQUE_DOUBLE_TO_ADD.length);
    }

    /**
     * Test method addNode
     * Add same double values
     */
    public static void testAddNodeSameDoubleValues() {
        boolean isAdded;
        int nbSuccess = 0;
        BinaryTree<Double> bTree = new BinaryTree<Double>();

        System.out.println("Test : addNodeSameDoubleValues");
        
        for (int i = 0; i < SAME_DOUBLE_TO_ADD.length; i++) {
            isAdded = bTree.addNode(SAME_DOUBLE_TO_ADD[i]);

            if (isAdded) {
                nbSuccess++;
            }
        }
        System.out.println("Passed tests : " + nbSuccess + "/" + SAME_DOUBLE_TO_ADD.length / 2);
    }

    /**
     * Test method addNode
     * Add differents string
     */
    public static void testAddNodeUniqueStrValues() {
        boolean isAdded;
        int nbSuccess = 0;
        BinaryTree<String> bTree = new BinaryTree<String>();

        System.out.println("Test : addNodeUniqueStrValues");
        
        for (int i = 0; i < UNIQUE_STR_TO_ADD.length; i++) {
            isAdded = bTree.addNode(UNIQUE_STR_TO_ADD[i]);

            if (isAdded) {
                nbSuccess++;
            }
        }
        System.out.println("Passed tests : " + nbSuccess + "/" + UNIQUE_STR_TO_ADD.length);
    }

    /**
     * Test method addNode
     * Add same string
     */
    public static void testAddNodeSameStrValues() {
        boolean isAdded;
        int nbSuccess = 0;
        BinaryTree<String> bTree = new BinaryTree<String>();

        System.out.println("Test : addNodeSameStrValues");
        
        for (int i = 0; i < SAME_STR_TO_ADD.length; i++) {
            isAdded = bTree.addNode(SAME_STR_TO_ADD[i]);

            if (isAdded) {
                nbSuccess++;
            }
        }
        System.out.println("Passed tests : " + nbSuccess + "/" + SAME_STR_TO_ADD.length / 2);
    }

    /**
     * Test prefix through
     */
    public static void testPrefix() {
        int nbSuccess = 0;
        BinaryTree<Integer> bTree = new BinaryTree<Integer>();
        String expectedResult, result;

        System.out.println("Test : testPrefix");

        // unique int 

        for (int i = 0; i < UNIQUE_INT_TO_ADD.length; i++) {
            bTree.addNode(UNIQUE_INT_TO_ADD[i]);
        }

        expectedResult = "-487 -2147483648 58 -98 0 98 ";

        result = bTree.prefix();

        if (expectedResult.equals(result)) {
            nbSuccess++;
        }
        
        bTree.empty();

        // same int 

        for (int i = 0; i < SAME_INT_TO_ADD.length; i++) {
            bTree.addNode(SAME_INT_TO_ADD[i]);
        }

        expectedResult = "-487 -2147483648 0 ";

        result = bTree.prefix();

        if (expectedResult.equals(result)) {
            nbSuccess++;
        }

        System.out.println("Passed tests : " + nbSuccess + "/" + 2);
    }

    /**
     * Test infix through
     */
    public static void testInfix() {
        int nbSuccess = 0;
        BinaryTree<Double> bTree = new BinaryTree<Double>();
        String expectedResult, result;

        System.out.println("Test : testInfix");

        // unique double 

        for (int i = 0; i < UNIQUE_DOUBLE_TO_ADD.length; i++) {
            bTree.addNode(UNIQUE_DOUBLE_TO_ADD[i]);
        }

        expectedResult = "-487.0 -98.8 -0.0 0.0 58.4 98.8 ";

        result = bTree.infix();

        if (expectedResult.equals(result)) {
            nbSuccess++;
        }

        bTree.empty();

        // same double 

        for (int i = 0; i < SAME_DOUBLE_TO_ADD.length; i++) {
            bTree.addNode(SAME_DOUBLE_TO_ADD[i]);
        }

        expectedResult = "-87.2 54.5 1.7976931348623157E308 ";

        result = bTree.infix();

        if (expectedResult.equals(result)) {
            nbSuccess++;
        }

        System.out.println("Passed tests : " + nbSuccess + "/" + NB_THROUGH_TEST);
    }

    /**
     * Test postfix through
     */
    public static void testPostfix() {
        int nbSuccess = 0;
        BinaryTree<String> bTree = new BinaryTree<String>();
        String expectedResult, result;

        System.out.println("Test : testPostfix");

        // unique string 

        for (int i = 0; i < UNIQUE_STR_TO_ADD.length; i++) {
            bTree.addNode(UNIQUE_STR_TO_ADD[i]);
        }

        expectedResult = "Integer Node BinaryTree ";

        result = bTree.postfix();

        if (expectedResult.equals(result)) {
            nbSuccess++;
        }

        bTree.empty();

        // same string 

        for (int i = 0; i < SAME_STR_TO_ADD.length; i++) {
            bTree.addNode(SAME_STR_TO_ADD[i]);
        }

        expectedResult = "BinaryTree Node Integer ";

        result = bTree.postfix();

        if (expectedResult.equals(result)) {
            nbSuccess++;
        }

        System.out.println("Passed tests : " + nbSuccess + "/" + NB_THROUGH_TEST);
    }

    /**
     * Test method isPresent
     */
    public static void testIsPresent() {
        boolean isPresent;
        int nbSuccess = 0;
        BinaryTree<Integer> bTree = new BinaryTree<Integer>();

        System.out.println("Test : isPresent");

        for (int i = 0; i < TO_ADD.length; i++) {
            for (int j = 0; j < TO_ADD[i].length; j++) {
                bTree.addNode(TO_ADD[i][j]);
            }
            isPresent = bTree.isPresent(TO_ADD[i][0]);

            if (isPresent) {
                nbSuccess++;
            }
        }
        System.out.println("Passed tests : " + nbSuccess + "/" + TO_ADD.length);
    }

    /*
     * Test method getHeight
     */ 
    public static void testGetHeight() {
        int nbSuccess = 0;
        BinaryTree<Integer> bTree = new BinaryTree<Integer>();

        System.out.println("Test : getHeight");

        for (int i = 0; i < TO_ADD.length; i++) {
            for (int j = 0; j < TO_ADD[i].length; j++) {
                bTree.addNode(TO_ADD[i][j]);
            }
            
            if (bTree.getHeight() == TO_ADD[i].length) {
                nbSuccess++;
            }
            
            bTree.empty();
        }
        System.out.println("Passed test : " + nbSuccess + "/" + TO_ADD.length);
    }

    /**
     * Test remove node
     */
    public static void testRemoveNode() {
        int nbSuccess = 0;
        BinaryTree<Integer> bTree = new BinaryTree<Integer>();
        String[] expectedResult = {
            "12 54 ",
            "20 -89 -78 5 ",
            "Empty tree.",
            "4 "
        }; 
        String result;

        System.out.println("Test : removeNode");

        for (int i = 0; i < TO_ADD.length; i++) {
            for (int j = 0; j < TO_ADD[i].length; j++) {
                bTree.addNode(TO_ADD[i][j]);
            }
            bTree.removeNode(TO_ADD[i][0]);
            result = bTree.prefix();
            bTree.empty();
            if (result.equals(expectedResult[i])) {
                nbSuccess++;
            }
        }
        System.out.println("Passed test : " + nbSuccess + "/" + TO_ADD.length);
    }
}