import java.util.Arrays;

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

        String s = BinaryStdIn.readString();

        //Have one copy of sorted data one copy of unsorted
        char[] unorderedData = s.toCharArray();
        char[] orderedData = s.toCharArray();
        Arrays.sort(orderedData);
        int deep = 0;
        String result = "";
        int curOrigin = origin;
        while(deep<unorderedData.length) {

            int orderedcount = 0;
            int unorderedcount = 0;
            result += Character.toString(orderedData[curOrigin]);//set result to be the current place of the origin pointer
            //System.out.println("Origin: " +  curOrigin);


            //count how many chars deep the current letter is
            for (int i = 0; i <= curOrigin; i++) {
                if (orderedData[curOrigin] == orderedData[i]) {
                    orderedcount++;
                    //System.out.println("Count incremented to: " + orderedcount);
                }
            }

            //count that many chars down in unordered list to find the next char
            for (int i = 0; i < unorderedData.length; i++) {
                if (orderedData[curOrigin] == unorderedData[i]) {
                    unorderedcount++;
                    //System.out.println("Count2 incremented to: " + unorderedcount);
                }

                if (unorderedcount == orderedcount) {//if at correct location for next character in sequence
                    if (deep < unorderedData.length) {
                        //System.out.println("called parse");
                        deep++;
                        curOrigin = i;
                    }
                    //System.out.println("Result: "+ result);
                    break;
                }
            }
        }

        System.out.println("Result: " + result);

        BinaryStdOut.write(result);

        BinaryStdOut.flush();
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