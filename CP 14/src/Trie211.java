import java.util.Scanner;

class tNode {
    public boolean isEnd;
    public tNode[] child = new tNode[26];
}

public class Trie211 {
    private static void addWord(tNode root, String word) {
        for(int j = 0; j < word.length(); j++) {
            char c = word.charAt(j);

            if(root.child[c-'a'] != null) {
                if(word.length()-1 == j) {
                    root.child[c-'a'].isEnd = true;
                }
                root = root.child[c-'a'];
            } else {
                tNode trie = new tNode();
                trie.isEnd = (word.length()-1 == j);
                root.child[c-'a'] = trie;
                root = root.child[c-'a'];
            }
        }
    }

    private static boolean searchWord(tNode root, String word) {
        boolean isFound = true;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(root.child[c-'a'] != null) {
                if(word.length()-1 != i) {
                    root = root.child[c-'a'];
                } else {
                    if(!root.child[c-'a'].isEnd) {
                        isFound = false;
                    }
                }
            } else {
                isFound = false;
                break;
            }
        }
        return isFound;
    }

    private static void printWord(tNode root, String toPrint) {
        if(root == null) {
            return;
        }
        if(root.isEnd) {
            System.out.println(toPrint);
        }

        for(int i = 0; i < root.child.length; i++) {
            tNode t = root.child[i];
            if(t != null) {
                printWord(t, toPrint + (char)('a'+i));
            }
        }
    }

    private static void prefixWord(tNode root, String prefix) {
        tNode t = new tNode();
        t = root;
        System.out.println("prefix: " + prefix);

        for(int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            t = t.child[c-'a'];
        }
        printWord(t,prefix);
    }

    public static void main(String[] args) {
        tNode root = new tNode();

        Scanner input = new Scanner(System.in);

        outer: while(true) {
            System.out.println();

            while(true) {
                System.out.print("Enter a word: ");
                String word = input.nextLine();
                if(word.length() == 0) {
                    break;
                }
                addWord(root,word);
            }

            System.out.println("List of words");
            printWord(root,"");
            System.out.println();

            while(true) {
                System.out.print("Enter a prefix: ");
                String prefix = input.nextLine();
                if(prefix.length() == 0) {
                    System.out.println("Bye!");
                    break outer;
                }
                prefixWord(root,prefix);
            }
        }

//        //print all the words
//        System.out.println("List of words");
//        printWord(root,"");
//        System.out.println();
//
//        //ask user for a prefix
//        String prefix = "hel";
//        prefixWord(root,prefix);
//
//        //test if the word is in the tree
//        //System.out.println(searchWord(root,"has"));
    }
}