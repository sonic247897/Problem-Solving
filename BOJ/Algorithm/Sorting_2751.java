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
			
			// Arrays.sort�� ����Ʈ�� �־��� ��� O(N^2)���� �ð��ʰ��� �߻��Ѵ�.
			// 	=> �ذ��: �����ϱ� ���� ���Ҹ� �����ش�.
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
			int index = random.nextInt(i+1); // 0~i������ int ���� ��ȯ
			int tmp = a[index];
			a[index] = a[i];
			a[i] = tmp;
		}
	}
}
