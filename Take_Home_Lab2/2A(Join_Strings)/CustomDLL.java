//Name: Song Soon Wee
//Student Number: A0200378L

public class CustomDLL {
    Node current;
    Node tail;

    class Node{ //To create a single node
        String data;
        Node prev;
        Node next;
        
        public Node(String data){
            this.data = data;
        }

        public String toString(){
            return this.data;
        }
    }

    public CustomDLL(String data){ //Create a single node with NULL init for both prev and next
        this.current = new Node(data);
        this.tail = this.current; //Since this is the only node, this will be the tail.
    }

    public void append(CustomDLL secondDLL){ //Append this with the next node.
        if(this.current == this.tail){ //Append if it is the only node
            secondDLL.current.prev = this.current; //Set current node to be previous of appended.
            this.current.next = secondDLL.current; //Set next node to be the next of current.
            this.tail = secondDLL.tail; //Update to the appended tail.
        } else{ //Current node has more than 1 node
            this.tail.next = secondDLL.current; //Since it is null, set the appended head to be the next of old tail.
            secondDLL.current.prev = this.tail; // Appended head will point back to old tail.
            this.tail = secondDLL.tail; //Update tail to be the secondDLL tail.
        }
    }
}
