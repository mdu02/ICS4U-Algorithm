import java.util.ArrayList;
import java.util.Scanner;

class PolynomialTester {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Hello. What is your x?: ");
        int x = sc.nextInt();
        System.out.println("Enter a list of polynomial coefficients, then 'done': ");
        ArrayList<Integer> co = new ArrayList<>();
        while(sc.hasNextInt()){
            int t = sc.nextInt();
            co.add(t);
        }
        long start = System.nanoTime();
        long fx = 0;
        int largest = co.size()-1;
        for (int i = 0; i <= largest; i++){
            fx += co.get(i) * Math.pow(x, largest-i);
        }
        long end = System.nanoTime();
        long uS = (end-start)/1000;
        System.out.println("Result is " + fx);
        System.out.println("Time taken was " + uS + "uS");
    }
}
