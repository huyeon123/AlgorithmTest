package programmers.bruteforce;


public class 카펫 {
    /**
     *
     */
    public static void main(String[] args) {
        카펫 T = new 카펫();
        int brown = 10;
        int yellow = 2;
        for (int i : T.solution(brown, yellow)) {
            System.out.println(i);
        }
    }

    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= (int) Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int row = yellow / i + 2; //큰수(가로)
                if ((row + i) * 2 == brown) {
                    answer[0] = row;
                    answer[1] = i + 2;
                    break;
                }
            }
        }
        return answer;
    }

}
