/*
 * Node.java            08/10/2020 
 * No copyright, no right
 */

package fr._1irda.binarytree;

/**
 * This class represent a node in a binary tree
 * A node has : 
 * - a value
 * - a pointer to a sub node with a lower value than the node
 * - a pointer to a sub node with a greater value than the node 
 * @version 1.0
 * @author Adrien Garrouste
 */
public class Node<T extends Comparable<T>> {

    private T value;

    private Node<T> nodeSmallerValue;

    private Node<T> nodeGreaterValue;

    /**
     * Initialize node with value
     * @param value the value to init the node value
     */
    public Node(T value) {
        this.value = value;
        this.nodeSmallerValue = null;
        this.nodeGreaterValue = null;
    }

    /**
     * Get the current node value
     * @return current node value
     */
    public T getValue() {
        return this.value;
    }

    /**
     * Set the value of the current node
     * @param newValue new value to put at value attribute
     */
    public void setValue(T newValue) {
        this.value = newValue;
    }

    /**
     * Get the bigger value in the tree
     * @return the bigger value in the tree
     */
    public Node<T> biggerNode() {
        if (this.nodeGreaterValue == null) {
            return this;
        } else {
            return this.nodeGreaterValue.biggerNode();
        }
    }

    /**
     * Get the smallest node of current node
     * @return smallest node
     */
    public Node<T> getNodeSmallerValue() {
        return this.nodeSmallerValue;
    }

    /**
     * Get the biggest node of current node
     * @return biggest node
     */
    public Node<T> getNodeGreaterValue() {
        return this.nodeGreaterValue;
    }

    /**
     * Add sub node to an other node
     * only add different value
     * @param toAdd value to add
     * @return true if is added
     */
    public boolean addNode(T toAdd) {
        if (this.value.equals(toAdd)) {
            return false;
        } else if (this.value.compareTo(toAdd) < 0 && this.nodeGreaterValue == null) {
            this.nodeGreaterValue = new Node<T>(toAdd);
            return true;
        } else if (this.value.compareTo(toAdd) > 0 && this.nodeSmallerValue == null) {
            this.nodeSmallerValue = new Node<T>(toAdd);
            return true;
        } else if (this.value.compareTo(toAdd) < 0) {
            return this.nodeGreaterValue.addNode(toAdd);
        } else {
            return this.nodeSmallerValue.addNode(toAdd);
        }
    }

    /**
     * Display the tree in Z order
     */
    public void display() {
        System.out.print(this.value + " ");
        if (this.nodeSmallerValue != null) {
            this.nodeSmallerValue.display();
            if (this.nodeGreaterValue != null) {
                this.nodeGreaterValue.display();
            }
        } else if (this.nodeGreaterValue != null) {
            this.nodeGreaterValue.display();
        } else {
            System.out.println();
        }
    }

    /**
     * Display all nodes value in ascending order
     */
    public void displayAscendingOrder() {
        if (this.nodeSmallerValue == null) {
            System.out.print(this.value + " ");
        } else {
            this.nodeSmallerValue.displayAscendingOrder();
            System.out.print(this.value + " ");
        } 
        
        if (this.nodeGreaterValue != null) {
            this.nodeGreaterValue.displayAscendingOrder();
        }
    }

    /**
     * Prefix through
     * Root node - Smaller node - Greater node
     * @return stringbuilder with nodes 
     */
    public StringBuilder prefix() {
        return new StringBuilder(this.value.toString()).append(" ")
                    .append(this.nodeSmallerValue == null ? "" : this.nodeSmallerValue.prefix())
                    .append(this.nodeGreaterValue == null ? "" : this.nodeGreaterValue.prefix());
    }

    /**
     * Infix through
     * Smaller node - Root node - Greater node
     * @return stringbuilder with node
     */
    public StringBuilder infix() {
        return new StringBuilder(this.nodeSmallerValue == null ? "" : this.nodeSmallerValue.infix())   
                    .append(this.value.toString()).append(" ")
                    .append(this.nodeGreaterValue == null ? "" : this.nodeGreaterValue.infix()); 
    }

    /**
     * Postfix through
     * Smaller node - Greater node - Root node
     * @return stringbuilder with node
     */
    public StringBuilder postfix() {
        return new StringBuilder(this.nodeSmallerValue == null ? "" : this.nodeSmallerValue.postfix())
                    .append(this.nodeGreaterValue == null ? "" : this.nodeGreaterValue.postfix())
                    .append(this.value.toString()).append(" ");
    }

    /**
     * Determine if a value is present in the tree
     * @param searchedValue the value to search
     * @return true if searchedValue is in the tree
     */
    public boolean isPresent(T searchedValue) {
        if (this.value.equals(searchedValue)) {
            return true;
        } else if (this.nodeGreaterValue == null && this.nodeSmallerValue == null) {
            return false;
        } else if (this.value.compareTo(searchedValue) < 0) {
            return this.nodeGreaterValue.isPresent(searchedValue);
        } else {
            return this.nodeSmallerValue.isPresent(searchedValue);
        }
    }

    /**
     * Determine the height of the tree
     * The root has the height equals at 1
     * @return the height of the tree 
     */
    public int getHeight() {
        if (this.nodeSmallerValue == null && this.nodeGreaterValue == null) {
            return 1;
        } else if (this.nodeSmallerValue == null) {
            return 1 + this.nodeGreaterValue.getHeight();
        } else {
            return 1 + this.nodeSmallerValue.getHeight();
        }
    }

    /**
     * Remove a node with who has the value toRemove
     * @param fatherNode father node of the current node
     * @param toRemove value to remove
     * @return true if node is removed
     */
    public boolean removeNode(Node<T> fatherNode, T toRemove) {
        if (fatherNode == null) {
            return false;
        } else if (this.value.compareTo(toRemove) < 0) {
            return this.nodeGreaterValue != null && this.nodeGreaterValue.removeNode(this, toRemove);
        } else if (this.value.compareTo(toRemove) > 0) {
            return this.nodeSmallerValue != null && this.nodeSmallerValue.removeNode(this, toRemove);
        } else {
            if (this.nodeGreaterValue == null) {
                if (fatherNode.value.compareTo(toRemove) < 0) {
                    fatherNode.nodeGreaterValue = this.nodeSmallerValue;
                } else {
                    fatherNode.nodeSmallerValue = this.nodeSmallerValue;
                }
            } else if (this.nodeSmallerValue == null) {
                if (fatherNode.value.compareTo(toRemove) < 0) {
                    fatherNode.nodeGreaterValue = this.nodeGreaterValue;
                } else {
                    fatherNode.nodeSmallerValue = this.nodeGreaterValue;
                }
            } else {  
                Node<T> toMove = this.nodeSmallerValue.biggerNode();
                this.nodeSmallerValue.removeNode(this, toMove.value);
                this.value = toMove.value;
            }
            return true;
        }
    }
}