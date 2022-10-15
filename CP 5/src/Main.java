import java.util.*;

public class Main {
    static HashSet<String> CS210 = new HashSet<String>();
    static HashSet<String> CS211 = new HashSet<String>();
    static HashSet<String> CS212 = new HashSet<String>();

    public static void Initialize() {
        CS210.add("Bill");
        CS210.add("Eva");
        CS210.add("Olivia");
        CS211.add("Eva");
        CS211.add("Olivia");
        CS211.add("Kim");
        CS212.add("Chloe");
        CS212.add("Jane");
        CS212.add("Olivia");
        CS212.add("Bill");
    }

    public static void atLeastOneClass() {
        HashSet<String> oneClass = new HashSet<String>();
        oneClass.addAll(CS210);
        oneClass.addAll(CS211);
        oneClass.addAll(CS212);
        System.out.println(oneClass);
    }

    public static void allClasses() {
        HashSet<String> allClass = new HashSet<String>(CS210);
        allClass.retainAll(CS211);
        allClass.retainAll(CS212);
        System.out.println(allClass);
    }

    public static void onlyCS210() {
        HashSet<String> onlyOneClass = new HashSet<String>(CS210);
        onlyOneClass.removeAll(CS211);
        onlyOneClass.removeAll(CS212);
        System.out.println(onlyOneClass);
    }

    public static void violation() {
        HashSet<String> wrongClass = new HashSet<String>(CS211);
        wrongClass.removeAll(CS210);
        System.out.println(wrongClass);
    }

    public static void CS210andCS211notCS212Classes() {
        HashSet<String> twoClass = new HashSet<String>(CS210);
        twoClass.retainAll(CS211);
        twoClass.removeAll(CS212);
        System.out.println(twoClass);
    }

    public static void main(String[] args) {
        Initialize();
        atLeastOneClass();
        allClasses();
        onlyCS210();
        violation();
        CS210andCS211notCS212Classes();
    }
}