import java.util.Arrays;

public class CircularSuffixArray {
    private int[] index;
    private String csa;

    private class Node implements Comparable<Node> {
        private int index;

        public Node(int indexIn) {
            index = indexIn;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public int compareTo(Node arg) {
            int j = arg.getIndex();
            for (int i=0; i<length(); i++) {
                int pos1 = (i + index + length()) % length();
                int pos2 = (i + j + length()) % length();
                if (csa.charAt(pos1) != csa.charAt(pos2))
                    return csa.charAt(pos1) - csa.charAt(pos2);
            }
            return 0;
        }
    }

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        index = new int[s.length()];
        csa = s;
        Node[] suffix = new Node[s.length()];
        for (int i=0; i<suffix.length; i++) {
            suffix[i] = new Node(i);
        }

        Arrays.sort(suffix);
        for (int i = 0; i< index.length; i++) {
            index[i] = suffix[i].getIndex();
        }
    }
    // length of s
    public int length(){
        return csa.length();
    }
    // returns index of ith sorted suffix
    public int index(int i){
        return index[i]; //todo change
    }
    // unit testing (required)
    public static void main(String[] args){

    }
}
