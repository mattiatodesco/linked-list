public class Stack {
    private Node top;

    public Stack() {
        
    }

    public Stack(Node newNode) {
        this.top = newNode;
    }

    public boolean isEmpty() {
        return top == null;
    }

    /**
     * Reads the first element's content
     * @return first node's content
     */
    public int head(){
        return top.getValue();
    }

    /**
     * Removes the first element from the stack, updating the top reference
     * @return Node removed
     */
    public Node pop(){
        Node toPop = this.top;
        this.top = top.getNext();
        return toPop;

    }

    /**
     * Adds a node to the top of the stack
     * @param newNode Node to be added
     */
    public void push(Node newNode){
        newNode.setNext(this.top);
        this.top = newNode;
    }
}
