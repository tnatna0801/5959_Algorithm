import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_S1713 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int total = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int[] candidate = new int[total];

        //입력
        for (int i = 0; i < total; i++) {
            candidate[i] = Integer.parseInt(st.nextToken());
        }

        //Integer, Integer => key: 학생번호, value: 추천수  / Integer: 학생번호, int[] 들어온 순서, 추천수
        Map<Integer, int[]> photo = new HashMap<>(); // 사진틀

        //돈다
        for (int i = 0; i < total; i++) {
            int[] info = new int[2];

            //1. 어떤 학생이 특정 학생을 추천하면, 추천받은 학생의 사진이 반드시 사진틀에 게시되어야 한다.
            if (!photo.containsKey(candidate[i])) { // 사진틀에 없음
                //3. 사진틀이 꽉 차있음
                if (photo.size() == n) {
                    //현재까지 추천 받은 횟수가 가장 적은 학생의 사진을 삭제
                    photo.remove(delete(photo));
                }
                // 새롭게 추천 받은 학생의 사진을 게시한다.
                info[0] = i; // 순서
                info[1] = 1; // 추천수
            }
            // 4. 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우에는 추천받은 횟수만 증가시킨다.
            else {
                info[0] = photo.get(candidate[i])[0]; // 순서 유지
                info[1] = photo.get(candidate[i])[1] + 1; // 추천수 + 1
            }
            photo.put(candidate[i], info);

            //확인용 출력
//            for(int j: photo.keySet()){
//                System.out.println(photo.keySet().toString());
//                System.out.println(j + " ==> " +
//                        "순서 " +  photo.get(j)[0] +
//                        "   추천수 " + photo.get(j)[1]);
//            }
//            System.out.println("============");

        }

        // 사진틀에 사진이 게시된 학생들의 학생번호를 오름차순으로 정렬한다.
        sortStudentNums(sb, photo);

        System.out.println(sb);
    }

    private static void sortStudentNums(StringBuilder sb, Map<Integer, int[]> photo) {

        //사진틀 map의 key값인 학생들의 학생번호를 저장할 배열
        int size = photo.keySet().size();
        int[] student = new int[size];
        int idx = 0;
        for (int s : photo.keySet()) {
            student[idx++] = s;
        }

        //정렬
        Arrays.sort(student);

        //출력을 위해 Stringbuilder에 넣는다.
        for(int i = 0; i< size; i++){
            sb.append(student[i]).append(" ");
        }
    }

    public static int delete(Map<Integer, int[]> photo) {

        int minCnt = Integer.MAX_VALUE; // 최소 추천
        int prior = Integer.MAX_VALUE; // 순서 빠른거
        int key = 0;
        for (int k : photo.keySet()) { // 학생 번호
            int[] info = photo.get(k); // value: 순서, 추천수
            int order = info[0]; // 순서
            int cnt = info[1]; // 추천수

            if (cnt < minCnt) { // 추천수 작은 거 고르기
                minCnt = cnt;
                prior = order;
                key = k;
            } else if (cnt == minCnt) { // 제일 작은 추천수가 여러개면 입력 순서가 가장 작은 학생
                if (order < prior) {
                    prior = order;
                    key = k;
                }
            }
        }
        System.out.println(key);
        return key;
    }
}