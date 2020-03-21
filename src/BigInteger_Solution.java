import java.math.BigInteger;

public class BigInteger_Solution {
    public static void main(String[] args) {

        System.out.println(solution("2", "1"));
        System.out.println(solution("7", "4"));
        System.out.println(solution("11", "11"));
        System.out.println(solution("11", "111"));
        System.out.println(solution("211", "1111111"));

    }

    /*
    basic solution to the problem
     */
    public static String solution(String a, String b) {
        long startTime = System.nanoTime();
        BigInteger first = new BigInteger(a);
        BigInteger second = new BigInteger(b);
        int one = 1;
        int turn = 0;

        /*
        while(!(first == 1 && second == 1)){
        */
        while (!(BigInteger.valueOf(one).compareTo(first) == 0 && BigInteger.valueOf(one).compareTo(second) == 0)) {
            if (first.compareTo(second) > 0) {
                first = first.subtract(second);
            } else if (second.compareTo(first) > 0) {
                second = second.subtract(first);
            } else {
                return "impossible";
            }
            turn++;
        }
        long endTime = System.nanoTime();

        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;

        //System.out.println("Execution time in nanoseconds  : " + timeElapsed);

        //System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
        return String.valueOf(turn);

    }
}
