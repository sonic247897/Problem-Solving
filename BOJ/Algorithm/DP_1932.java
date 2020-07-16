package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_1932 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[][] d = new int[n][n];
			
			d[0][0] = Integer.parseInt(br.readLine());
			for(int i=1; i<n; ++i) {
				String[] tmp = br.readLine().split(" ");
				// �� ���� �ٷ� �������ۿ� �� �����´�.
				d[i][0] = d[i-1][0] + Integer.parseInt(tmp[0]); // ���� ��
				for(int j=1; j<i; ++j) { // ��� �κ�
					d[i][j] = Math.max(d[i-1][j-1], d[i-1][j]) + Integer.parseInt(tmp[j]);
				}
				d[i][i] = d[i-1][i-1] + Integer.parseInt(tmp[i]); // ������ ��
			}
			
			int max = 0;
			for(int i=0; i<n; ++i) {
				if(d[n-1][i] > max) max = d[n-1][i];
			}
			
			bw.write(Integer.toString(max));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
