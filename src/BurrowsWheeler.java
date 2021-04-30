public class BurrowsWheeler {
    // apply Burrows-Wheeler transform,
// reading from standard input and writing to standard output
    public static void transform(){
        String strIn = BinaryStdIn.readString();
        CircularSuffixArray csa = new CircularSuffixArray(strIn);
        //csa.index(csa.length());
        int origin;

        for (int i = 0; i < csa.length(); i++){
            if (csa.index(i) == 0){
                origin = i;
                break;
            }
        }


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