import java.io.*;
import java.util.*;

public class boj1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] name = br.readLine().toCharArray();

        // 문자가 나온 횟수를 저장 (key: 문자, value: 횟수)
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char i: name) {
            if (hashMap.containsKey(i)) {
                hashMap.replace(i, hashMap.get(i) + 1);
            } else {
                hashMap.put(i, 1);
            }
        }

        // 대칭될 문자열을 저장할 리스트
        List<Character> result = new ArrayList<>();
        // 중심이 될 문자를 저장할 리스트
        List<Character> temp = new ArrayList<>();

        // 문자 저장 (중복 제외, 정렬)
        Set<Character> keySet = hashMap.keySet();
        List ks = new ArrayList(keySet);
        Collections.sort(ks);

        for (Object key: ks) {
            // 단어 붙이기
            for (int i=0; i<hashMap.get(key)/2; i++) {
                result.add((Character) key);
            }
            // 단어가 나온 횟수가 홀수이면 중심 만들어주기
            if (hashMap.get(key) % 2 != 0) {
                temp.add((Character) key);
            }
        }

        if (temp.size() > 1) {
            // 단어가 나온 횟수가 홀수인 경우가 1을 초과할 경우 팰린드롬을 만들 수 없다.
            bw.write("I'm Sorry Hansoo");
        } else {
            // 팰린드롬을 만들 수 있는 경우 -> 단어를 대칭해서 붙인다.
            for (int i=0; i<result.size(); i++) {
                bw.write(result.get(i));
            }
            if (!temp.isEmpty()) {
                bw.write(temp.get(0));
            }
            for (int i=result.size()-1; i>=0; i--) {
                bw.write(result.get(i));
            }
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }
}

