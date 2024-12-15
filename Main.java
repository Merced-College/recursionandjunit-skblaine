//Skylee Blaine

public class Main {

    public static void main(String[] args) {
        // Test count8 
        System.out.println("Testing count8:");
        System.out.println(count8(8));        
        System.out.println(count8(818));     
        System.out.println(count8(8818));    
        System.out.println();

        // Test countHi 
        System.out.println("Testing countHi:");
        System.out.println(countHi("xxhixx"));    
        System.out.println(countHi("xhixhix"));   
        System.out.println(countHi("hi"));       
        System.out.println();

        // Test countHi2 
        System.out.println("Testing countHi2:");
        System.out.println(countHi2("ahixhi")); 
        System.out.println(countHi2("ahibhi")); 
        System.out.println(countHi2("xhixhi"));   
        System.out.println();

        // Test strCount 
        System.out.println("Testing strCount:");
        System.out.println(strCount("catcowcat", "cat"));  
        System.out.println(strCount("catcowcat", "cow")); 
        System.out.println(strCount("catcowcat", "dog"));  
        System.out.println();

        // Test stringClean 
        System.out.println("Testing stringClean:");
        System.out.println(stringClean("yyzzza"));  
        System.out.println(stringClean("abbbcdd")); 
        System.out.println(stringClean("Hello"));   
    }

    // Problem 1
    public static int count8(int n) {
        if (n == 0) return 0;
        // will get the rightmost number
        int lastNum = n % 10;

        // will get the number next to n
        // ...to also check if it's an 8
        int secondNum = (n / 10) % 10;

        // check is last digit equals 8
        if (lastNum == 8) {
            // if both are 8, then it counts as double
            if (secondNum == 8) {
                return 2 + count8(n / 10);
            } else {
                return 1 + count8(n / 10);
            }
        } else {
            return count8(n / 10); // continue search
        }
    }

    // Problem 2
    public static int countHi(String str) {
        if (str.length() < 2) return 0;
        // Check first two characters
        if (str.substring(0, 2).equals("hi")) {
            // count ++, move onto next two characters
            return 1 + countHi(str.substring(2));
        } else {
            // if not, move one character ahead
            return countHi(str.substring(1));
        }
    }

    // Problem 3
    public static int countHi2(String str) {
        if (str.length() < 2) return 0;
        // Checks first two character for 'hi', and doesn't follow an 'x'
        if (str.substring(0, 2).equals("hi")) {
            if (str.length() > 2 && str.charAt(0) == 'x') {
                // Skip the hi and x, move one character ahead
                return countHi2(str.substring(1));
            } else {
                // count++, move two characters ahead
                return 1 + countHi2(str.substring(2));
            }
        } else {
            // not found, move one character
            return countHi2(str.substring(1));
        }
    }

    // Problem 4
    public static int strCount(String str, String sub) {
        if (str.length() < sub.length()) return 0;
        // Check if str starts with sub
        if (str.substring(0, sub.length()).equals(sub)) {
            // count++, move on to next character (length of sub)
            return 1 + strCount(str.substring(sub.length()), sub);
        } else {
            // If not, move one character ahead
            return strCount(str.substring(1), sub);
        }
    }

    // Problem 5
    public static String stringClean(String str) {
        if (str.length() <= 1) return str;
        //checks if first two char are the same
        //skip first char
        if (str.charAt(0) == str.charAt(1)) {
            return stringClean(str.substring(1));
        } else {
            // Will keep first character
            return str.charAt(0) + stringClean(str.substring(1));
        }
    }
}