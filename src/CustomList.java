public class CustomList {
    private Node head;

    public CustomList() {
        this.head = null;
    }

    public CustomList(Node newHead) {
        this.head = newHead;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Adds a new node at the end of the list
     * @param newNode new node to be added
     */
    public void append(Node newNode) {
        if (isEmpty())
            this.head = newNode;
        else 
            append(head, newNode);

    }

    private void append(Node node, Node nuovo){
        if (node.getNext() == null){
            node.setNext(nuovo);
        } else {
            append(node.getNext(), nuovo);
        }
    }

    /**
     * Outputs every list item on the console
     */
    public void print() {
        System.out.print("List: [");
        printNext(head);

    }

    private void printNext(Node node){
        if(node == null){
            System.out.println("]");
            return;
        } else if (node.getNext() == null){
            System.out.print(node.getValue());
        } else {
            System.out.print(node.getValue() + ", ");
        }

        printNext(node.getNext());
    }

    public void add (int index, Node newNode) {
        if (index == 0){
            newNode.setNext(head);
            this.head = newNode;
        } else if (index > 0 && index <= size()){
            Node prev = get(index -1);
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        } else {
            throw new IndexOutOfBoundsException("Invalid Position");
        }

    }

    public Node remove(int index) throws IndexOutOfBoundsException{
        Node toReturn;
        if (index == 0){
            toReturn = this.head;
            this.head = this.head.getNext();
        } else if (index > 0 && index < size()){
            Node prev = get(index -1);
            toReturn = prev.getNext();
            prev.setNext(toReturn.getNext());
        } else {
            throw new IndexOutOfBoundsException("Invalid Position");
        }
        
        return toReturn;

    }

    public boolean remove (Node node) {
        if (node == null)
            return false;

        int index = indexOf(node);
        if (index < 0)
            return false;

        return remove(index) != null;
    }

    public int indexOf(Node n ){
        Node cursor = head;
        int index = 0;
        while (cursor != null){
            if (cursor.equals(n))
                return index;
            
            cursor = cursor.getNext();
            index++;
        }

        return -1;
    }

    public void set (int index, Node newNode) throws IndexOutOfBoundsException{
        if (index < 0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index");
        if (newNode == null)
            return;

        if (index == 0){
            newNode.setNext(head.getNext());
            head = newNode;
        } else {
            Node prev = get(index -1);
            newNode.setNext(prev.getNext().getNext());
            prev.setNext(newNode);
        }
    }

    /**
     * Checks if the list contains the given node
     * @param n node to be checked
     * @return true if the node is in the list, false otherwise
     */
    public boolean contains (Node n){
        if (n == null)
            return false;
        return indexOf(n) >= 0;
    }

    public boolean containsRec(Node n){
        return containsRec(head, n);
    }
    
    private boolean containsRec(Node cursor, Node n){
        if (cursor == null)
            return false;
        else if (cursor.equals(n))
            return true;
        else{
            return containsRec(cursor.getNext(), n);
        }
        
    }

    private Node getRec(Node cursor, int index) throws IndexOutOfBoundsException{
        if (index == 0)
            return cursor;

        return getRec(cursor.getNext(), index-1);

    }

    public Node get(int index) throws IndexOutOfBoundsException{
        //check if index is invalid
        if (index < -size() || index >= size())
            throw new IndexOutOfBoundsException("Invalid index");
        if (index < 0)
            index = size() + index;
        return getRec(head, index);
    }

    private int sizeRec(Node cursor){
        if (cursor == null)
            return 0;
        return sizeRec(cursor.getNext()) +1;
    }

    public int size(){
        return sizeRec(head);
    }


}
