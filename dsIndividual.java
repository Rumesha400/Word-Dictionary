// TITLE: Word Dictionary Using Doubly Linked List
// ENROLLMENT NO: 22002171310116
// DATE: 30-09-2023
// SUBJECT: Data Structures Using java


import java.util.Scanner;

class Node {
    String key;
    String value;
    Node prev;
    Node next;

    public Node(String key, String value) {
        this.key = key;
        this.value = value;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void addNode(String key, String value) {
        Node newNode = new Node(key, value);
        if (head == null) {                 //if the list is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;           //if the list is already having nodes     
            newNode.prev = tail;           //adding the node 
            tail = newNode;
        }
    }

    public String search(String key) {
        //making a temporary variable current for traversing
        Node current = head;              
        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) {
                return current.value;
            }
            current = current.next;
        }
        return "NULL.";
    }

    public void delete(String key) {
        Node current = head;
        while (current != null) {         //for checking the list is empty or not
            if (current.key.equalsIgnoreCase(key)) {        //if the user-entered key is matching on the current node 
                if (current.prev != null) {              
                    current.prev.next = current.next;
                    System.out.println("~~ Word deleted successfully.");
                } else {
                    head = current.next;       //check for the next node
                }
                if (current.next != null) {             //the user-entered key is the next current node
                    current.next.prev = current.prev;
                    System.out.println("~~ Word deleted successfully.");
                } else {
                    tail = current.prev;
                }
                return;
            }
            current = current.next;
        }
    }

    public void display() {  
        //Node current will point to head  
        Node current = head;  
        if(head == null) {  
           System.out.println("List is empty");  
           return;  
        }  
        System.out.println("Nodes of doubly linked list: ");  
        while(current != null) {  
            //Prints each node by incrementing the pointer.  
  
           System.out.print(current.key +"-"+ current.value + " ");  System.out.println();
           //head=head.next;
           current = current.next;  
       }  
    }  
}

class Dictionary {
    DoublyLinkedList linkedList = new DoublyLinkedList();

    public void insert(String key, String value) {
        linkedList.addNode(key, value);
    }

    public String search(String key) {
        return linkedList.search(key);
    }

    public void delete(String key) {
        linkedList.delete(key);
    }

    public void disp(){
        linkedList.display();
    }
}

class Main123 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Dictionary wordDict = new Dictionary();
        wordDict.insert("Apple", "A Fruit.");
        wordDict.insert("Birthday", "Day on which a person is born.");
        wordDict.insert("Car", "(Noun) A four-wheeled road vehicle");
        wordDict.insert("Dinosaur", "(NOUN) A fossil reptile of the Mesozoic era.");
        wordDict.insert("Egg", "An oval or round object laid by a female bird,reptile,fish usually containing a developing embryo.");
        wordDict.insert("Fish", "A limbless cold-blooded vertebrate animal with gills and fins living wholly in water.");
        wordDict.insert("Goblin", "A mischievous, ugly creature resembling a dwarf.");
        wordDict.insert("Hat", "A shaped covering for the head worn for warmth, as a fashion.");
        wordDict.insert("Ice", "Frozen water.");
        wordDict.insert("Jar", "A wide-mouthed cylindrical container made of glass.");
        wordDict.insert("Keys", "A small piece of shaped metal which is inserted into a lock and turned to open or close it.");
        wordDict.insert("Lollipop", "A large, flat, rounded boiled sweet on the end of a stick.");
        wordDict.insert("Mango", "A oval, yellowish-red tropical fruit that is eaten ripe or used green for pickles or chutneys.");
        wordDict.insert("Nose", "The part projecting above the mouth on the face of a person, used for breathing and smelling");
        wordDict.insert("Octopus", "An animal with eight sucker-bearing arms, a soft body and strong beaklike jaws.");
        wordDict.insert("Pencil", "An instrument for writing or drawing");
        wordDict.insert("Quilt","A warm bed covering made of padding enclosed between layers of fabric.");
        wordDict.insert("Rose", "A prickly bush or shrub or flower that typically bears red.");
        wordDict.insert("Sun", "The star round which the earth orbits.");
        wordDict.insert("Tent","A portable shelter made of cloth.");
        wordDict.insert("Umbrella","A device of circular canopy used for protection from rain.");
        wordDict.insert("Violin", "An instrument played with a horsehair bow.");
        wordDict.insert("Worm", "Any of a number of creeping or burrowing invertebrate animals with long bodies.");
        wordDict.insert("Xylophone","A musical instrument played by striking a row of wooden bars.");
        wordDict.insert("Yak", "A large domesticated wild ox.");
        wordDict.insert("Zip","A device consisting of two flexible strips of metal by pulling a slide along them.");
        //For testing-
        //System.out.println(wordDict.search("Hat"));
        //wordDict.delete("Zebra");
        //System.out.println(wordDict.search("Apple"));  
        int choice;
        while(true){
            System.out.println("------- WORD DICTIONARY OPERATIONS ------");
            System.out.println("Enter your choice-");
            System.out.println("1.Add a word");
            System.out.println("2.Delete a word");
            System.out.println("3.Search a word");
            System.out.println("4.Display");
            System.out.println("5.Exit.");
            choice=sc.nextInt();
            switch (choice) {
                case 1:
                //Adding a word
                    System.out.println("Enter the word-");
                    String w1=sc.next();   sc.nextLine();
                    System.out.println("Enter the meaning-");
                    String m1=sc.nextLine();   //sc.nextLine();
                    wordDict.insert(w1,m1);
                    System.out.println("~~ Word inserted successfully.");
                    System.out.println();
                break;

                case 2:
                //Deleting a word    
                    System.out.println("Enter the word you want to delete-");
                    String d1=sc.next();  //sc.nextLine();
                    wordDict.delete(d1);
                    System.out.println();
                break;

                case 3:
                    System.out.println("Enter the word you want to search-");
                    String s1=sc.next();  //sc.nextLine();
                    System.out.println("Meaning- "+wordDict.search(s1));
                    System.out.println();
                break;

                case 4:
                    wordDict.disp();
                    System.out.println();
                break;

                case 5:
                    System.out.println("Exiting..");
                    System.exit(0);
                break;
                
                default:
                    System.out.println("~ Enter a valid choice.");
                break;
            }
        }
    }
}