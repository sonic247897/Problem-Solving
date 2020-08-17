package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BruteForce_1248 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			char[][] sum = new char[n][n]; // i는 항상 j보다 작거나 같다. => 대각선 기준으로 윗부분 삼각형만 채운다.
			int[] a = new int[n];
			
			for(int i=0; i<n; ++i) {
				for(int j=i; j<n; ++j) 
					sum[i][j] = (char) br.read();
			}

			go(0, n, a, sum);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	static boolean check(int idx, int[] a, char[][] sum) {
		for(int i=0; i<idx; ++i) {
			// i < idx
			int tmp = 0;
			// sum[i][j] = a[i]~a[j]까지의 합
			for(int j=i; j<=idx; ++j) {
				tmp += a[j];
			}
			// 한 번이라도 결과 잘 못 나오면 false
			if(tmp > 0) {
				if(sum[idx][i] != '+')
					return false;
			}else if(tmp < 0){
				if(sum[idx][i] != '-')
					return false;
			}else {
				if(sum[idx][i] != '0')
					return false;
			}
		}
		return true;
	}
	
	// 배열 a[] 채워서 리턴 - a의 idx번째 수 정하고 다음경우 호출
	static void go(int idx, int n, int[] a, char[][] sum) {
		// 모든 수 정하면 검사하고 리턴 - 앞에서 먼저 검사하므로 그냥 리턴
		if(idx == n) {
			
			return;
		}
	
		// 다음 경우 호출 - idx열 검사(백트래킹)
		if(sum[idx][idx] == '0') {
			a[idx] = 0;
			if(check(idx, a, sum)) {
				go();
				return;
			}
			// 결과가 false면 앞에서부터 잘못 
		}
			
		
		for(int i=1; i<=10; ++i) {
			
		}
		
	}
}
