package Maman15;

/**
 * This class represents a large number using linked lists.
 *
 * @author Nir Eizenman
 * @version 14/01/2020
 */
public class BigNumber {

    private IntNode _head;


    /**
     * Empty constructor, constructs a number with 1 node and sets it to 0.
     * Time complexity: O(1), because there is a finite amount of actions with no relations to an input
     * Space complexity: O(1), because there is a finite space taken with no relations to an input
     */
    public BigNumber() {
        _head = new IntNode(0);
    }

    /**
     * Constructs a number using the input of a long.
     * Time complexity: O(n), because the constructor will loop through the number for each digit in it (therefore n is the number of the digits)
     * Space complexity: O(n), because the constructor will set a new node for each digit in the number (therefore n is the number of the digits)
     *
     * @param number the number given to construct to which a linked list
     */
    public BigNumber(long number) {
        _head = new IntNode((int) (number % 10));
        IntNode temp = _head;
        while (number / 10 > 0) {
            number = number / 10; // with each iteration divide the number by 10
            temp.setNext(new IntNode((int) (number % 10))); // set the next node as rightmost digit in the number
            temp = temp.getNext(); // set the point to point at the next node
        }
    }

    /**
     * Copy constructor, copies a given Maman15.BigNumber.
     * Time complexity: O(n), because the constructor will loop through each node in the given Maman15.BigNumber to copy (therefore n is the number of nodes in the given Maman15.BigNumber)
     * Space complexity: O(n), because the constructor will set a new node for each node in the given Maman15.BigNumber (therefore n is the number of nodes in the given Maman15.BigNumber)
     *
     * @param num the Maman15.BigNumber given to copy
     */
    public BigNumber(BigNumber num) {
        _head = new IntNode(num._head.getValue());
        IntNode other = num._head;
        IntNode temp = _head;
        while (other.getNext() != null) { // loop until you reach the end of the linked list
            other = other.getNext(); // set the pointer to point to the next node
            temp.setNext(new IntNode(other.getValue())); // set this Maman15.BigNumber's node to be the same as the given's
            temp = temp.getNext();
        }
    }

    /**
     * Calls a recursive method to turn the Maman15.BigNumber into a string.
     * Time complexity: O(n), because the method calls a method with a time complexity of o(n) (n is the amount of nodes in the linked list)
     * Space complexity: O(1), because there is a finite space taken with no relations to an input
     *
     * @return a string representation of the Maman15.BigNumber
     */
    public String toString() {
        return toString(_head); // call the recursive method with the head of this Maman15.BigNumber
    }

    /**
     * Recursive method that turns a linked list of ints into a string.
     * Time complexity: O(n), because the method will loop through each node of the linked list (therefore n is the amount of nodes)
     * Space complexity: O(1), because there is a finite space taken with no relations to an input
     *
     * @param node the node from which to start the recursion
     * @return string representation of the linked list
     */
    private String toString(IntNode node) {
        if (node == null) // stop if you reach the end of the linked list and add "" to the string
            return "";
        return toString(node.getNext()) + node.getValue(); // call the method again and add to the string the current node's value
    }

    /**
     * Compare between this Maman15.BigNumber and a given Maman15.BigNumber.
     * Time complexity: O(n), because the method calls methods with a time complexity of O(n) (n is the amount of nodes in the bigger Maman15.BigNumber)
     * Space complexity: O(1), because there is a finite space taken with no relations to an input
     *
     * @param other the given Maman15.BigNumber to compare to this Maman15.BigNumber
     * @return returns 0 if the BigNumbers are equal, 1 if this number is bigger than the given Maman15.BigNumber, -1 if the given
     * Maman15.BigNumber is bigger than this Maman15.BigNumber
     */
    public int compareTo(BigNumber other) {
        if (this.toString().equals(other.toString())) // check if the two BigNumbers are equal using the toString method
            return 0;
        if (this.length() != other.length()) {
            if (this.length() > other.length())// check if this number is bigger using the length method
                return 1;
            else return -1; // if the method got here the other number if bigger
        }
        return isBigger(other); // both number in the same length but are not equals, call the isBigger method and returns its returned value
    }

    /**
     * Compare between this Maman15.BigNumber and a given Maman15.BigNumber of the same size.
     * Time complexity: O(n), because the method loops through all the nodes in the linked lists (n is the amount of nodes in one of the linked lists)
     * Space complexity: O(1), because there is a finite space taken with no relations to an input
     *
     * @param other the given Maman15.BigNumber to compare to this Maman15.BigNumber
     * @return returns 1 if this number is bigger than the given Maman15.BigNumber, -1 if the given
     * Maman15.BigNumber is bigger than this Maman15.BigNumber
     */
    private int isBigger(BigNumber other) {
        IntNode temp = _head;
        IntNode temp1 = other._head;
        int sum = 0;
        while (temp != null && temp1 != null) { // loop until at the end of both linked lists
            if (temp.getValue() > temp1.getValue())
                sum = 1; // note that this Maman15.BigNumber is bigger than the other Maman15.BigNumber up to this node
            else if (temp.getValue() < temp1.getValue())
                sum = -1; // note that the other Maman15.BigNumber is bigger than the this Maman15.BigNumber up to this node
            temp = temp.getNext();
            temp1 = temp1.getNext();
        }
        return sum;
    }

    /**
     * Check the length of a Maman15.BigNumber
     * Time complexity: O(n), because the method loops through all the nodes in the linked list (n is the amount of nodes the linked list)
     * Space complexity: O(1), because there is a finite space taken with no relations to an input
     *
     * @return returns the length of this Maman15.BigNumber
     */
    private int length() {
        IntNode temp = _head;
        int count = 0;
        while (temp != null) { // loop until at the end of the linked list
            count++; // add 1 to count with each loop
            temp = temp.getNext();
        }
        return count;
    }

    /**
     * Create a new Maman15.BigNumber object by adding the values of this Maman15.BigNumber and a given Maman15.BigNumber
     * Time complexity: O(n), because the method loops through all the nodes in the linked lists (n is the amount of nodes the bigger linked list)
     * Space complexity: O(n), because the method will set a new node for each digit in the new Maman15.BigNumber, and there will be a
     * max of n+1 digits in the new number (n is the amount of nodes the bigger linked list)
     *
     * @param other the given Maman15.BigNumber to add to this Maman15.BigNumber
     * @return returns a new Maman15.BigNumber that is the sum of the values of this Maman15.BigNumber and the given Maman15.BigNumber
     */
    public BigNumber addBigNumber(BigNumber other) {
        IntNode temp = this._head;
        IntNode temp_other = other._head;
        BigNumber b1 = new BigNumber(); // create new Maman15.BigNumber to store the result and return to the user
        b1._head.setValue((temp.getValue() + temp_other.getValue()) % 10); // calculate the first digit of the new Maman15.BigNumber
        IntNode temp_new = b1._head;
        int extra; // a variable that retains the count overs to the next digit if necessary
        if (temp.getValue() + temp_other.getValue() > 9) // add 1 to the count over if necessary
            extra = 1;
        else
            extra = 0;
        temp = temp.getNext();
        temp_other = temp_other.getNext();
        while (temp != null || temp_other != null) { // loop until both BigNumbers' points has reached the end of the linked lists
            if (temp == null) { // if this Maman15.BigNumber pointer has reached the end of its linked list
                temp_new.setNext(new IntNode((temp_other.getValue() + extra) % 10));
                extra = (temp_other.getValue() + extra) / 10; // recalculate the count over
                temp_other = temp_other.getNext();
            } else if (temp_other == null) { // if the other Maman15.BigNumber pointer has reached the end of its linked list
                temp_new.setNext(new IntNode((temp.getValue() + extra) % 10)); // calculate the current necessary digit
                extra = (temp.getValue() + extra) / 10; // recalculate the count over
                temp = temp.getNext();
            } else { // if both BigNumbers are yet to reach their end
                temp_new.setNext(new IntNode((temp.getValue() + temp_other.getValue() + extra) % 10)); // calculate the current necessary digit
                extra = (temp.getValue() + temp_other.getValue() + extra) / 10; // recalculate the count over
                temp = temp.getNext();
                temp_other = temp_other.getNext();
            }
            temp_new = temp_new.getNext(); // set the pointer of the new Maman15.BigNumber to be the next node
        }
        if (extra == 1) // if the loop has ended but there is still a count over
            temp_new.setNext(new IntNode(1));
        return b1;
    }

    /**
     * Create a new Maman15.BigNumber object by adding the values of this Maman15.BigNumber and a given long
     * Time complexity: O(n), because the method calls a method with a time complexity of O(n) (n is the amount of nodes the bigger linked list)
     * Space complexity: O(n), because the methods called has a space complexity of O(n) (n is the bigger of those: (the amount of nodes the linked list/digits in the long number))
     *
     * @param num the given number to add to this Maman15.BigNumber
     * @return returns a new Maman15.BigNumber that is the sum of the values of this Maman15.BigNumber and the given long
     */
    public BigNumber addLong(long num) {
        BigNumber b1 = new BigNumber(num); // create a new Maman15.BigNumber using the appropriate constructor
        return addBigNumber(b1); // add the created Maman15.BigNumber to this Maman15.BigNumber using the addBigNumber method
    }

    /**
     * Create a new Maman15.BigNumber object by subtracting the values of this Maman15.BigNumber and a given Maman15.BigNumber, subtract the bigger
     * number of the two from the smaller one
     * Time complexity: O(n), because the method calls methods with a time complexity of O(n) (n is the amount of nodes the bigger linked list)
     * Space complexity: O(n), because the methods called has a space complexity of O(n) (n is the bigger of the linked lists (this/other))
     *
     * @param other the given Maman15.BigNumber for the subtraction with this Maman15.BigNumber
     * @return returns a new Maman15.BigNumber the is the result of subtracting this Maman15.BigNumber and the given Maman15.BigNumber
     */
    public BigNumber subtractBigNumber(BigNumber other) {
        if (this.compareTo(other) == 0) // if the BigNumbers are equal return a new Maman15.BigNumber with the value of 0.
            return new BigNumber();
        if (this.compareTo(other) == 1)
            return subtractBiggerNumber(this, other); // call this method if this Maman15.BigNumber is bigger than the given Maman15.BigNumber
        return subtractBiggerNumber(other, this); // call this method if the other Maman15.BigNumber is bigger this Maman15.BigNumber
    }

    /**
     * Create a new Maman15.BigNumber object by subtracting the values of this Maman15.BigNumber and a given Maman15.BigNumber
     * Time complexity: O(n), because the method calls a method with a time complexity of O(n) and because the method loops
     * through all the nodes in the linked lists (n is the amount of nodes the bigger linked list)
     * Space complexity: O(n), because the method will set a new node for each node in the new Maman15.BigNumber, and there will be a max of n digits in the
     * new calculated number (n is the amount of nodes the bigger linked list)
     *
     * @param that  the Maman15.BigNumber from which to subtract the other Maman15.BigNumber
     * @param other the Maman15.BigNumber to subtract from that Maman15.BigNumber
     * @return returns a new Maman15.BigNumber the is the result of subtracting that Maman15.BigNumber from the other Maman15.BigNumber
     */
    private BigNumber subtractBiggerNumber(BigNumber that, BigNumber other) {
        IntNode temp = that._head;
        IntNode temp_other = other._head;
        BigNumber b1 = new BigNumber();
        b1._head.setValue(temp.getValue() - temp_other.getValue()); // calculate the first digit of the new Maman15.BigNumber
        int extra = 0;
        if (b1._head.getValue() < 0) {
            b1._head.setValue(10 + b1._head.getValue()); // if the digit is negative make is positive and carry over the extra
            extra = 1;
        }
        IntNode temp_new = b1._head;
        temp = temp.getNext();
        temp_other = temp_other.getNext();
        while (temp_other != null) { // loop until the smaller Maman15.BigNumber's linked list is reached
            temp_new.setNext(new IntNode(temp.getValue() - temp_other.getValue() - extra)); // calculate and set the next digit in the new Maman15.BigNumber
            if (temp_new.getNext().getValue() < 0) {
                temp_new.setNext(new IntNode(10 + temp_new.getNext().getValue())); // if the digit is negative make is positive and carry over the extra
                extra = 1;
            } else extra = 0;
            temp_other = temp_other.getNext();
            temp = temp.getNext();
            temp_new = temp_new.getNext();
        }
        if (that.length() > other.length()) { // if the Bigger Maman15.BigNumber has more digits go into this loop
            while (extra != 0) { // keep looping until the extra carry over has reached its placed
                temp_new.setNext(new IntNode(temp.getValue() - extra)); // calculate the next digit in the new Maman15.BigNumber
                if (temp_new.getNext().getValue() < 0) {
                    temp_new.setNext(new IntNode(10 + temp_new.getNext().getValue())); // if the digit is negative make is positive and carry over the extra
                    extra = 1;
                } else
                    extra = 0;
                temp = temp.getNext();
                temp_new = temp_new.getNext();
            }
        }
        while (temp != null) { // keep going until the end of the bigger Maman15.BigNumber is reached
            temp_new.setNext(new IntNode(temp.getValue())); // set the value of the next digit of the new Maman15.BigNumber to be the same as this Maman15.BigNumber
            temp = temp.getNext();
            temp_new = temp_new.getNext();
        }
        IntNode node1 = new IntNode(0, b1._head); // create a new pointer that is prior to the head of the new Maman15.BigNumber
        remZeros(b1._head, node1); // call a method to remove the redundant zeros at the end of the linked list
        return b1;
    }

    /**
     * Removes redundant zeroes from the end of the linked list that is this Maman15.BigNumber
     * Time complexity: O(n), because the method loops through all the nodes in the linked list (n is the amount of nodes the linked list that node is its head)
     * Space complexity: O(1), because there is no use of new space by the method
     *
     * @param node  the head of the given Maman15.BigNumber to remove from its redundant zeros
     * @param node1 a pointer that its next is set as node
     */
    private void remZeros(IntNode node, IntNode node1) {
        if (node.getNext() != null)
            remZeros(node.getNext(), node1.getNext()); // call the method again with the next node
        if (node.getNext() == null && node.getValue() == 0) // if the current node's value is 0 and the next node is null set the current node as null
            node1.setNext(null);
    }

    /**
     * A method that returns a new Maman15.BigNumber that is the value of the multiplication of this Maman15.BigNumber with a given Maman15.BigNumber
     * Time complexity: O(n^2), because the method loops through all the nodes in the linked list for each iteration within the
     * other linked list (n is the amount of nodes of the bigger linked list (between this/other))
     * Space complexity: O(n), because the method will set a new node for each digit in the value of the multiplication
     *
     * @param other the given Maman15.BigNumber to multiply by this Maman15.BigNumber
     * @return returns a new Maman15.BigNumber that is the value of the multiplication of this Maman15.BigNumber with a given Maman15.BigNumber
     */
    public BigNumber multBigNumber(BigNumber other) {
        if (this.toString().equals("0") || other.toString().equals("0")) // if either of the number is equal to 0 return a new Maman15.BigNumber with the value of 0
            return new BigNumber();
        BigNumber b1 = new BigNumber(); // create a new Maman15.BigNumber in which to store the value of the multiplication
        IntNode temp = this._head;
        IntNode temp_other = other._head;
        while (temp_other != null) { // go through the digits in the other Maman15.BigNumber
            while (temp != null) { // go through the digits in this Maman15.BigNumber
                if (temp.getValue() * temp_other.getValue() * ((int) ((Math.pow(10, specificLength(this, temp)))) *
                        ((Math.pow(10, specificLength(other, temp_other))))) > 0) // check if the multiplication of the relevant digits multiplied by their spot in the
                    // BigNumbers is larger than 0, if so add them to the new Maman15.BigNumber
                    b1 = b1.addLong(((long) temp.getValue() * temp_other.getValue() * ((int) (Math.pow(10, specificLength(this, temp)))) *
                            ((int) (Math.pow(10, specificLength(other, temp_other))))));
                temp = temp.getNext();
            }
            temp_other = temp_other.getNext();
            temp = this._head; // set the point back to the beginning of this Maman15.BigNumber
        }
        return b1;
    }


    /**
     * Calculates the length between the head of a Maman15.BigNumber to a specific node within it
     * Time complexity: O(n), because the method loops through all the nodes in the linked list until the wanted node is reached (n is the amount of nodes the linked list)
     * Space complexity: O(1), because there is a finite space taken with no relations to an input
     *
     * @param bn   the given Maman15.BigNumber to check to length between its head to a given node
     * @param node the given node which the method looks for its place in the linked list
     * @return the length of the sub linked list between the head of the Maman15.BigNumber and the given node
     */
    private int specificLength(BigNumber bn, IntNode node) {
        IntNode temp = bn._head;
        int count = 0;
        while (temp != node) { // loop until the pointer is at the given node
            count++; // add 1 to the count with each loop
            temp = temp.getNext();
        }
        return count;
    }
}



