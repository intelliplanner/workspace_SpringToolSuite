package com;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
public static void main(String[] s) {
//	tst();
	int n = 654321;
	String str = Integer.toString(n);
//	System.out.println(deleteFromEnd(n,str.length()));
	System.out.println(deleteFromStart(n,str.length()));
}


private static void tst() {
	String inputStr = "21260200410";  // Input String for matching
    String regexStr = "[\\s]*[0-9]*[1-9]+";            // Regex to be matched

    // Step 1: Compile a regex via static method Pattern.compile(), default is case-sensitive
    Pattern pattern = Pattern.compile(regexStr);
    // Pattern.compile(regex, Pattern.CASE_INSENSITIVE);  // for case-insensitive matching

    // Step 2: Allocate a matching engine from the compiled regex pattern,
    //         and bind to the input string
    Matcher matcher = pattern.matcher(inputStr);

    // Step 3: Perform matching and Process the matching results
    // Try Matcher.find(), which finds the next match
    while (matcher.find()) {
       System.out.println("find() found substring \"" + matcher.group()
             + "\" starting at index " + matcher.start()
             + " and ending at index " + matcher.end());
    }

    // Try Matcher.matches(), which tries to match the ENTIRE input (^...$)
    if (matcher.matches()) {
       System.out.println("matches() found substring \"" + matcher.group()
             + "\" starting at index " + matcher.start()
             + " and ending at index " + matcher.end());
    } else {
       System.out.println("matches() found nothing");
    }

    // Try Matcher.lookingAt(), which tries to match from the START of the input (^...)
    if (matcher.lookingAt()) {
       System.out.println("lookingAt() found substring \"" + matcher.group()
             + "\" starting at index " + matcher.start()
             + " and ending at index " + matcher.end());
    } else {
       System.out.println("lookingAt() found nothing");
    }

    // Try Matcher.replaceFirst(), which replaces the first match
    String replacementStr = "**";
    String outputStr = matcher.replaceFirst(replacementStr); // first match only
    System.out.println(outputStr);

    // Try Matcher.replaceAll(), which replaces all matches
    replacementStr = "++";
    outputStr = matcher.replaceAll(replacementStr); // all matches
    System.out.println(outputStr);
}


static int deleteFromEnd(int num, int n)
{
 
    // Declare a variable
    // to form the reverse resultant number
    int rev_new_num = 0;
 
    // Loop with the number
    for (int i = 1; num != 0; i++) {
 
        int digit = num % 10;
        num = num / 10;
 
        if (i == n) {
            continue;
        }
        else {
 
            rev_new_num = (rev_new_num * 10) + digit;
        }
    }
 
    // Declare a variable
    // to form the resultant number
    int new_num = 0;
 
    // Loop with the number
    for (int i = 0; rev_new_num != 0; i++) {
 
        new_num = (new_num * 10)
                + (rev_new_num % 10);
        rev_new_num = rev_new_num / 10;
    }
 
    // Return the resultant number
    return new_num;
}



static int deleteFromStart(int num, int n)
{
 
    int d = (int)Math.log10(num) + 1;
    int rev_new_num = 0;

    for (int i = 0; num != 0; i++) {
 
        int digit = num % 10;
        num = num / 10;
 
        if (i == (d - n)) {
            continue;
        }
        else {
            rev_new_num = (rev_new_num * 10) + digit;
        }
    }
    int new_num = 0;
    for (int i = 0; rev_new_num != 0; i++) {
 
        new_num = (new_num * 10)
                + (rev_new_num % 10);
        rev_new_num = rev_new_num / 10;
    }
 
    return new_num;
}
}