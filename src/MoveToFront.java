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
            //System.out.println((int)count);//todo remove
            BinaryStdOut.write(count);
            chAr[0] = ch;
        }
        // No longer using BinaryStd, close so we no longer write to it
        BinaryStdIn.close();
        BinaryStdOut.close();
    }

    // apply move-to-front decoding, reading from stdin and writing to stdout
    public static void decode(){
        //    	initialization
        char[] pos = new char[256];
        for (int i=0; i<pos.length; i++) pos[i] = (char)i;
        while (BinaryStdIn.isEmpty() == false) {
            char c = BinaryStdIn.readChar();
//    		char r = pos[c];
            BinaryStdOut.write(pos[c]);
//    		StdOut.print(r);
            char tmp = pos[c];
//    		simulate the process of move to front
            for (int i=c; i>0; i--) pos[i] = pos[i-1];
            pos[0] = tmp;
        }
        BinaryStdOut.flush();
        BinaryStdOut.close();
        return;
    } // end method decode
    
    // if args[0] is "-", apply move-to-front encoding
    // if args[0] is "+", apply move-to-front decoding
    public static void main(String[] args){
        if (args == null) throw new java.lang.IllegalArgumentException("args is null");
        String word = args[0];
        switch (word) {
            case "-":
                encode();
                break;
            case "+":
                decode();
                break;
            default:
                throw new java.lang.IllegalArgumentException("word = " + word);
        }
    }
}
