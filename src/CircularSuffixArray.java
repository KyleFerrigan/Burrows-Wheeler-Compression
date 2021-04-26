import java.util.ArrayList;

public class CircularSuffixArray {
    String csa = null;
    ArrayList csaIndex;

    // circular suffix array of s
    public CircularSuffixArray(String s) {
        csa = s;
        csaIndex = new ArrayList();
    }
    // length of s
    public int length(){
        return csa.length();
    }
    // returns index of ith sorted suffix
    public int index(int i){
        return -1; //todo change
    }
    // unit testing (required)
    public static void main(String[] args){

    }
}