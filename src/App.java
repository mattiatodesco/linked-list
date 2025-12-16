public class App {
    public static void main(String[] args) throws Exception {
        Node n1 = new Node(322);
        Node n2 = new Node(23);
        Node n3 = new Node(54);
        Node n4 = new Node(65);
        Node n5 = new Node(90);

        CustomList list = new CustomList(null);

        list.append(n1);
        list.append(n2);
        list.append(n3);
        list.append(n4);
        list.append(n5);

        list.print();

        Node n6 = new Node(98);
        
        list.add(3, n6);

        list.print();
    }
}
