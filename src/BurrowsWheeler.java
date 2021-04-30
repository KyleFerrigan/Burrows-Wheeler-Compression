public class BurrowsWheeler {
    private static int index;
    private static int origin;
    private static int prev;
    private static int ascii = 256;
    // apply Burrows-Wheeler transform,
    // reading from standard input and writing to standard output
    public static void transform(){
        String s = BinaryStdIn.readString();
        //System.out.println(s);//todo remove
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
        BinaryStdOut.write((int)origin);
        // Write the last index from the Circular Suffix Array to standard out
        BinaryStdOut.write(sb.toString());
        // No longer using BinaryStd, close so we no longer write to it
        BinaryStdOut.close();
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform(){
        origin = BinaryStdIn.readInt();
        int[] count = new int[ascii+1];
        String s = BinaryStdIn.readString();
        // Iterate through the array, incrementing the count for each character
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count[c+1]++;
        }
        // Update the count
        for (int j = 0; j < ascii; j++){
            count[j+1] += count[ascii];
        }
        // Copy into a sorted array, while also keeping track of the next traversal
        char[] temp = new char[s.length()];
        int[] next = new int[s.length()];
        for (int k = 0; k < s.length(); k++){
            char cc = s.charAt(k);
            temp[count[cc]] = cc;
            next[count[cc]] = k;
            count[cc]++;
        }
        // Rebuild the original string from the int[] next array
        int first = origin;
        for (int l = 0; l < s.length(); l++){
            BinaryStdOut.write(temp[first]);
            first = next[first];
        }
        // No longer using BinaryStd, close so we no longer write to it
        BinaryStdOut.close();
    }

    // if args[0] is "-", apply Burrows-Wheeler transform
    // if args[0] is "+", apply Burrows-Wheeler inverse transform
    public static void main(String[] args){
        if (args == null) throw new java.lang.IllegalArgumentException("args is null");
        String word = args[0];
        switch (word) {
            case "-":
                BurrowsWheeler.transform();
                break;
            case "+":
                BurrowsWheeler.inverseTransform();
                break;
            default:
                throw new java.lang.IllegalArgumentException("word = " + word);
        }
    }
}