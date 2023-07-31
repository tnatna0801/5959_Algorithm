package java_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String[] input = new String[6];
		for(int i=0;i<6;i++) {
			input[i]=bf.readLine();
		}
		boolean isAvaible=false;
		String[] result = new String[6];
		for(int i=0;i<6;i++) {
			for(int j=0;j<6;j++) {
				if(j==i) continue;
				for(int k=0;k<6;k++) {
					if(k==i||k==j) continue;
					String[] puzzle = new String[6];
					puzzle[0]=input[i];
					puzzle[1]=input[j];
					puzzle[2]=input[k];
					puzzle[3]=Character.toString(input[i].charAt(0))+Character.toString(input[j].charAt(0))+Character.toString(input[k].charAt(0));
					puzzle[4]=Character.toString(input[i].charAt(1))+Character.toString(input[j].charAt(1))+Character.toString(input[k].charAt(1));
					puzzle[5]=Character.toString(input[i].charAt(2))+Character.toString(input[j].charAt(2))+Character.toString(input[k].charAt(2));
					for(int l=0;l<6;l++)
						result[l]=puzzle[l];
					Arrays.sort(puzzle);
					
					int cnt=0;
					for(int l=0;l<6;l++) {
						if(input[l].equals(puzzle[l]))
							cnt++;
					}
					if(cnt==6) {
						isAvaible=true;
						break;
					}
				}
			if(isAvaible)
				break;
			}
		if(isAvaible)
			break;
		}
		if(isAvaible) {
			for(int i=0;i<3;i++)
				System.out.println(result[i]);
		}
		else
			System.out.println(0);
	}
}
