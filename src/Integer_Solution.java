import java.math.BigInteger;

public class Integer_Solution {
        public static void main(String[] args) {
            System.out.println(solution(2,1));      // prints 1
            System.out.println(solution(7,4));      // prints 4
            System.out.println(solution(11,11));    // prints "impossible"
            //System.out.println(solution(100000000000000000000000000000000000000000000000000, 100000000000000000000000000000000000000000000000001")); // prints "100000000000000000000000000000000000000000000000000); // gets an error with ints

        }

        /*
        basic solution to the problem
         */
        public static String solution(int a, int b){

            int first = a;
            int second = b;
            int turn = 0;
            boolean check = false;

            while(!(first == 1 && second == 1)){
                if (first > second){
                    first = first - second;
                }else if (second > first){
                    second = second - first;
                }
                else{
                    return "Impossible";
                }

                turn ++;
            }
            return String.valueOf(turn);
        }

}
