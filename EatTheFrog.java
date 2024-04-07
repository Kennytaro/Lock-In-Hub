import java.util.*;

class StorageData{
    String e;
    Integer v;
    StorageData(String e, Integer v){
        this.e = e;
        this.v = v;
    }
}

public class EatTheFrog {
    static Map<String, Integer> tasks = new HashMap<String, Integer>();

    public EatTheFrog(){
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        printTasksAndCheckCompletion(input(sc),sc);
    }
    
    public void start(Scanner sc){
        printTasksAndCheckCompletion(input(sc),sc);
    }
    static ArrayList<String> list = new ArrayList<>();
    static ArrayList<Integer> diff1 = new ArrayList<>();

    public static Map<String, Integer> input(Scanner sc) {
        System.out.println("How many tasks would you like to add?: ");
        int t = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < t; i++) {
            System.out.println("Enter tasks " + (i + 1) + "(Enter \"DONE\"): ");
            String task = sc.nextLine();

            if (task.equalsIgnoreCase("DONE")) {
                break;
            }

            list.add(task);
        }
        System.out.println("Next you will input the difficulty of the task");
        int diff = 0;
        int tf = t;
        for (int i = 0; i < tf; i++) {
            System.out.println("Enter difficulty for "+ list.get(i)+ " between 1 and " + t + ", 1 being the most difficult for task: " );
            diff = sc.nextInt();
            diff1.add(diff);
        }
        Map<String, Integer> tasks = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            tasks.put(list.get(i), diff1.get(i));
        }
        return tasks;
    }
    public static Map<String, Integer> printTasksAndCheckCompletion(Map<String, Integer> tasks, Scanner sc) {
        Map<String, Integer> sortedTasks = new HashMap<>();
        Map<Integer, String> reversed = new HashMap<>();
        Map<String, Integer> temp = new HashMap<>();
        ArrayList<StorageData> tempArr = new ArrayList<StorageData>();
        // sorted by the power of friendship

        for(String key : tasks.keySet()){ // a,b,c
            reversed.put(tasks.get(key),key); // (2=a); // sorts everything by key
        }
        System.out.println("Tasks hardest to easiest is, start with the hardest task first: ");

        for(Integer key : reversed.keySet()){
            //System.out.println(key); // 1
            //System.out.println(reversed.get(key)); // e
            //temp.put(reversed.get(key), key); // e,1
            tempArr.add(new StorageData(reversed.get(key), key));
            //System.out.println(temp);
        }

        for(StorageData s_data : tempArr){ // e is string v is #
            //System.out.println(s_data.e + ". " + s_data.v);
            System.out.println(s_data.v + ". " + s_data.e);
            //System.out.print(s_data.e);
            //System.out.println(s_data.v);
        }

        //System.out.println("Sorted tasks: " + temp);
        /*
        while(itr.hasNext()){ // itr has values 1,2,3
            Integer difficulty = itr.next();
            for(int key : reversed.keySet()){
                sortedTasks.put(reversed.get(key), difficulty);
            }
        }
        */
        /*
        for (Integer difficulty : treeSet) {
            // Search the tasks map for the key corresponding to the current difficulty value
            for (String key : tasks.keySet()) {
                if (tasks.get(key).equals(difficulty)) {
                    sortedTasks.put(key, difficulty);
                    break; // Break once the key is found
                }
            }
        }

         */
        /*
        while (itr.hasNext()) { // runs three time
            Integer value = itr.next();
            // Search the tasks map for the key corresponding to the current difficulty value
            for (String key : tasks.keySet()) {
                if (tasks.get(key).equals(value)){
                    sortedTasks.put(key, value);
                }
            }
        }

         */
        //String key = tasks.get(itr); get key based on value
        //sortedTasks.put(tasks., itr.next());




        return sortedTasks;
    }
}