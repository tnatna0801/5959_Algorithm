import java.util.*;
import java.util.stream.Collectors;

public class BOJ1213 {
    static Character oneOddKey;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character, Integer> charMap = makeCharMap(sc); // String 을 모두 분할한 Character 배열에서, 
      // 각 문자가 몇 번 등장하는지를 value 로, 각 문자를 key 로 가지는 HashMap 을 만들어 줍니다.
        oneOddKey = null;
        if(haveOnlyOneOrNoOdd(charMap)){ // 홀수 개의 문자가 1개 이상이 있으면, 팰린드롬을 만들지 못합니다. 
            System.out.println(makePalindrome(charMap)); // 홀수 개의 문자가 0개 또는 1개 있을 때, 팰린드롬을 만들어서 
          // 출력해 줍니다.
        }else{
            System.out.println("I'm Sorry Hansoo"); // 팰린드롬을 만들지 못할 때, 출력해 주는 문구입니다.
        }

    }
    static Map<Character, Integer> makeCharMap(Scanner sc){ // 입력을 받아, 문자열 Map 을 만들어 주는 method 입니다.
        char[] inputArray = sc.next().trim().toCharArray(); // 문자열 배열을 먼저 만들어 줍니다.
        Map<Character, Integer> charMap = new HashMap<>();
        for(char c : inputArray){ // try-catch 문을 사용해, map 에 해당 문자가 key 로 존재할 때, 값을 하나 늘려줍니다.
            try{
                Integer value = charMap.get(c);
                charMap.replace(c, value + 1); // 문자가 key 로 존재하지 않으면, NullPointerException 이 발생합니다.
            }catch(NullPointerException e){
                charMap.put(c, 1);  // 위의 NullPointerException 을 만날 때, charMap 에다 새로운 문자를 추가하고, 
              // 값을 1로 세팅해 줍니다.
            }
        }
        return charMap; // 만들어진 HashMap 을 리턴합니다.
    }
    static boolean haveOnlyOneOrNoOdd(Map<Character, Integer> map){
        int oddCount = 0;
        for(Character key : map.keySet()){
            if(map.get(key) % 2 == 1){ // map 의 keyset 에서 나오는 key 들을 순회하며, 홀수의 value 를 가지는
              // key 들이 나타날때마다 카운팅해 줍니다.
                oneOddKey = key; // static 변수입니다. 혹시 홀수의 value 를 딱 하나 가지는 키가 나타났을 때
              // 추후 활용해 주기 위해서 여기서 업데이트해 줍니다.
                oddCount++;
            }
        }
        return oddCount <= 1; // 홀수의 value 를 가지는 key 가 없거나 하나인지 검증합니다.
    }
    static String makePalindrome(Map<Character, Integer> map){
        ArrayDeque<Character> deque = new ArrayDeque<>(); // Deque 자료구조를 사용합니다. 앞뒤로 모두 넣기 위함입니다.
        if(oneOddKey != null){ // 홀수인 key 가 하나 있으면, 맨 처음 deque 에 먼저 넣어 줍니다.
            deque.addLast(oneOddKey);
            int value = map.get(oneOddKey);
            map.replace(oneOddKey, value - 1); // 홀수인 value 에서 하나 줄여 줍니다. 문자를 하나 소모했다고 보는 것입니다.
        }

        List<Character> sortedKey = map.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        // map 의 keyset 을 stream 을 사용해 정렬해 준 뒤, 모아 줍니다. 내림차순 정렬을 통해, Z 에 가까운 문자부터 먼저 넣어 줍니다.
      // 앞뒤로 모두 추가할 것이기 때문에, 내림차순 정렬 이후 Deque 에 넣어 주면, 자동으로 A에 가까운 문자들이 앞뒤로 나중에 들어가게 됩니다.
      // 그럴 때, 사전순으로 앞서게 되는 결과를 가져올 것입니다.
        for(Character c : sortedKey){
            int value = map.get(c); // value 를 먼저 구해주고, 
            for(int i = 0; i < value / 2; i++){ // value / 2 번 만큼 for 문을 돌면서 앞뒤로 문자를 추가해 줍니다.
                deque.addFirst(c);
                deque.addLast(c);
            }
        }
        StringBuilder builder = new StringBuilder();
        deque.forEach(builder::append); // StringBuilder 를 만든 다음, deque 에서 forEach 문을 돌면서 앞에서부터 문자를 추가합니다.
        return builder.toString(); // 결과가 되는 String 을 리턴합니다.
    }
}
