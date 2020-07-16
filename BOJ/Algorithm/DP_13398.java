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
			// 0: ������ �� ����, 1: �Ѱ� ������ 
			int[][] d = new int[n][2];
			String[] tmp = br.readLine().split(" ");
			
			d[0][0] = Integer.parseInt(tmp[0]);
			d[0][1] = 0;
			
			// ��, ���� �� �� �̻� �����ؾ� �Ѵ�.
			if(n == 1) {
				bw.write(Integer.toString(d[0][0]));
				bw.flush();
				return;
			}
			
			for(int i=1; i<n; ++i) {
				int cur = Integer.parseInt(tmp[i]);
				// 1. �������� �ʴ� ���
				//	- ����X + ���� ���� ����/ ���� ���Һ��� ����
				d[i][0] = Math.max(d[i-1][0]+cur, cur);
				// 2. ������ ���
				//	- ���� ���� ����/ �̹� ������ ����(���� ���Ҵ� ������ �� �����Ƿ� ������� ��)
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
