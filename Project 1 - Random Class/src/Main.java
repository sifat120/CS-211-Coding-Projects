//Project 1
//Name: Sifat Hasan
//ID: 202887233
//Date: 10/2/2022
//Project Description: This project extends beyond the random class and
//adds custom methods, some of which include nextChar, nextSpecialChar, etc.

public class Main {
    public static void main(String[] args) {

        //initializing NewRandom object as r
        NewRandom r = new NewRandom();

        //# of tests per method
        int test = 25;

        //Method 1
        System.out.println("\n Method 1: nextInt(5,9)");
        for(int i = 0; i < test; i++) {
            int a = r.nextInt(5,9);
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 2
        System.out.println("\n Method 2: nextChar()");
        for(int i = 0; i < test; i++) {
            char a = r.nextChar();
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 3-1
        System.out.println("\n Method 3-1: nextChar('c','f')");
        for(int i = 0; i < test; i++) {
            char a = r.nextChar('c','f');
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 3-2
        System.out.println("\n Method 3-2: nextChar('x','c')");
        for(int i = 0; i < test; i++) {
            char a = r.nextChar('x','c');
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 4-1
        System.out.println("\n Method 4-1: nextCharNone('c','f')");
        for(int i = 0; i < test; i++) {
            char a = r.nextCharNone('c','f');
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 4-2
        System.out.println("\n Method 4-2: nextCharNone('x','c')");
        for(int i = 0; i < test; i++) {
            char a = r.nextCharNone('x','c');
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 5-1
        System.out.println("\n Method 5-1: nextChar('c',3)");
        for(int i = 0; i < test; i++) {
            char a = r.nextChar('c',3);
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 5-2
        System.out.println("\n Method 5-2: nextChar('x',5)");
        for(int i = 0; i < test; i++) {
            char a = r.nextChar('x',5);
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 5-3
        System.out.println("\n Method 5-3: nextChar('c',-3)");
        for(int i = 0; i < test; i++) {
            char a = r.nextChar('c',-3);
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 5-4
        System.out.println("\n Method 5-4: nextChar('x',-3)");
        for(int i = 0; i < test; i++) {
            char a = r.nextChar('x',-3);
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 5-5
        System.out.println("\n Method 5-5: nextChar('k',0)");
        for(int i = 0; i < test; i++) {
            char a = r.nextChar('k',0);
            System.out.print(a + " ");
        }
        System.out.println();

        //Method 6
        System.out.println("\n Method 6: nextSpecialChar()");
        for(int i = 0; i < test; i++) {
            char a = r.nextSpecialChar();
            System.out.print(a + " ");
        }
        System.out.println();

    }
}