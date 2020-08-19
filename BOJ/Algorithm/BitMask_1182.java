package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// ���Ұ� �ִ� 20�� => �ִ� ���� = 2^0+2^1+... +2^19 = 2^20-1
// �κм����� bitmask���� ǥ���� �� �ִ�.
public class BitMask_1182 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
		 	int n = Integer.parseInt(tmp[0]);
		 	int s = Integer.parseInt(tmp[1]);
		 	
		 	int[] a = new int[n];
		 	tmp = br.readLine().split(" ");
		 	for(int i=0; i<n; ++i)
		 		a[i] = Integer.parseInt(tmp[i]);
		 	
		 	// ũ�Ⱑ ����� �κм����� 
		 	// -> bitmask�� ������ ���� ó���� ����. (i=0�� �������̹Ƿ� ����)
		 	int ans = 0;
		 	for(int i=1; i< (1<<n); ++i) {
		 		int sum = 0;
		 		for(int k=0; k<n; ++k) {
		 			if((i & (1<<k)) != 0) {
		 				sum += a[k];
		 			}
		 		}
		 		if(sum == s) ++ans;
		 	}
		 	
		 	bw.write(Integer.toString(ans));
		 	bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
