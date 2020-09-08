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
        BigInteger M; BigInteger N; Node sol;
        try {
            File f = new File("input1.txt");
            Scanner scan = new Scanner(f);
            M = new BigInteger(scan.nextLine());
            N = new BigInteger(scan.nextLine());

            sol = findFraction(M,N);
            //create the file and write to it
            File out = new File("output7.txt");
            FileWriter fw = new FileWriter(out);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(sol.data.get(0).toString() + "\n" + sol.data.get(1).toString());
            System.out.println("SOLUTION: \n" + sol.data.get(0) + "\n" + sol.data.get(1));

            scan.close();
            bw.close();
            fw.close();

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
    public static Node findFraction(BigInteger M, BigInteger N){
        Node newNode;
        Node solution = null;
        Node[] nodes = new Node[2];
        nodes[0] = new Node(new BigInteger("0"), new BigInteger("1")); //start with 0,1 on the left
        nodes[1] = new Node(new BigInteger("1"), new BigInteger("0")); //start with 1,0 on the right
        FractionTree ft = new FractionTree();
        int counter = 1;
        while(solution == null){
            System.out.println("Attempt: " + counter);
            newNode = add(nodes[0],nodes[1]);
            // Na^2
            BigInteger left = N.multiply((newNode.data.get(0).pow(2)));
            // Mb^2
            BigInteger right = M.multiply((newNode.data.get(1).pow(2)));
            // |Na^2 - Mb^2|
            BigInteger absDif = (left.subtract(right)).abs();
            System.out.println("Current Nodes: " + nodes[0].toString() + nodes[1].toString() + newNode.toString());
            //Compare Nodes!
            if(left.compareTo(right) == 0 || absDif.compareTo(newNode.data.get(1)) < 0){
                solution = newNode;
            } else if (left.compareTo(right) < 0){
                nodes[0] = newNode;
                ft.addNode(newNode);
            } else if (left.compareTo(right) > 0){
                nodes[1] = newNode;
                ft.addNode(newNode);
            }
            counter++;

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

        public FractionTree(Node n){
            overallRoot = n;
        }

        public void addNode(Node n){
            overallRoot = addNode(this.overallRoot, n);
        }

        private Node addNode(Node root, Node nta){
            if(root == null){
                root = nta;
            } else {
                int compOutcome = root.compareTo(nta);
                if (compOutcome < 0) {
                    root.left = addNode(root.left,nta);
                } else if ( compOutcome > 0) {
                    root.right = addNode(root.right,nta);
                }
            }

            return root;
        }

    }

    /**
     * Create Nodes containing a pair of BigInts with reference to left and right nodes
     */
    public static class Node implements Comparable<Node>{
        private ArrayList<BigInteger> data;
        private Node left;
        private Node right;

        public Node(BigInteger m, BigInteger n){
            data = new ArrayList<>();
            data.add(m);
            data.add(n);
            left = null;
            right = null;
        }

        @Override
        public int compareTo(Node o) {
            if(this.data.get(0).compareTo(o.data.get(0)) == 0 ){
                if((this.data.get(1).compareTo(o.data.get(1)) == 0 )){
                    return 0;
                } else if ((this.data.get(1).compareTo(o.data.get(1)) < 0)) {
                    return -1;
                } else if ((this.data.get(1).compareTo(o.data.get(1)) > 0)) {
                    return 1;
                }
            } else if (this.data.get(0).compareTo(o.data.get(0)) < 0 ) {
                return -1;
            } else if (this.data.get(0).compareTo(o.data.get(0)) > 0 ) {
                return 1;
            }

            return -2;
        }

        @Override
        public String toString(){
            return("[" + this.data.get(0).toString() + "," + this.data.get(1).toString() + "]");
        }

    }
    public static Node add(Node n1, Node n2){
        BigInteger num = n1.data.get(0).add(n2.data.get(0));
        BigInteger den = n1.data.get(1).add(n2.data.get(1));
        Node n3 = new Node(num,den);
        return n3;
    }
}
