package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 원소가 최대 20개 => 최대 정수 = 2^0+2^1+... +2^19 = 2^20-1
// 부분수열을 bitmask수로 표현할 수 있다.
public class BitMask_1182 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
		 	int n = Integer.parseInt(tmp[0]);
		 	int s = Integer.parseInt(tmp[1]);
		 	
		 	int[] a = new int[n];
		 	tmp = br.readLine().split(" ");
		 	for(int i=0; i<n; ++i)
		 		a[i] = Integer.parseInt(tmp[i]);
		 	
		 	// 크기가 양수인 부분수열만 
		 	// -> bitmask는 공집합 제외 처리가 쉽다. (i=0은 공집합이므로 제외)
		 	int ans = 0;
		 	for(int i=1; i< (1<<n); ++i) {
		 		int sum = 0;
		 		for(int k=0; k<n; ++k) {
		 			if((i & (1<<k)) != 0) {
		 				sum += a[k];
		 			}
		 		}
		 		if(sum == s) ++ans;
		 	}
		 	
		 	bw.write(Integer.toString(ans));
		 	bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
