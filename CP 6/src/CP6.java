import java.util.HashMap;
import java.util.Scanner;

public class CP6 {
    public static HashMap<Integer,Member> map = new HashMap<>();

    public static void add() {
        Scanner input = new Scanner(System.in);

        System.out.println("Input ID");
        int id = input.nextInt();

        System.out.println("Input Name");
        String name = input.next();

        System.out.println("Input Age");
        int age = input.nextInt();

        map.put(id,(new Member(name,age)));
        System.out.println(id + " added successfully");
    }

    public static void remove() {
        Scanner input = new Scanner(System.in);

        System.out.println("Input ID to be removed");
        int id = input.nextInt();

        if(map.containsKey(id)) {
            map.remove(id);
            System.out.println(id + " successfully removed");
        } else {
            System.out.println("Can't find " + id);
        }
    }

    public static void printAll() {
        System.out.println();
        System.out.println("Current Members: " + map.size());

        for(int i: map.keySet()) {
            Member member = map.get(i);
            System.out.println("id: " + i + " name: " + member.getName() + " age: " + member.getAge());
        }
    }

    public static void main(String[] args) {
        System.out.println("HashMap add/remove test");
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println();
            System.out.println("Select 1)add 2)remove 3)quit");

            int select = input.nextInt();

            if(select == 1) {
                add();
                printAll();
            }
            else if(select == 2) {
                remove();
                printAll();
            }
            else if(select == 3) {
                System.out.println("Bye!");
                break;
            }
            else {
                System.out.println("Invalid input, please try again.");
            }
        }
    }
}