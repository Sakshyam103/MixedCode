public class HashTable implements java.io.Serializable{

        static final class Node {
            String key;
            Node next;
            int value;
            int frequency;
            Node(String k, int value, Node n) {   // take String , value and node
                key = k;    // key
                this.value = value;   //value
                next = n;   // next
                frequency = 0;   // frequency
            }
        }
        Node[] table = new Node[16]; // always a power of 2
        int size = 0;  // size

        public int get(String k){
            int h = k.hashCode();  //convert k into hashcode
            int i = h & (table.length - 1);   //get value after hash function
            for (Node p = table[i]; p != null; p = p.next) {  // search until the node is null
                if (k.equals(p.key)) return p.value;  // if the keys are same then return the value
            }
            return 0;  //else return 0
        }



        void add(String key) {      //add method
            int h = key.hashCode();   // convert into hashcode
            int i = h & (table.length - 1);   //convert using hash function
            for (Node e = table[i]; e != null; e = e.next) {   //search until the node is null
                if (key.equals(e.key)){   //if key is same
                    ++e.value;  // increase the value of the node
                    return;}  // return
            }
            table[i] = new Node(key,1, table[i]);  // or make a new node with key , value = 1 and table[i],
            if ((float)size/table.length >= 0.75f)  // if the ratio is more than or equal to 0.75f
                resize();  //resize
        }

        void resize() {                     // resize method
            Node[] oldTable = table;    // make a oldTable
            int oldCapacity = oldTable.length;   // make a oldCapacity
            int newCapacity = oldCapacity << 1;   // increase the newCapacity by multipling by 2;
            Node[] newTable = new Node[newCapacity];  //Make a newTable with newCapacity
            for(int i = 0; i < oldCapacity; ++i) {  // for every int in oldCapacity
                for (Node e = oldTable[i]; e != null; e = e.next) {  // for every node in the old table
                    int h = e.key.hashCode();   // convert it into hashcode
                    int j = h & (newTable.length - 1);   //convert into int using hash function
                    newTable[j] = new Node(e.key,e.value, newTable[j]);   // add it to the newTable
                    newTable[j].frequency = e.frequency;   // make the frequency of the table same
                }
            }
            table = newTable;  // change the name of the newTable to table
        }
}
