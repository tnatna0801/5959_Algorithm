import java.io.*;
import java.util.*;

public class BOJ1713 {
    static int N, T;
    static int[] old = new int[101]; // 각 사진들이 게시된 시간
    static Map<Integer, Integer> frame = new HashMap<>(); // 사진틀
    static ArrayList<Integer> list = new ArrayList<>(); // 결과

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++) {
            int num = Integer.parseInt(st.nextToken()); // 추천받은 학생
            if(frame.size() < N) { // 사진틀에 사진이 N개보다 적은 경우
                if(frame.containsKey(num)) { // 추천받은 학생이 이미 게시되었으면
                    int vote = frame.get(num);
                    frame.put(num, vote+1); // 추천받은 횟수만 증가
                }
                else { // 새로운 학생이면
                    frame.put(num, 1); // 새로 사진틀에 추가
                }
                for(int key: frame.keySet()) {
                    old[key]++; // 사진들이 게시된 시간 증가
                }
            }
            else { // 사진틀에 사진이 N개인 경우
                if(frame.containsKey(num)) { // 추천받은 학생이 이미 게시되었다면
                    int vote = frame.get(num);
                    frame.put(num, vote+1); // 추천받은 횟수만 증가

                }
                else { // 새로 게시되는 경우
                    int min = 10000;
                    for(int key : frame.keySet()) {
                        min = Math.min(min, frame.get(key)); // 최소 추천횟수
                    }
                    remove(min); // 최소 추천횟수인 사진 지우기
                    frame.put(num, 1); // 새로 추천 받은 학생의 사진 게시
                }
                for(int key: frame.keySet()) {
                    old[key]++; // 사진들이 게시된 시간 증가
                }
            }
        }
        for(int key : frame.keySet()) {
            list.add(key); // 최종 후보 저장
        }
        Collections.sort(list);
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i)+" ");
        }
        System.out.println(sb.toString()); // 최종후보 오름차순으로 정렬 후 출력
    }

    static void remove(int min) {
        int oldestKey=0;
        for(int key : frame.keySet()) {
            if(frame.get(key) == min) { // 추천횟수가 가장 적은 학생을 찾으면
                if(oldestKey == 0) { // 처음 찾은 경우
                    oldestKey = key; // 삭제 대상 번호에 추가
                }
                else {
                    if(old[oldestKey] < old[key]) {
                        oldestKey = key; // 최소 추천횟수, 게시된지 가장 오래된 사진 찾기
                    }
                }
            }
        }
        frame.remove(oldestKey); // 추천횟수가 가장 적은 사진 삭제
        old[oldestKey] = 0; // 게시된 시간 초기화
    }
}
