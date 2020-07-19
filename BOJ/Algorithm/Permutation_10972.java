package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Permutation_10972 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] perm = new int[n];
			for(int i=0; i<n; ++i)
				perm[i] = Integer.parseInt(tmp[i]);
			
			if(next_permutation(perm, n) == false) {
				bw.write(Integer.toString(-1)); // 마지막 수열이면 -1
			}else {
				StringBuilder sb = new StringBuilder();
				for(int i=0; i<n; ++i) {
					sb.append(perm[i]).append(' ');
				}
				bw.write(sb.toString());
			}
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	static boolean next_permutation(int[] a, int n) {
		// 1. A[i-1] < A[i] 를 만족하는 가장 큰 i를 찾는다.
		int i = n-1;
		while(i > 0 && a[i-1] >= a[i]) --i;
		if (i <= 0) return false; // 마지막 순열(내림차순)
		// 2. j ≥ i 이면서 A[j] > A[i-1] 를 만족하는 가장 큰 j를 찾는다.
		int j = n-1;
		while(a[j] <= a[i-1]) --j;
		// 3. A[i-1] 과 A[j] 를 swap
		int tmp = a[i-1];
		a[i-1] = a[j];
		a[j] = tmp;
		// 4. A[i] 부터 순열을 뒤집는다.
		j = n-1;
		while(i < j) {
			tmp = a[i];
			a[i] = a[j];
			a[j] = tmp;
			++i; --j;
		}
		return true;
	}
	
}
