package java_test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class absHeap{
	ArrayList<Integer> heap;
	absHeap(){
		heap = new ArrayList<Integer>();
		heap.add(-1);
	}
	public void insert(int num) {
		if(num==0) {
			delete();
			return;
		}
		heap.add(num);
		int idx = heap.size()-1;
		while(idx>1) {
			if(Math.abs(num)<Math.abs(heap.get(idx/2))||
			Math.abs(num)==Math.abs(heap.get(idx/2))&&num<heap.get(idx/2)) {
			int temp = heap.get(idx/2);
			heap.set(idx/2,num);
			heap.set(idx, temp);
			idx/=2;
			}
			else
				break;
		}
	}
	public void delete() {
		if(heap.size()-1<1){
			System.out.println(0);
			return;
		}
		int deleteNum = heap.get(1);
		heap.set(1, heap.get(heap.size()-1));
		heap.remove((heap.size()-1));
		int idx=1;
		while(idx*2<heap.size()) {
			if(idx*2+1<heap.size()&&(Math.abs(heap.get(idx*2))>Math.abs(heap.get(idx*2+1))||
			Math.abs(heap.get(idx*2))==Math.abs(heap.get(idx*2+1))&&heap.get(idx*2)>heap.get(idx*2+1)))
				idx=idx*2+1;
			else
				idx=idx*2;
			if(Math.abs(heap.get(idx))>Math.abs(heap.get(idx/2))||
			Math.abs(heap.get(idx))==Math.abs(heap.get(idx/2))&&heap.get(idx)>heap.get(idx/2))
				break;
			int temp = heap.get(idx/2);
			heap.set(idx/2,heap.get(idx));
			heap.set(idx, temp);
		}
		System.out.println(deleteNum);
	}
}

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int[] x = new int[n];
		absHeap heap = new absHeap();
		for(int i=0;i<n;i++) {
			x[i]=Integer.parseInt(bf.readLine());
			heap.insert(x[i]);
		}
	}
}
