import java.util.Random;

public class NewRandom extends Random {

    NewRandom() {}

    //Returns a random integer value between 'low' and 'high' (inclusive)
    @Override
    public int nextInt(int low, int high) {
        return super.nextInt(low,high+1);
    }

    //Returns a random lowercase character
    public char nextChar() {
        return nextChar('a','z');
    }

    //Returns a random lowercase character within bounds
    public char nextChar(char from, char to) {
        if(from < to) {
            return (char) nextInt(from,to);
        }
        else if(from > to) {
            int r = nextInt(0,1); //randomizes between both bounds
            if(r == 0) {
                return (char) nextInt('a',to);
            } else {
                return (char) nextInt(from,'z');
            }
        }
        else {
            return from; //from == to
        }
    }

    //Returns a random lowercase character NOT in the bounds
    public char nextCharNone(char from, char to) {
        char start = (char) (to+1);
        char end = (char) (from-1);
        //checking bounds
        if(start > 'z') {
            start = 'a';
        }
        if(end < 'a') {
            end = 'z';
        }

        return nextChar(start,end);
    }

    //Returns a random lowercase character between range from & from+i
    public char nextChar(char from, int i) {
        char to = (char) (from+i); //'to' char
        int rem; //remainder, if from+i is out of bounds
        int len = 'z'-'a'+1; //length of lowercase characters
        if(i >= 0) {
            if(from + i > 'z') {
                rem = (from+i-'z'-1) % len;
                to = (char) ('a'+rem);
            }
        }
        else {
            if(from + i < 'a') {
                rem = ('a'-(from+i)-1) % len;
                to = (char) ('z'-rem);
            }
            //swapping from and to
            char temp = from;
            from = to;
            to = temp;
        }
        return nextChar(from,to);
    }

    //Returns a random special character
    public char nextSpecialChar() {
        int low = 33; //first special char
        int high = 126; //last special char
        char c = '\0'; //empty char
        boolean special = false;
        while(!special) {
            c = (char) nextInt(low,high);
            if(checkSpecialChar(c)) {
                special = true; //special char found
            }
        }
        return c;
    }

    //HELPER FUNCTIONS

    //Helper method to check if character is a special character
    private boolean checkSpecialChar(char c) {
        if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
            return false;
        }
        return true;
    }
}
