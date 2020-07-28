package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Greedy_2138 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String a = br.readLine();
			String b = br.readLine();
			
			// StringBuilder���� int[] ������
			// 	=> 0->1 �ٲٴ� ������ int�迭�� if�� ���� �� �� �ֱ� ���� 
			int[] A = new int[n];
			int[] A_copy = new int[n];
			int[] B = new int[n];
			for(int i=0; i<n; ++i) {
				A[i] = a.charAt(i) - '0';
				A_copy[i] = A[i];
			}
			for(int i=0; i<n; ++i) {
				B[i] = a.charAt(i) - '0';
			}
			
			// 1. ù ��° ����ġ ������
			int cnt1 = 0;
			A_copy[0] = 1-A_copy[0];
			A_copy[1] = 1-A_copy[1];
			for(int i=1; i<n; ++i) {
				if(A_copy[i-1] == B[i-1]) continue;
				for(int j=i-1; j<= i+1; ++j)
					A_copy[j] = 1-A_copy[j];
				++cnt1;
			}
			if(A_copy[n-1] != B[n-1]) // ������ ���� �ٸ��� �Ұ��� 
				cnt1 = 987654321;
			
			// 2. ù ��° ����ġ ������ ���� ��
			int cnt2 = 0;
			for(int i=1; i<n; ++i) {
				if(A[i-1] == B[i-1]) continue;
				for(int j=i-1; j<= i+1; ++j)
					A[j] = 1-A[j];
				++cnt2;
			}
			if(A[n-1] != B[n-1]) // ������ ���� �ٸ��� �Ұ��� 
				cnt2 = 987654321;
			
			int min = cnt1 >= cnt2 ? cnt1: cnt2;
			if(min == 987654321) {
				bw.write(Integer.toString(-1));
				bw.flush();
			}else {
				bw.write(Integer.toString(min));
				bw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
