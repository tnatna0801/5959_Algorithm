package code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class boj_2784 {
	static char[][] block=new char[3][3];
	static int[] chk=new int[6];
	static Set<List<String>>result=new HashSet<>();
	
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

        String[] word=new String[6];
        
	
        for(int i=0;i<word.length;i++) {
            word[i]=bf.readLine();
        }
        int cnt=0;
        int now=0;
		
        makeFirstBox(block,word,chk);
        
        if(result.isEmpty()) {
        	System.out.println(0);
        	
        }else {
        	sortt();
        }
    }

	public static void makeFirstBox(char[][]block, String[] word, int[] chk){//가장 위 가로줄 생성
	    //초기값 설정
		for(int j=0;j<word.length;j++) {
			
            for(int i=0;i<word[j].length();i++) {
            	
                block[0][i]=word[j].charAt(i);
            }
            chk[j]=1;
            makeFullBox(block, word, chk, 0);//나머지값 정하는 함수로
            chk[j]=0;
        }
	}
	        
	public static void makeFullBox(char[][]block, String[] word, int[] chk, int now){
		if(now==block.length) {
			checkCnt(block,word,0);
			return;
		}else {
			for(int i=now;i<block.length;i++) {
		    	int is=0;
		        for(int j=0;j<word.length;j++) {
		            if(block[0][i]==word[j].charAt(0) && chk[j]!=1) {
		                for(int k=1;k<word[j].length();k++) {
		                    block[k][i]=word[j].charAt(k);
		                }
		                is++;
		                chk[j]=1;
		                makeFullBox(block,word,chk,i+1);
		                chk[j]=0;
		                is--;
		            }
		        }
		        if(is==0) {//앞글자가 맞는 단어가 없는 경우
		        	return;
		        }
		    }
		}
	    
	}
	
	public static void checkCnt(char[][]block, String[] word, int cnt) {//입력과 가로세로 string이 같은지 체크
		int[]use=new int[word.length];
		
		for(int i=0;i<block.length;i++) {
			String temp_i=new String(block[i]);
			String temp_j="";
			
			for(int j=0;j<block.length;j++) {
				temp_j+=block[j][i];
			}
			int[] flag=new int[2];
			for(int k=0;k<word.length;k++) {
				if(temp_i.equals(word[k]) && use[k]!=1 && flag[0]!=1) {
					cnt++;
					use[k]=1;
					flag[0]=1;
				}
				if(temp_j.equals(word[k])  && use[k]!=1 && flag[1]!=1) {
					cnt++;
					use[k]=1;
					flag[1]=1;
				}
			}
		}
		
		if(cnt==word.length) {//개수 동일 체크

			List<String> list=new ArrayList<>();
			
			for(int i=0;i<block.length;i++) {
				String temp=new String(block[i]);
				list.add(temp);
			}
			List<String>swap=new ArrayList<>(list);
			result.add(swap);
		}
	}
	
	public static void sortt() {
		List<List<String>> t=new ArrayList<>(result);
		String[] real=new String[3];
        int n=0;
        int idx=0;
        String[] compair = null;
        
        while(idx<3) {
        	compair = new String[t.size()];
        	for(int i=0;i<t.size();i++) {
        		compair[i]=t.get(i).get(idx);
        	}
        	
        	Arrays.sort(compair,Comparator.naturalOrder());
        	
        	real[idx]=compair[0];
        	n=0;
        	
        	for(int i=1;i<compair.length;i++) {
				if(compair[0].equals(compair[i])) {
					n++;
				}
        	}
        	if(n==0) {
        		break;
        	}
        	idx++;
        }
        
        for(int i=0;i<t.size();i++) {
        	int count=0;
        	for(int j=0;j<=idx;j++) {
        		if(t.get(i).get(j).equals(real[j])) {
        			count++;
        		}
        	}
        	if(count==idx+1) {
        		for(int j=0;j<t.get(i).size();j++) {
        			System.out.println(t.get(i).get(j));
        		}
        	}
        }
    	
	}
}


