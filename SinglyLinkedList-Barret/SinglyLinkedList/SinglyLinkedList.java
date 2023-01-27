package SinglyLinkedList;

public class SinglyLinkedList {
    public Node head;
    public Node tail;
    int size = 0;
    int count = 0;

    public SinglyLinkedList() {

    }

    get_count(){
        return count;
    }

    get_size(){
        return size;
    }

    insert_head(int d){
        newNode = newNode(d,null,head);
        head.head = newNode;
        head = newNode;
        size++;
        count++;
    }

    insert_tail(int d){
        newNode = newNode(d,tail,null);
        tail.tail = newNode;
        head = newNode;
        size++;
        count++;
    }
}