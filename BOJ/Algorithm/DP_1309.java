package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_1309 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			// 0: ���� ����X, 1: ���ʿ� ����, 2: �����ʿ� ����
			int[][] d = new int[n][3];
			d[0][0] = 1; 
			d[0][1] = 1;
			d[0][2] = 1;
			for(int i=1; i<n; ++i) {
				// ���� �� �ֱ�
				d[i][0] = (d[i-1][0] + d[i-1][1] + d[i-1][2]) % 9901;
				// ���ʿ� ����
				d[i][1] = (d[i-1][0] + d[i-1][2]) % 9901;
				// �����ʿ� ����
				d[i][2] = (d[i-1][0] + d[i-1][1]) % 9901;
			}
			
			int answer = (d[n-1][0]+d[n-1][1]+d[n-1][2]) % 9901;
			bw.write(Integer.toString(answer));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
