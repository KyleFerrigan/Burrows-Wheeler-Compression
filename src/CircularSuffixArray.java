import java.util.ArrayList;
import java.util.Arrays;

public class CircularSuffixArray {
    private int length; // length of the string
    private Integer[] index; // array of characters
    private ArrayList lastCharArry;
    // circular suffix array of s
    public CircularSuffixArray(String s){
        if (s == null) throw new java.lang.IllegalArgumentException(s + " is null");
        
        length = s.length();
        index = new Integer[length]; 
        // Initialize the array with the index of the character
        for (int i = 0; i < length; i++){
            index[i] = i;
        }
        // We need to take the original suffix and sort the array so that we can find the proper index
        Arrays.sort(index, (Integer o, Integer p) -> {
            for (int i = 0; i < length; i++) {
                char let = s.charAt((o + i) % length);
                char ter = s.charAt((p + i) % length);
                // If we find a character that differs, we need to exit and try again
                if (let < ter){
                    return -1;
                }
                if (let > ter){
                    return 1;
                }
            } // end of for loop
            // Otherwise, the strings are the same (let == ter), return that compared value
            // We check this later for time complexity 
            return o.compareTo(p);
        }); // end of Arrays.sort
    } // end of constructer
    
    // length of s
    public int length(){
        return length;
    }
    
    // returns index of ith sorted suffix
    public int index(int i){
        if (i < 0 || i >= length) throw new java.lang.IllegalArgumentException(i + " is out of range");
        return index[i];
    }
    
    // unit testing (required)
    public static void main(String[] args){
        String magic = "ABRACADABRA!";
        //String magic = "OPENSESAME!";
        //String magic = "HOCUSPOCUS!";
        CircularSuffixArray csa = new CircularSuffixArray(magic);
        System.out.println("The total length of the array is: " + csa.length);
        int[] test = new int[magic.length()];
        for (int i = 0; i < magic.length(); i++){
            test[i] = csa.index(i);
            System.out.println("The index of " + i + ": " + test[i]);
        }
    }
}
