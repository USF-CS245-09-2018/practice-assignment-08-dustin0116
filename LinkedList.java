
public class LinkedList implements List {
    Node head;
    int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    class Node {
        private Node next;
        private Object data;

        public Node() {
            this.data = null;
            next = null;
        }

        public Node(Object data) {
            this.data = data;
            next = null;
        }
    }

    @Override
    public void add(Object obj) {
        if (head == null) {
            head = new Node(obj);
            size++;
        } else {
            Node newNode = new Node(obj);
            newNode.next = head;
            head = newNode;
            size++;
        }
    }

    @Override
    public void add(int pos, Object obj) {
        if (pos == 0) {
            Node newNode = new Node();
            newNode.data = obj;
            newNode.next = head;
            head = newNode;
            size++;
        } else {
            Node newNode = new Node();
            newNode.data = obj;
            Node prev = null;
            Node current = head;
            int i = 0;
            while(i < pos) {
                prev = current;
                current = current.next;
                if(current == null)
                    break;
                i++;
            }
            newNode.next = current;
            prev.next = newNode;
            size++;
        }
    }

    @Override
    public Object get(int pos) {
        Node posNode = head;
        for (int i = 0; i < pos; i++) {
            posNode = posNode.next;
        }
        return posNode.data;
    }

    @Override
    public Object remove(int pos) {
        if (pos == 0) {
            Node posNode = head;
            head = posNode.next;
            size--;
            return posNode.data;
        }
        Node posNode = head;
        Node prev = null;
        for (int i = 0; i < pos; i++) {
            prev = posNode;
            posNode = posNode.next;
        }
        prev.next = posNode.next;
        size--;
        return posNode.data;
    }

    @Override
    public int size() {
        return size;
    }
}
