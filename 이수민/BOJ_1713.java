import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Student implements Comparable<Student>{
    int number; // 학생 번호
    int recommended; // 추천 받은 수
    int idx; // 순서

    public Student(int number, int recommended, int idx) {
        super();
        this.number = number;
        this.recommended = recommended;
        this.idx = idx;
    }

    void setStudent(int recommended, int idx){
        this.recommended = recommended;
        this.idx = idx;
    }

    @Override
    public int compareTo(Student o) {
        if (this.recommended == o.recommended)
            return Integer.compare(this.idx, o.idx);
        else
            return Integer.compare(this.recommended, o.recommended);
    }
}

public class BOJ_1713 {
    static int N, number; // 학생 번호 number

    static List<Student> selected;
    static Student[] students;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        selected = new ArrayList<>();
        students = new Student[101];

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int m=0; m<M; m++) {
            number = Integer.parseInt(st.nextToken());

            // 첫 입력인 학생인 경우 객체 할당
            if (students[number] == null)
                students[number] = new Student(number, 0, 0);

            if(students[number].recommended != 0){
                // 이미 사진이 게시된 학생인 경우, 추천받은 횟수만 증가 시킴
                students[number].recommended++;
            }
            else {

                // 빈 사진틀이 없는 경우 문제의 조건에 맞게 사진틀 하나를 비우기 위해 정렬 후 삭제
                if(selected.size() == N){
                    Collections.sort(selected);
                    selected.get(0).recommended = 0;
                    selected.remove(0);
                }

                // 빈 사진틀에 현재 학생을 채우기
                students[number].setStudent(1, m);
                selected.add(students[number]);
            }

        }

        Collections.sort(selected, (o1, o2) -> o1.number - o2.number);
        for(Student s : selected){
            sb.append(s.number).append(" ");
        }

        System.out.println(sb);
    }
}

