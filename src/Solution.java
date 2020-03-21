import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {

        System.out.println(solution("2", "1")); // prints "1"
        System.out.println(solution("7", "4")); // prints "4"
        System.out.println(solution("100000000000000000000000000000000000000000000000000", "100000000000000000000000000000000000000000000000001")); // prints "100000000000000000000000000000000000000000000000000"
        System.out.println(solution("0", "1")); // prints "impossible"

    }

    /*
    optimized solution to the problem
     */
    public static String solution(String a, String b) {
        String total_turn = "0";
        String curr_turn = "0";

        // finding the larger and smaller number
        String larger = a;
        String smaller = b;

        // creating BigInteger values to hold values which are larger than long
        BigInteger first = new BigInteger(larger);
        BigInteger second = new BigInteger(smaller);

        // creating BigInteger equivalents of integer values 1 and -1
        BigInteger one = new BigInteger("1");
        BigInteger neg_one = one.negate();

        // if a is the smaller number, swap larger and smaller
        if (first.compareTo(second) < 0) {
            larger = b;
            smaller = a;
        }

        // keep looping until we get 0 as out remainder(smaller val)
        while (!(smaller.equals("0"))) {
            // creating two big integers using "larger" and "smaller" strings
            BigInteger numerator = new BigInteger(larger);
            BigInteger denominator = new BigInteger(smaller);

            // creating BigIntegers for the total turns string and current turn string
            BigInteger total_T = new BigInteger(total_turn);
            BigInteger curr_T = new BigInteger((numerator.divide(denominator)).toString());

            // adding the previous turns and current turn values
            BigInteger final_temp = total_T.add(curr_T);

            // converting the BigInteger to string
            total_turn = final_temp.toString();

            // changing the value of larger with smaller
            // and updating smaller with the remainder of the previous fraction
            larger = smaller;
            smaller = (numerator.mod(denominator)).toString();
        }

        // creating BigIntegers from string total_turn
        BigInteger turn = new BigInteger(total_turn);
        BigInteger final_turn = turn.subtract(one);

        // checking if the value was actually formed from 1 of each bomb
        // and checking if one of the final # of bombs is not 0
        if (!(larger.equals("1")) || final_turn.compareTo(neg_one) == 0) {
            return "impossible";
        }

        // return the number of turns taken to reach to the solution
        return final_turn.toString();
    }
}
