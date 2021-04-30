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


    private static String parse(int origin,char[] unorderedData,char[] orderedData, int deep){
        int orderedcount = 0;
        int unorderedcount = 0;
        String result = null;
        System.out.println("Origin: " +  origin);

        result = Character.toString(orderedData[origin]);

        //count how many chars deep the current letter is
        for (int i = 0; i <= origin; i++){
            if (orderedData[origin] == orderedData[i]) {
                orderedcount++;
                System.out.println("Count incremented to: " + orderedcount);
            }
        }

        //count that many chars down in unordered list to find the next char
        for (int i = 0; i < unorderedData.length; i++){
            if (orderedData[origin] == unorderedData[i]) {
                unorderedcount++;
                System.out.println("Count2 incremented to: " + unorderedcount);
            }

            if (unorderedcount == orderedcount){//if at correct location for next char
                if (deep < unorderedData.length){
                    System.out.println("called parse");
                    deep++;
                    result += parse(i,unorderedData,orderedData,deep);
                }
                System.out.println("Result: "+ result);
                break;
            }
        }
        return result;
    }

    // apply Burrows-Wheeler inverse transform,
    // reading from standard input and writing to standard output
    public static void inverseTransform(){
        origin = BinaryStdIn.readInt();

        String s = BinaryStdIn.readString();

        char[] unorderedData = s.toCharArray();
        char[] orderedData = s.toCharArray();
        System.out.println("Unsorted: "+unorderedData);
        Arrays.sort(orderedData);
        System.out.println("Sorted: "+orderedData);


        String result = parse(origin,unorderedData,orderedData,1);
        System.out.println("Result: " + result);
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