import java.io.*;
import java.util.*;

public class Main {
    static List<Character> charList;
    static Set<Character> essential = new HashSet<>(Arrays.asList('a','n','t','i','c'));
    static int max;
    static List<Set<Character>> charSetList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int numberOfWord = Integer.parseInt(st.nextToken());
        int numberOfAlphabet = Integer.parseInt(st.nextToken());

        if(numberOfAlphabet < 5){
            System.out.println(0);
            return;
        }

        charSetList = new ArrayList<>();
        for(int i = 0; i < numberOfWord; i++){
            charSetList.add(takeSet(br));
        }

        Set<Character> set = new HashSet<>();
        for (Set<Character> characters : charSetList) {
            set.addAll(characters);
        }
        
        if(set.size() <= numberOfAlphabet-5){
            System.out.println(numberOfWord);
            return;
        }
        
        max = -1;
        charList = new ArrayList<>(set);
        makeCombinationList(new HashSet<>(),0,0,numberOfAlphabet-5);
        System.out.println(max);
    }
    static Set<Character> takeSet(BufferedReader br) throws IOException{
        Set<Character> set = new HashSet<>();
        char[] input = br.readLine().toCharArray();
        for (char c : input) {
            if(!essential.contains(c)){
                set.add(c);
            }
        }
        return set;
    }
    static void makeCombinationList(Set<Character> set,int index,int depth, int limit){
        if(depth == limit){
            int count = 0;
            for (Set<Character> characters : charSetList) {
                if (set.containsAll(characters)) {
                    count++;
                }
            }
            if(max < count){
                max = count;
            }
            return;
        }
        for(int i = index; i < charList.size(); i++){
            Set<Character> newSet = new HashSet<>(set);
            newSet.add(charList.get(i));
            makeCombinationList(newSet,i+1,depth+1,limit);
        }
    }
}
