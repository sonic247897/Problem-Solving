package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_13398_1 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		// DL[i] : i��° ������ ������ �ִ� ������
		// DR[i] : i��° ������ �����ϴ� �ִ� ������
		// i��° ���� ���� ���� �� �ִ� ������: DL[i-1]+DR[i+1]
		// i��° ���� �������� �ʾ��� �� �ִ� ������: DL[i]
		try {
			int n = Integer.parseInt(br.readLine());			
			int[] d = new int[n];
			String[] tmp = br.readLine().split(" ");
			
			d[0] = Integer.parseInt(tmp[0]);
			
			for(int i=1; i<n; ++i) {
				// ��� �� �� ���� �����ؾ� ��
				d[i] = Integer.parseInt(tmp[i]);
				// ������ ���� �����ϰų� ���� �������� ��ġ��
				if(d[i])
			}
			
			// d[0][1]�� �� ���� ������ �ʴ� �������̹Ƿ� �������� �� �� ����!
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
