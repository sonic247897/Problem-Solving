package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_13398 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			// 0: 제외한 수 없음, 1: 한개 제외함 
			int[][] d = new int[n][2];
			String[] tmp = br.readLine().split(" ");
			
			d[0][0] = Integer.parseInt(tmp[0]);
			d[0][1] = 0;
			
			// 단, 수는 한 개 이상 선택해야 한다.
			if(n == 1) {
				bw.write(Integer.toString(d[0][0]));
				bw.flush();
				return;
			}
			
			for(int i=1; i<n; ++i) {
				int cur = Integer.parseInt(tmp[i]);
				// 1. 제외하지 않는 경우
				//	- 제외X + 현재 원소 포함/ 현재 원소부터 시작
				d[i][0] = Math.max(d[i-1][0]+cur, cur);
				// 2. 제외한 경우
				//	- 현재 원소 제외/ 이미 제외한 수열(현재 원소는 제외할 수 없으므로 더해줘야 함)
				d[i][1] = Math.max(d[i-1][0], d[i-1][1]+cur);
			}
			
			int answer = Math.max(d[0][0], d[0][1]);
			for(int i=1; i<n; ++i) {
				if(answer < d[i][0]) answer = d[i][0];
				if(answer < d[i][1]) answer = d[i][1];
			}
			
			bw.write(Integer.toString(answer));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
