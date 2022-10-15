import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();

        try {
            File file = new File("score.txt");
            FileReader fr = new FileReader(file);

            Scanner sc = new Scanner(fr);
            while(sc.hasNext()) {
                String str = sc.next();
                int i = sc.nextInt();
                Student s = new Student();
                s.name = str;
                s.score = i;
                studentList.add(s);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File does not exist");
        }

        //prints out student name and student score
        for(Student s: studentList) {
            System.out.println(s.name + " " + s.score);
        }

        Scanner scan = new Scanner(System.in);

        String str;
        int i;
        while(true) {
            System.out.print("Input a desired score: ");
            str = scan.next();

            try {
                i = Integer.parseInt(str);
            } catch(NumberFormatException e) {
                System.out.println("Input error. Please input an integer.");
                continue;
            }
            break;
        }

        for(Student s: studentList) {
            if(s.score >= i) {
                System.out.println(s.name + " " + s.score);
            }
        }
    }
}