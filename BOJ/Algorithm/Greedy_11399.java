package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Greedy_11399 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] times = new int[n];
			for(int i=0; i<n; ++i) {
				times[i] = Integer.parseInt(tmp[i]);
			}
				
			// 오름차순 정렬
			Arrays.sort(times);
			
			int sum = 0;
			for(int i=0; i<n; ++i) {
				sum += times[i]*(n-i);
			}
			
			bw.write(Integer.toString(sum));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
