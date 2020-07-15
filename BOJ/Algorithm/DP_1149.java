package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_1149 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// 0: 빨강, 1: 초록, 2: 파랑
		int[][] d = new int[1000][3]; 
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] color = br.readLine().split(" ");
			d[0][0] = Integer.parseInt(color[0]);
			d[0][1] = Integer.parseInt(color[1]);
			d[0][2] = Integer.parseInt(color[2]);

			for(int i=1; i<n; ++i) {
				color = br.readLine().split(" ");
				// 최소비용 저장
				d[i][0] = (d[i-1][1] < d[i-1][2] ? d[i-1][1] : d[i-1][2]) +Integer.parseInt(color[0]);
				d[i][1] = (d[i-1][0] < d[i-1][2] ? d[i-1][0] : d[i-1][2]) +Integer.parseInt(color[1]);
				d[i][2] = (d[i-1][0] < d[i-1][1] ? d[i-1][0] : d[i-1][1]) +Integer.parseInt(color[2]);
			}
			int min = d[n-1][0];
			if(d[n-1][1] < min) min = d[n-1][1];
			if(d[n-1][2] < min) min = d[n-1][2];
			bw.write(Integer.toString(min));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
