public class BurrowsWheeler {
    private static int index;
    private static int origin;
    private static int prev;
    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform(){
        String s = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(s);
        origin = -1;
        // We need to be able to append to a string. Stringbuilder lets us do that
        StringBuilder sb = new StringBuilder();
        // Iterate through the Circular Suffix Array
        for (int i = 0; i < s.length(); i++){
            index = csa.index(i);
            // If index is 0, then we are at the original string in the Circular Suffix Array
            if (index == 0){
                origin = i;
            }
            // We need to track the previous character in the array
            prev = index - 1;
            if (prev < 0){
                prev += s.length();
            }
            // Append the last character accordingly
            sb.append(s.charAt(prev));
        } // end of for loop
        // Write the index of the original Circular Suffix Array to standard out
        BinaryStdOut.write(origin);
        // Write the last index from the Circular Suffix Array to standard out
        BinaryStdOut.write(sb.toString());
        // No longer using BinaryStd, close so we no longer write to it
        BinaryStdOut.close();
    }
    // apply Burrows-Wheeler inverse transform,
// reading from standard input and writing to standard output
    public static void inverseTransform(){

    }
    // if args[0] is "-", apply Burrows-Wheeler transform
// if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args){

    }
}