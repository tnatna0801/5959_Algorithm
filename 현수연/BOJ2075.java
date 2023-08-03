import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<n;i++) {
			String[] str = br.readLine().split(" ");
			for(int j=0;j<n;j++)
				queue.add(Integer.parseInt(str[j]));
		}
		for(int i=0;i<n-1;i++)
			queue.remove();
		System.out.println(queue.peek());
	}
}
