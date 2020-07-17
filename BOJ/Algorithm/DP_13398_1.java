package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_13398_1 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// DL[i] : i번째 수에서 끝나는 최대 연속합
		// DR[i] : i번째 수에서 시작하는 최대 연속합
		// i번째 수를 제거 했을 때 최대 연속합: DL[i-1]+DR[i+1]
		// i번째 수를 제거하지 않았을 때 최대 연속합: DL[i]
		try {
			int n = Integer.parseInt(br.readLine());			
			int[] d = new int[n];
			String[] tmp = br.readLine().split(" ");
			
			d[0] = Integer.parseInt(tmp[0]);
			
			for(int i=1; i<n; ++i) {
				// 적어도 한 개 수는 포함해야 함
				d[i] = Integer.parseInt(tmp[i]);
				// 나부터 새로 시작하거나 이전 수열에서 합치기
				if(d[i])
			}
			
			// d[0][1]은 한 개도 택하지 않는 공수열이므로 선택지가 될 수 없다!
			//int answer = Math.max(d[0][0], d[0][1]);
			int answer = d[0][0];
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
