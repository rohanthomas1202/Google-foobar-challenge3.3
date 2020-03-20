public class Solution {
    public static void main(String[] args) {
        System.out.println(solution("2","1"));
        System.out.println(solution("7","4"));
        System.out.println(solution("11","11"));
    }

    /*
    basic solution to the problem
     */
    public static String solution(String a, String b){

        int first = Integer.parseInt(a);
        int second = Integer.parseInt(b);
        int turn = 0;

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
