

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_3085 {
	static int search(String[][] candy) {
	    int max=1;
	    

	    for(int i=0;i<candy.length;i++) {
	        for(int j=0;j<candy[i].length;j++) {
	            //µ¿
	            if(j+1<candy.length /*&& !(candy[i][j].equals(candy[i][j+1]))*/ ) {
	                change(candy,i,j,i,j+1);
	                
	                max=Math.max(findLine(candy,0),max);
	                change(candy,i,j,i,j+1);
	            }
	            //ºÏ
	            if(i-1>=0 /*&& !(candy[i][j].equals(candy[i-1][j]))*/ ) {
	                change(candy,i,j,i-1,j);
	                max=Math.max(findLine(candy,0),max);
	                change(candy,i,j,i-1,j);
	            }
	            //¼­
	            if(j-1>=0 /*&& !(candy[i][j].equals(candy[i][j-1]))*/) {
	                change(candy,i,j,i,j-1);
	                max=Math.max(findLine(candy,0),max);
	                change(candy,i,j,i,j-1);
	            }//³²
	            if(i+1<candy.length /*&& !(candy[i][j].equals(candy[i+1][j]))*/) {
	                change(candy,i,j,i+1,j);
	                max=Math.max(findLine(candy,1),max);
	                change(candy,i,j,i+1,j);
	            }
	        }
	    }
	    return max;
	}
	 static int findLine(String[][] candy, int n) {
	    int max=1;
	    int cnt_i=0;
	    int cnt_j=0;
	    
	    for(int i=0;i<candy.length;i++) {
	        String keep_j=null;
	        String keep_i=null;
	        cnt_i=0;
	        cnt_j=0;
	        for(int j=0;j<candy.length;j++) {
	            if(keep_j==null &&keep_i==null) {
	                keep_j=candy[i][j];
	                keep_i=candy[j][i];
	                cnt_j++;
	                cnt_i++;
	            }else {
	                if(!(candy[i][j].equals(keep_j))) {
	                	max=Math.max(max, cnt_j);
	                    keep_j=candy[i][j];
	                    cnt_j=1;
	                    
	                }else if(candy[i][j].equals(keep_j)) {
	                    cnt_j++;
	                }
	                if(!(candy[j][i].equals(keep_i))) {
	                	max=Math.max(max, cnt_i);
	                    keep_i=candy[j][i];
	                    cnt_i=1;
	                }else {
	                    cnt_i++;
	                }
	            }
	        }int one=Math.max(cnt_i, cnt_j);
	        max=Math.max(max, one);
	    }
	    return max;
	}
	static String[][] change(String[][] candy, int i1, int j1, int i2, int j2) {
	    String temp=candy[i1][j1];
	    candy[i1][j1]=candy[i2][j2];
	    candy[i2][j2]=temp;
	    return candy;
	}
	
	public static void main(String[] args) throws IOException {
	    // TODO Auto-generated method stub
	    BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
	    
	    int n=Integer.parseInt(bf.readLine());
	    String[][]candy=new String[n][n];
	    
	    for(int i=0;i<n;i++) {
	        String in=bf.readLine();
	        candy[i]=in.split("");
	    }
	    
	    System.out.println(search(candy));
	    
	}
}
