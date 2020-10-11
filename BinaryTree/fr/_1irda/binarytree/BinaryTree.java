/*
 * BinaryTree.java          08/10/2020
 * No copyright, no right
 */ 
package fr._1irda.binarytree;

/**
 * Class who represent a binary tree
 * A binary tree contains one or several node
 * @version 1.0
 * @author Adrien Garrouste
 */
public class BinaryTree<T extends Comparable<T>> {

    private Node<T> rootNode;

    /**
     * Default constructor
     * Initialize root node to null
     */
    public BinaryTree() {
        this.rootNode = null;
    }

    /**
     * Initialize the binary tree with a root node
     * @param rootNode the root node to build the tree
     */
    public BinaryTree(T toAdd) {
        this.rootNode = new Node<T>(toAdd);
    }

    /**
     * Add a node to the binary tree
     * @param toAdd the node value to add
     * @return true if node is added
     */
    public boolean addNode(T toAdd) {
        if (this.rootNode == null) {
            this.rootNode = new Node<T>(toAdd);
            return true;
        } else {
            return this.rootNode.addNode(toAdd);
        }
    }

    /**
     * Display all values in tree
     */
    public void display() {
        if (this.rootNode == null) {
            System.out.println("Empty tree.");
        } else {
            this.rootNode.display();
        }

    }

    /**
     * Display all nodes value in tree in ascending order
     */
    public void displayAscendingOrder() {
        if (this.rootNode == null) {
            System.out.println("Empty binary tree.");
        } else {
            this.rootNode.displayAscendingOrder();
        }
        System.out.println();
    }

    /**
     * Prefix through
     * @return string with nodes 
     */
    public String prefix() {
        if (this.rootNode == null) {
            return "Empty tree.";
        } else {
            return this.rootNode.prefix().toString();
        }
    }

    /**
     * Infix through
     * @return string with nodes
     */
    public String infix() {
        if (this.rootNode == null) {
            return "Empty tree.";
        } else {
            return this.rootNode.infix().toString();
        }
    }

    /**
     * Postfix through
     * @return string with nodes
     */
    public String postfix() {
        if (this.rootNode == null) {
            return "Empty tree.";
        } else {
            return this.rootNode.postfix().toString();
        }
    }

    /**
     * Determine if a value is in the tree
     * @param searchedValue the value to search
     * @return true if searchedValue is in the tree
     */
    public boolean isPresent(T searchedValue) {
        if (this.rootNode == null) {
            return false;
        } else {
            return this.rootNode.isPresent(searchedValue);
        }
    }

    /**
     * Determine the tree height
     * @return the tree height
     */
    public int getHeight() {
        if (this.rootNode == null) {
            return 0;
        } else {
            return this.rootNode.getHeight();
        }
    }

    /**
     * Empty the node
     */
    public void empty() {
        this.rootNode = null;
    }

    /**
     * Remove the node who has the value toRemove
     * @param toRemove the value to remove
     * @return true if removed
     */
    public boolean removeNode(T toRemove) {
        if (this.rootNode == null) {
            return false;
        } else if (this.rootNode.getValue().compareTo(toRemove) == 0) {
            if (this.rootNode.getNodeGreaterValue() == null && this.rootNode.getNodeSmallerValue() == null) {
                this.rootNode = null;
                return true;
            } else {
                if (this.rootNode.getNodeGreaterValue() == null) {
                    this.rootNode = this.rootNode.getNodeSmallerValue();
                } else if (this.rootNode.getNodeSmallerValue() == null) {
                    this.rootNode = this.rootNode.getNodeGreaterValue();
                } else {
                    Node<T> toMove = this.rootNode.getNodeSmallerValue().biggerNode();
                    this.rootNode.getNodeSmallerValue().removeNode(this.rootNode, toMove.getValue());
                    this.rootNode.setValue(toMove.getValue());
                }
                return true;
            }
        } else if (this.rootNode.getValue().compareTo(toRemove) < 0) {
            return this.rootNode.getNodeGreaterValue().removeNode(rootNode, toRemove);
        } else {
            return this.rootNode.getNodeSmallerValue().removeNode(rootNode, toRemove);
        }
    }
}