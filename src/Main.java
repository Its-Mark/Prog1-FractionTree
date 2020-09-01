import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * Main Method
     * @param args
     */
    public static void main(String args[]){

    }

    /**
     * Read from input.txt file
     * ----------------------- FROM INSTRUCTION -----------------------
     * It can be proved that every possible fraction eventually appears once and
     * only once in this tree.  Input to your program will be a "large" fraction M/N
     * where M and N are large. (You may use the java.BigInteger package if you want.)
     * Output from your program will be the first fraction a/b in the tree such that
     * a/b ~ sqrt(M/N) in the following sense: a/b must be the first fraction in the tree such that
     * |Na^2 - Mb^2| < b
     * Output will be two lines, a and then b.
     *  ----------------------- FROM INSTRUCTION -----------------------
     * @param f = file
     * @return
     */
    public ArrayList<BigInteger> findFraction(File f) throws FileNotFoundException {
        ArrayList<BigInteger> solution = new ArrayList<>();
        Scanner scan = new Scanner(f);
        BigInteger M; BigInteger N;


        return solution;
    }

    /**
     * Create a Fraction Tree
     */
    public class FractionTree{
        private Node overallRoot;

        public FractionTree(){
            
        }

    }

    /**
     * Create Nodes containing a pair of numbers with reference to left and right nodes
     */
    public class Node{
        private ArrayList<BigInteger> data;
        private Node left;
        private Node right;

    }
}
