package java_test;

import java.util.Scanner;

public class Main {
	static int n, s;
	static int sum=0;
	static int ans=0;	
	static int[] arr;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		s=sc.nextInt();
		arr = new int[n];
		for(int i=0;i<n;i++)
			arr[i]=sc.nextInt();
		subsequence(0, 0);
		System.out.println(ans);
	}
	
	static void subsequence(int idx, int num) {
		if(num>0&&sum==s)
			ans++;
		for(int i=idx;i<n;i++) {
			sum+=arr[i];
			subsequence(i+1, num+1);
			sum-=arr[i];
		}
	}
}