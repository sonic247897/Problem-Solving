package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DP_11054 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] input = new int[n];
			int[] LIS_d = new int[n];
			int[] LDS_d = new int[n];
			// LIS_d ���ϱ�
			for(int i=0; i<n; ++i) {
				input[i] = Integer.parseInt(tmp[i]); // �Է°� �ޱ�
				LIS_d[i] = 1; // ���� �ּ� ���� = 1(�ڱ� �ڽ� ����)
				for(int j= i-1; j >= 0; --j) {
					if(input[j] < input[i]) {
						int len = LIS_d[j] + 1;
						if(len > LIS_d[i]) LIS_d[i] = len;
					}
				}
			}
			// LDS_d : �ڿ������� ���ؾ� ��(�ڿ������� �����ϴ� �κ� ����)
			for(int i=n-1; i>=0; --i) {
				LDS_d[i] = 1;
				for(int j = i+1; j < n; ++j) {
					if(input[i] > input[j]) {
						int len = LDS_d[j] + 1;
						if(len > LDS_d[i]) LDS_d[i] = len;
					}
				}
			}
			// ������� ���� ���� = LIS_d + LDS_d -1 (��ġ�� �κ� ���� 1��)
			int max = -1;
			for(int i=0; i<n; ++i) {
				if(max < LIS_d[i] + LDS_d[i]) max = LIS_d[i] + LDS_d[i];
			}
			bw.write(Integer.toString(max-1));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
