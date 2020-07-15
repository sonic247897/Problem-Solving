package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 잘 이해 안감
public class DP_2225 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] d = new int[201][201];
		
		try {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]); 
			int K = Integer.parseInt(tmp[1]);
			
			d[0][0] = 1;
			for(int i=1; i<= K; ++i) {
				for(int j=0; j<= N; ++j) {
					for(int l=0; l <= j; ++l) {
						d[i][j] += d[i-1][j-l];
						d[i][j] %= 1000000000;
					}
				}
			}
			bw.write(Integer.toString(d[K][N]));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
