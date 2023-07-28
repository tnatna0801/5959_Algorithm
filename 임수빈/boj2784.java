import java.io.*;

public class boj2784 {
    static String[] words = new String[6];
    static char[][] result = new char[3][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i=0; i<6; i++) {
            words[i] = br.readLine();
        }

        char[][] answer = sol();
        if (answer == null) { // 정답이 없으면 0 출력
            bw.write(0 + "\n");
        } else { // 정답이 있으면 정답 출력
            for (int i=0; i<3; i++) {
                for (int j=0; j<3; j++) {
                    bw.write(answer[i][j]);
                }
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static char[][] sol() {
        // 3중 for문 -> 단어 3개 고르기
        for (int i=0; i<6; i++) {
            for (int j=0; j<6; j++) {
                for (int k=0; k<6; k++) {
                    // 중복되는 단어가 있으면 continue
                    if (i==j || j==k || k==i) {
                        continue;
                    }

                    boolean[] visited = new boolean[6];

                    // 퍼즐 만들기
                    result[0] = words[i].toCharArray();
                    result[1] = words[j].toCharArray();
                    result[2] = words[k].toCharArray();

                    // 사용한 단어 체크
                    visited[i] = true;
                    visited[j] = true;
                    visited[k] = true;

                    // 세로 단어 찾기
                    if (find(visited)) {
                        return result;
                    }
                }
            }
        }

        return null;
    }

    public static boolean find(boolean[] visited) {
        // 세로 단어 배열 만들기 (배열 전치)
        String[] array = transpose();

        // 각 단어를 순회하면서
        for (String i : array) {
            for (int j=0; j<6; j++) {
                // 해당 단어가 존재하는 단어이고, 사용한 적이 없는 단어이면 체크
                if ((!visited[j]) && (i.equals(words[j]))) {
                    visited[j] = true;
                    break;
                }
            }
        }

        // 모든 단어가 사용되지 않았을 때
        for (boolean i : visited) {
            if (!i) {
                return false;
            }
        }

        // 모든 단어가 사용되었을 때
        return true;
    }

    public static String[] transpose() {
        String[] array = new String[3];

        for (int i=0; i<3; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<3; j++) {
                sb.append(result[j][i]);
            }
            array[i] = sb.toString();
        }

        return array;
    }
}
