package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 머지소트에서 배열 합병하는 과정 구현
// : 정렬된 두 배열 합병하면서 정렬하기 O(N)
public class MergeSort_11728 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			
			tmp = br.readLine().split(" ");
			int[] A = new int[n];
			for(int i=0; i<n; ++i)
				A[i] = Integer.parseInt(tmp[i]);
			
			tmp = br.readLine().split(" ");
			int[] B = new int[m];
			for(int i=0; i<m; ++i)
				B[i] = Integer.parseInt(tmp[i]);
			
			// 3개 idx 필요
			int[] ans = new int[n+m];
			int i=0, j=0, k=0;
			while(i<n && j<m) {
				if(A[i] <= B[j])
					ans[k++] = A[i++];
				else
					ans[k++] = B[j++];
			}
			while(i<n)
				ans[k++] = A[i++];
			while(j<m)
				ans[k++] = B[j++];
			
			StringBuilder sb = new StringBuilder();
			for(int l=0; l<ans.length; ++l) 
				sb.append(ans[l]).append(' ');
			bw.write(sb.toString());
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
