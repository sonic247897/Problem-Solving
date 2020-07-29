package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Greedy_1285 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			char[][] A = new char[n][n];
			for(int i=0; i<n; ++i) {
				String tmp = br.readLine();
				for(int j=0; j<n; ++j) {
					A[i][j] = tmp.charAt(j);
				}
			}
			// ��� �࿡ ���ؼ� �ٲ���/ �ȹٲ��� ���ؼ� 2^N�� Ǯ��� �Ѵ�. 
			// ���� T�� ������ ���� �������� ���� �ٷ� ��������.
			// 	=> �ð����⵵ O(2^N * N^2)
			int answer = go(A, n, 0);
			bw.write(Integer.toString(answer));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int go(char[][] A, int n, int idx) {
		if(idx == n) {
			// ���� ������ ���θ� ���� ����������, ���� ������ ���δ� ������ ��������. 
			// ������ ������ �ʰ� T�� H ���� �߿� �� ���� �͸� ã���� �� => O(n^2)
			int cnt = 0;
			for(int j=0; j<n; ++j) {
				int cnt_T = 0;
				for(int i=0; i<n; ++i) {
					if(A[i][j] == 'T')
						++cnt_T;
				}
				cnt_T = cnt_T <= (n-cnt_T) ? cnt_T : (n-cnt_T);
				cnt += cnt_T;
			}
			return cnt;
		}
		// ������ �ʴ� ���
		int result1 = go(A, n, idx+1);
		// ������ ���
		for(int j=0; j<n; ++j) {
			if(A[idx][j] == 'H') 
				A[idx][j] = 'T';
			else 
				A[idx][j] = 'H';
		}
		int result2 = go(A, n, idx+1);
		
		return result1 <= result2 ? result1: result2;
	}
	
}
