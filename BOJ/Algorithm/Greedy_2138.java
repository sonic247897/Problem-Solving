package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Greedy_2138 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String a = br.readLine();
			String b = br.readLine();
			
			// StringBuilder말고 int[] 쓸거임
			// 	=> 0->1 바꾸는 연산은 int배열이 if문 없이 할 수 있기 때문 
			int[] A = new int[n];
			int[] A_copy = new int[n];
			int[] B = new int[n];
			for(int i=0; i<n; ++i) {
				A[i] = a.charAt(i) - '0';
				A_copy[i] = A[i];
			}
			for(int i=0; i<n; ++i) {
				B[i] = a.charAt(i) - '0';
			}
			
			// 1. 첫 번째 스위치 누를때
			int cnt1 = 0;
			A_copy[0] = 1-A_copy[0];
			A_copy[1] = 1-A_copy[1];
			for(int i=1; i<n; ++i) {
				if(A_copy[i-1] == B[i-1]) continue;
				for(int j=i-1; j<= i+1; ++j)
					A_copy[j] = 1-A_copy[j];
				++cnt1;
			}
			if(A_copy[n-1] != B[n-1]) // 마지막 원소 다르면 불가능 
				cnt1 = 987654321;
			
			// 2. 첫 번째 스위치 누르지 않을 때
			int cnt2 = 0;
			for(int i=1; i<n; ++i) {
				if(A[i-1] == B[i-1]) continue;
				for(int j=i-1; j<= i+1; ++j)
					A[j] = 1-A[j];
				++cnt2;
			}
			if(A[n-1] != B[n-1]) // 마지막 원소 다르면 불가능 
				cnt2 = 987654321;
			
			int min = cnt1 >= cnt2 ? cnt1: cnt2;
			if(min == 987654321) {
				bw.write(Integer.toString(-1));
				bw.flush();
			}else {
				bw.write(Integer.toString(min));
				bw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
