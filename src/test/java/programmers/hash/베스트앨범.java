package programmers.hash;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class 베스트앨범 {
    static String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    static int[] plays = {500, 600, 150, 800, 2500};

    public static void main(String[] args) {
        베스트앨범 T = new 베스트앨범();
        for (int i : T.solution(genres, plays)) {
            System.out.println(i);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        return IntStream.range(0, genres.length)
                .mapToObj(i -> new Data(i, genres[i], plays[i]))
                .collect(Collectors.groupingBy(Data::getGenre))
                .entrySet().stream()
                .sorted((a, b) -> sum(b.getValue()) - sum(a.getValue())) //compareTo 처럼 장르별 합 순으로 내림차순 정렬
                .flatMap(x -> x.getValue().stream().sorted().limit(2)) //장르별 리스트를 정렬해서 2개 가져옴 (flatMap은 2중리스트 or 배열을 1차원으로 매핑)
                .mapToInt(x -> x.id).toArray();
    }

    private int sum(List<Data> value) {
        int answer = 0;
        for (Data data : value) {
            answer += data.play;
        }
        return answer;
    }

//    public int[] solution(String[] genres, int[] plays) {
//        ArrayList<Integer> temp = new ArrayList<>();
//        LinkedList<LinkedList<Data>> table = new LinkedList<>();
//        ArrayList<String> check = new ArrayList<>();
//        LinkedList<Data> score = new LinkedList<>();
//
//        for (int i = 0; i < genres.length; i++) {
//            if (!check.contains(genres[i])) {
//                check.add(genres[i]);
//                table.add(new LinkedList<>());
//            }
//            table.get(check.indexOf(genres[i])).add(new Data(i, genres[i], plays[i]));
//        } ...1

//        for (LinkedList<Data> data : table) {
//            Collections.sort(data);
//            int sum = 0;
//            for (Data e : data) {
//                sum += e.play;
//            }
//            score.add(new Data(0, check.get(table.indexOf(data)),sum));
//        }...2

//        Collections.sort(score);
//
//        for (Data data : score) {
//            String genre = data.genre;
//            int index = check.indexOf(genre);
//            for (int i = 0; i < 2; i++) {
//                if(!table.get(index).isEmpty()) temp.add(table.get(index).poll().id);
//            }
//        }
//        return temp.stream().mapToInt(i -> i).toArray();
//    }

    public class Data implements Comparable<Data> {
        public int id;
        public String genre;
        public int play;

        public Data(int id, String genre, int play) {
            this.id = id;
            this.genre = genre;
            this.play = play;
        }

        @Override
        public int compareTo(Data o) {
            if (o.play == this.play) return this.id - o.id;
            else return o.play - this.play;
        }

        public String getGenre() {
            return genre;
        }
    }
}
