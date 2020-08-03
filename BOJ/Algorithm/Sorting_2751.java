package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;

public class Sorting_2751 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			for(int i=0; i<n; ++i) 
				a[i] = Integer.parseInt(br.readLine());
			
			// Arrays.sort가 퀵소트라서 최악의 경우 O(N^2)으로 시간초과가 발생한다.
			// 	=> 해결법: 정렬하기 전에 원소를 섞어준다.
			shuffle(a); 
			Arrays.sort(a);
			
			for(int i=0; i<n; ++i) {
				bw.write(Integer.toString(a[i]));
				bw.write('\n');
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// O(n)
	static void shuffle(int[] a) {
		Random random = new Random();
		for(int i=a.length-1; i>0; --i) {
			int index = random.nextInt(i+1); // 0~i까지의 int 난수 반환
			int tmp = a[index];
			a[index] = a[i];
			a[i] = tmp;
		}
	}
}
