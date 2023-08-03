import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BOJ_2784 {
    static final int NumOfWords = 6; // 6개의 단어
    static final int puzzleSize = 3; // 퍼즐에 필요한 가로/세로 사이즈
    static String[] words = new String[NumOfWords];
    static void dfs(String[] currentWords, boolean[] visited, int cnt){
        if (cnt == puzzleSize){
            check(currentWords); // puzzle 가능 여부 확인
            return;
        }

        for(int i=0; i<NumOfWords; i++){
            if (!visited[i]){
                visited[i] = true;
                currentWords[cnt] = words[i];
                dfs(currentWords, visited, cnt+1);
                visited[i] = false;
            }
        }
    }

    static void check(String[] currentWords){
        List<String> leftWords = new LinkedList<>();
        leftWords.addAll(Arrays.asList(words));
        for (String word : currentWords)
            leftWords.remove(word); // 선택된 단어들 제외하기

        char[] charArr = new char[puzzleSize];
        for(int i=0; i<puzzleSize; i++){
            int idx = 0;

            // 선택된 단어를 기반으로 임시 단어 만들기
            for(String word: currentWords){
                charArr[idx++] = word.charAt(i);
            }
            String tmpWord = String.copyValueOf(charArr);

            // 남은 단어들 중 임시 단어가 있는지 확인
            if(leftWords.contains(tmpWord))
                leftWords.remove(tmpWord);

            if(leftWords.isEmpty())
                print(currentWords);
        }
    }

    static void print(String[] currentWords){
        // 결과 출력
        for(String word: currentWords)
            System.out.println(word);
        System.exit(0);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<NumOfWords; i++)
           words[i] = br.readLine();

        boolean[] visited = new boolean[NumOfWords]; // dfs()에서 방문했는지 여부를 알기 위함
        String[] currentWords = new String[puzzleSize];
        dfs(currentWords, visited, 0);
        System.out.println(0);
    }
}
