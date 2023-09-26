package JavaLearningMergeSortNLLOrBust;
import java.util.Scanner;

public class JavaLearningMergeSortOrBust{//Come back to this for fun->: extends JavaLearningMergeLLOrBust ->
    //-> make 'JavaLearningMergeSortOrBust' class a 'sub-class' of 'JavaLearningMergeLLOrBust'
    static boolean callB = false;
    static boolean isFinal = false;
    static int finalCount = 0;
    public static void mergeSort(int[] list){//Note: Same as putting 'int list[]' but it is nicer to ->
    //-> put the '[]' brackets before 'list' since an array is just a special kind of data type ->
    //-> so it fits better sitting next to the other data types like 'int'
        if(list.length > 1){//NOTE: Could also do 'if(list.length-1 > 0)'
            int[] firstHalf = new int[list.length/2];//Making new array object 'int[] firstHalf' ->
            //-> then making the size of the 'firstHalf' array half the size of the 'int[] list' ->
            //-> (the original array)

            //IMPORTANT NOTE: The final argument 'list.length/2' is like the cap on when to ->
            //-> stop copying the array, because it goes from 'srcPos' to 'srcPos+length-1' ->
            //-> the 'length' in 'srcPos+length-1' being the 'length' you give in the final ->
            //-> argument(in this case it was 'list.length/2') this had me hung up for so long ->
            //-> because when you would specify the length but not substract 1 I was confused ->
            //-> but now I realize the method 'arraycopy()' substracts 1 from the 'length' ->
            //-> on its own when calculating the index for it to stop at
            System.arraycopy(list,0,firstHalf,0,list.length/2);
            //'System.arraycopy()' Explained: 'arraycopy()' is a method defined in the 'System' class ->
            //-> the parameters of 'arraycopy()' are ->
            //-> (Object src, int srcPos, Object dest, int destpos, int length) ->
            //-> in lamens terms these each mean ->
            //-> (the source array, the index in the source array you want to start copying at, ->
            //-> the desintation array(where you want to copy all the elements to), ->
            //-> the number of elements into the source array you want to copy(how far to copy to kind of)
            //NOTE: I found an extremely obscure fourm post on "oracle.com" that if you ->
            //-> use 'System.arraycopy()' of a base array too many times(in the tens of thousands) ->
            //-> you will start to encounter the copied array not being identical to the base/orginal array ->
            //-> I am unsure why this happens or how to fix it, but seeing as it was posted in 2005 ->
            //-> I have my doubts that it will be figured out any time soon

            //Maybe later I will make my own 'arraycopy' method ->
            //-> but im going to try and use pre-made methods in the default libraries for now

            mergeSort(firstHalf);//Recursively call merge sort to keep cutting it in half ->
            //-> until it reaches only one index in size

            int secondHalfLength =  list.length - list.length/2;
            int[] secondHalf = new int[secondHalfLength];//Making the size of the array 'secondHalf' ->
            //-> equal to the 'secondHalfLength'
            System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLength);
            mergeSort(secondHalf);

            merge(firstHalf, secondHalf, list, isFinal);
        }
    }

    public static void merge(int[] list1, int[] list2, int[] templist, boolean isFinal){//Note: 'static' basically just means we can call this method ->
    //-> without creating an object from the class first, instead it can run on its own ->
    //-> like main methods
        int i1 = 0;
        int i2 = 0;
        //First we have to initialize all of the linkedlists to fill with nodes from the ->
        //-> arrays and use as pointers(i.e. the current variables)
        JavaLearningMergeLLOrBust<Integer> ll1 = new JavaLearningMergeLLOrBust<>();
        JavaLearningMergeLLOrBust<Integer> ll2 = new JavaLearningMergeLLOrBust<>();
        JavaLearningMergeLLOrBust<Integer> lltemp = new JavaLearningMergeLLOrBust<>();
        
        //Ended up never using the 'Iterator'
        //JavaLearningMergeLLOrBust<Integer>.Iterator iter1 = ll1.iterator();
        //JavaLearningMergeLLOrBust<Integer>.Iterator iter2 = ll2.iterator();
        
        //For peeking into what 'list1' array contains
        System.out.print("The current list1 array: ");
        for(int i = 0; i < list1.length; i++){
            System.out.print(" " + list1[i]);
        }
        System.out.println();
        for(int i = 0; i < list1.length; i++){
            ll1.addLast(list1[i]);
        }

        System.out.println("ll1: " + ll1);
        //For peeking into what 'list2' array contains
        System.out.print("The current list2 array: ");
        for(int i = 0; i < list2.length; i++){
            System.out.print(" " + list2[i]);
        }
        System.out.println();
        for(int i = 0; i < list2.length; i++){
            ll2.addLast(list2[i]);
        }

        System.out.print("The current templist: ");
        for(int i = 0; i < templist.length; i++){
            System.out.print(" " + templist[i]);
        }
        System.out.println();

        System.out.println("ll2: " + ll2);

        //while(iter1.hasNext()){
            //System.out.println("iter1: "+ iter1.next());
        //}
        //while(iter1.hasNext() == true && iter2.hasNext() == true)
        //while(i1 < list1.length && i2 < list2.length){
        //    if(ll1.getNode(i1) <= ll2.getNode(i2)){
        //        lltemp.addLast(ll1.getNode(i1));
                //System.out.println("iter1: " + ll1);
        //        i1++;
        //        i3++;
        //    }
        //    else{
        //        lltemp.addLast(ll2.getNode(i2));
                //System.out.println("iter2: " + ll2);
        //        i2++;
        //        i3++;
        //    }
            //System.out.print("This is the SortedList so far: ");
            //for(int i = 0; i < templist.length; i++){
                //System.out.print(templist[i]);
            //}
            //System.out.println("");
        //}int i = 0;
       
        //public Node winnerPointer(list1,list2)
        //returns the Node that won, to be inserted in temp
        //while(i1 < list1.length){
        //    lltemp.addLast(ll1.getNode(i1));
        //    i1++;
        //    i3++;
        //}
        //while(i2 < list2.length){
        //    lltemp.addLast(ll2.getNode(i2));
        //    i2++;
        //    i3++;
            //System.out.println(list2[i2-1]);
        //}
        //System.out.println("lltemp: " + lltemp);

        //NEW THOUGHT PROCESS BELOW
        while(i1 < list1.length && i2 < list2.length){
            int winner = lltemp.winnerPointer(ll1, ll2, lltemp, i1, i2);
            if(winner == 1){
                i1++;
            }
            else if(winner == 2){
                i2++;
            }
        }
        if(i1 < list1.length){
            while(i1 < list1.length){
                lltemp.addLast(ll1.getNode(i1));
                i1++;
            }
        }
        else{
            while(i2 < list2.length){
                lltemp.addLast(ll2.getNode(i2));
                i2++;
            }
        }
        System.out.println("lltemp: " + lltemp);
        //For loop below fills the unsorted array 'templist' with the elements from the ->
        //->  Nodes in the sorted LinkedList 'lltemp'
        for(int i = 0; i < templist.length; i++){
            templist[i] = lltemp.getNode(i);
        }
    }
    public static void main(String[] args){
        //int[] list = {2,3,2,5,6,1,-2,3,14,12};
        //mergeSort(list);
        //System.out.print("SORTED ARRAY: ");
        //for(int i = 0; i < list.length; i++){
        //    System.out.print(" " + list[i]);
        //}
        //System.out.println();

        int yn = 0;
        do{
            Scanner userInput =  new Scanner(System.in);
            System.out.print("Please enter the length of your list to be sorted: ");
            int listLen = userInput.nextInt();
            if(listLen > 1){
                System.out.print("Enter each element from index 0-" + (listLen-1) + "(Hitting enter after each element): ");
//RANDOM IMPORTANT THOUGHT I HAD: When you are declaring a class in Java you essentially ->
//-> just creating a new data type, so just so I have it written down somewhere I am ->
//-> going to explain the three step proccess to obtaining objects of a class ->
//-> 1.) The Declaration: An example is the first part of the line of code below ->
//-> 'int[] newList', in a way its kind of like saying this new variable 'newList' will have ->
//-> the data-type 'int[]', so now it can be made an object using a contructor of the same ->
//-> data-type(class)
//-> 2.) The Instantiation: Using the 'new' operator, it allocates(at runtime) the memory ->
//-> for a new object and returns a reference to that memory, the reference is stored ->
//-> in the variable 'newList' so that the object can be referenced later through the variable ->
//-> 3.) The Initialization: After the 'new' operator is the call to the class's constructor ->
//-> which initializes the new object, this is the second part of the code below ->
//-> 'int[listLen]' the constructor is usually used to set all the initial values for the ->
//-> objects attributes(Think: the Node constructor sets 'head = null', 'tail = null', and 
//-> 'size = 0', when it is invoked to make a new Node object ->
//-> also in the case of LinkedLists, it lets the new LinkedList object use the methods ->
//-> in the LinkedList class
                int[] newList = new int[listLen];
                for(int i = 0; i < listLen; i++){
                    int newElement = userInput.nextInt();
                    newList[i] = newElement;
                }
                mergeSort(newList);
                System.out.print("SORTED ARRAY: ");
                for(int i = 0; i < newList.length; i++){
                    System.out.print(" " + newList[i]);
                }
            }
            else{
                System.out.println("[The list has a length of one or fewer, and cannot be sorted]");
            }
            System.out.println();

            System.out.print("Would you like to sort another list(Y/N): ");
            String userChoice = userInput.next();//SIDE NOTE: Just so I have this info somewhere ->
            //-> 'String userChoice = "Hello"' is a literal, so you are just creating a pointer ->
            //-> to a literal(constant) value, this is why there is no 'new' operator needed ->
            //-> when making a new 'String' varaible because you are creating a pointer to a literal ->
            //-> not a new object. This is why 'String userChoice = new String("Hello")' is NOT the ->
            //-> same as 'String userChoice = "Hello"', when you do it like ->
            //->'String userChoice = new String("Hello")' it is creating an object using the ->
            //-> 'String()' constructor, so you are putting the 'String' literal('"Hello"') ->
            //-> in the 'String' pool and then creating a 'String'('userChoice') object 
            //-> whose content points to the 'String' literal('"Hello"') in the pool ->
            // If two variables are initialized to the same literal we want them to EQUAL ->
            //-> eachother not be different, doing it the object way, since they are ->
            //-> instance variables not literals, an object made 'String userChoice1 = new String("Hello")' ->
            //-> and an object made 'String userChoice2 = new String("Hello")' will NOT EQUAL ->
            //-> eachother('userChoice1' != 'userChoice2')
            if(userChoice.charAt(0) == 'N'){
                yn = 1;
                userInput.close();
            }
        }
        while(yn == 0);
    }
}
