import java.io.*;
import java.util.*;

public class MoveToFront {
    private static int ascii = 256;

    // apply move-to-front encoding, reading from stdin and writing to stdout
    public static void encode(){
        // create an array, converting the char values into int (ASCII) values
        char[] chAr = new char[ascii];
        for (char i = 0; i < ascii; i++){
            chAr[i] = i;
        }
        // Read in each char value and assign it a new char value
        while (!BinaryStdIn.isEmpty()){
            char ch = BinaryStdIn.readChar();
            char out;
            char count;
            char in;
            // Duplicates should be read in as 0, otherwise find its position and assign its value (0, 1, 2, etc.)
            for (count = 0, out = chAr[0]; ch != chAr[count]; count++) {
                in = chAr[count];
                chAr[count] = out;
                out = in;
            }
            // Once we find the value, update the array and write the count to char
            chAr[count] = out;
            BinaryStdOut.write(count);
            chAr[0] = ch;
        }
        // No longer using BinaryStdOut, close so we no longer write to it
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from stdin and writing to stdout
    public static void decode(){
        // create an array, converting the char values into int (ASCII) values
        char[] chAr = new char[ascii];
        for (char i = 0; i < ascii; i++){
            chAr[i] = i;
        }
        // Read in each char value and assign it a new char value
        while (!BinaryStdIn.isEmpty()){
            int intIn = BinaryStdIn.readInt();
            char out;
            char count;
            char in;

            //Manipulates chAr list to move current char to front
            // Duplicates should be read in as 0, otherwise find its position and assign its value (0, 1, 2, etc.)
            for (count = 0, out = chAr[0]; intIn != chAr[count]; count++) {
                in = chAr[count];
                chAr[count] = out;
                out = in;
            }

            // Once we find the value, update the array and write the count to char
            chAr[count] = out;
            BinaryStdOut.write((char)count);
            chAr[0] = (char)intIn;
        }
        // No longer using BinaryStdOut, close so we no longer write to it
        BinaryStdOut.close();
    }
    // if args[0] is "-", apply move-to-front encoding
// if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args){
        if (args == null) throw new java.lang.IllegalArgumentException("args is null");
        String word = args[0];
        if (word.equals("+")){ decode(); }
        else if (word.equals("-")){ encode(); }
        else throw new java.lang.IllegalArgumentException("word = " + word);
    }
}
