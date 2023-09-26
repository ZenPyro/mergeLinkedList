package JavaLearningMergeSortNLLOrBust;

//Making the 'LinkedList' myself just for practice
public class JavaLearningMergeLLOrBust<T>{
    Node head = null;//Set to 'null' later can be taken out here
    Node tail = null;//Set to 'null' later can be taken out here
    int size;
    
    public class Node{
        T data;
        Node link;

        Node(){//Default constructor
        }

        Node(T element){
            data = element;
            link = null;
        }
    }

    JavaLearningMergeLLOrBust(){
        head = null;
        tail = null;
        int size = 0;
    }

    public void addLast(T newElement){
        Node newNode = new Node(newElement);
        Node temp1 = tail;
        if(temp1 == null){
            tail = newNode;
            head = newNode;
            size++;
        }
        else{
            temp1.link = newNode;
            tail = newNode;
            size++;
        }
    }

    public Iterator iterator(){
        return new Iterator();
    }

    class Iterator{
        Node next;

        Iterator(){
            next = head;
        }

        public T next(){
            T data_field = next.data;
            next.link = next;
            return data_field;
        }

        public boolean hasNext(){
            if(next != null){
                return true;
            }
            return false;
        }
    }

    public int getSize(){
        return size;
    }

    public T getNode(int index){
        if(index == 0){
            return head.data;
        }
        else if(index == size-1){
            return tail.data;
        }
        else{
            int i = 0;
            Node temp1 = head;
            while(i < index){
                temp1 = temp1.link;
                i++;
            }
            return temp1.data;   
        }
    //BELOW(on line 93) IS THE MESS-UP THAT MESSED ME UP FOR A DAY:
        //else{
        //    int i = 0;
        //    Node temp1 = head;
        //    while(i < index){
        //        temp1.link = temp1;
        //        i++;
        //    }
        //    return temp1.data;   
        //}
    }

    public int winnerPointer(JavaLearningMergeLLOrBust<Integer> ll1, JavaLearningMergeLLOrBust<Integer> ll2, JavaLearningMergeLLOrBust<Integer> lltemp, int i1, int i2){
        if(ll1.getNode(i1) <= ll2.getNode(i2)){
            lltemp.addLast(ll1.getNode(i1));
            size++;
            return 1;
        }
        else{
            lltemp.addLast(ll2.getNode(i2));
            size++;
            return 2;
        }
    }

    public String toString(){
        String str = "[";
        Node temp = head;

        while(temp != null){
            str = str + temp.data;
            if(temp != tail){
                str = str + ", ";
            }
            temp = temp.link;
        }
        return str = str + "]";
    }
}
