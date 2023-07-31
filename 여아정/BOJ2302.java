package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class dpdpdp {

	public static void main(String[] args) throws  IOException {
		// TODO Auto-generated method stub
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		int n=Integer.parseInt(bf.readLine());
		int vip=Integer.parseInt(bf.readLine());
		boolean[] seat=new boolean[n+2];
		int[] dp;
		
	    int cnt=1;
		if(vip!=0) {
			for(int i=0;i<vip;i++) {
				seat[Integer.parseInt(bf.readLine())]=true;
			}
			if(n==vip) {
		    	System.out.println(1);
		    	return;
		    }
		}
		
		dp=new int[n+2];
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n;i++) {
			dp[i]=dp[i-1]+dp[i-2];
		}
			
		ArrayList<ArrayList<Integer>>team_Seat=new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer>arr=new ArrayList<>();
	    for(int i=1;i<seat.length-1;i++) {
	    	if(seat[i]!=true) {//일반자리
	    		arr.add(i);
	    		if(i==seat.length-2) {
	    			ArrayList<Integer>temp=new ArrayList<>(arr);
	    			team_Seat.add(temp);
	    		}
	    	}else {//vip자리
	    		if(i==1 ||arr.isEmpty()) {
	    		}else {
	    			ArrayList<Integer>temp=new ArrayList<>(arr);
	    			team_Seat.add(temp);
	    			arr=new ArrayList<>();
	    		}	
	    	}
	    }
	    for(int i=0;i<team_Seat.size();i++) {
	    	cnt*=dp[team_Seat.get(i).size()];
	    }
			
		System.out.println(cnt);
	}
}
