/**
 * Project 1 for CECS 328
 * @author Mark Garcia (Mark.Garcia.8001@gmail.com
 */

import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * Main Method
     * @param args
     */
    public static void main(String args[]){
        BigInteger M; BigInteger N; ArrayList<BigInteger> sol;
        try {
            File f = new File("input1.txt");
            Scanner scan = new Scanner(f);
            M = new BigInteger(scan.nextLine());
            N = new BigInteger(scan.nextLine());

            sol = findFraction(M,N);
            //create the file and write to it
            File out = new File("output.txt");
            FileWriter fw = new FileWriter(out);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sol.get(0).toString() + "\n" + sol.get(1).toString());

            scan.close();

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();

        } catch (IOException ioe) {
            ioe.printStackTrace();

        }

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
     * @param M = line 1 (numerator)
     * @param N = line 2 (denominator)
     * @return the first pair which matches
     */
    public static ArrayList<BigInteger> findFraction(BigInteger M, BigInteger N){
        ArrayList<BigInteger> solution = new ArrayList<>();
        Node ab;
        Node toFind = new Node(M,N);
        FractionTree ft = new FractionTree();
        int L = 1;
        int index = 0;
        while(solution.isEmpty()){
            //ft.addNode();
        }

        return solution;
    }

    /**
     * Create a Fraction Tree
     */
    public static class FractionTree{
        private Node overallRoot;

        public FractionTree(){
            overallRoot = null;
        }

        public FractionTree(BigInteger m, BigInteger n){
            overallRoot = new Node(m, n);
        }

        public int compareNodeData(Node n1, Node n2){
            return n1.data.get(0).divide(n1.data.get(1)).compareTo(n2.data.get(0).divide((n2.data.get(1))));
        }
        public void addNode(BigInteger M, BigInteger N){
            ArrayList<BigInteger> temp = new ArrayList<>();
            temp.add(M); temp.add(N);
            overallRoot = addNode(this.overallRoot, temp);
        }

        private Node addNode(Node root, ArrayList<BigInteger> al){

            return root;
        }

    }

    /**
     * Create Nodes containing a pair of BigInts with reference to left and right nodes
     */
    public static class Node{
        private ArrayList<BigInteger> data;
        private Node left;
        private Node right;

        public Node(){
            data = new ArrayList<>();
            left = null;
            right = null;
        }

        public Node(BigInteger m, BigInteger n){
            data = new ArrayList<>();
            data.add(m);
            data.add(n);
            left = null;
            right = null;
        }

    }
}
