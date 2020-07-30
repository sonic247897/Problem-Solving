package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// �迭 �ȿ��� ���� ������ ���� = ����index - ����index
//	=> ����, ���� ã��: �̺�Ž��
// �ð����⵵: O(M*lgN)
public class BinarySearch_10816 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] card = new int[n];
			String[] tmp = br.readLine().split(" ");
			for(int i=0; i<n; ++i)
				card[i] = Integer.parseInt(tmp[i]);
			// �̺� Ž���� ���� ���� ����
			Arrays.sort(card);
			
			int m = Integer.parseInt(br.readLine());
			int[] ans = new int[m];
			tmp = br.readLine().split(" ");
			for(int i=0; i<m; ++i) {
				int num = Integer.parseInt(tmp[i]);
				// �̺� Ž�� - @ left�� right�� �Ź� �ʱ�ȭ ����� �Ѵ�!
				// upper bound
				int left = 0; 
				int right = n-1;
				int upperBound = -1;
				while(left <= right) {
					int mid = (left+right)/2;
					if(card[mid] == num) {
						upperBound = mid+1;
						left = mid+1;
					}else if(card[mid] > num) {
						right = mid-1;
					}else {
						left = mid+1;
					}
				}
				// lower bound
				left = 0; 
				right = n-1;
				int lowerBound = -1;
				while(left <= right) {
					int mid = (left+right)/2;
					if(card[mid] == num) {
						lowerBound = mid;
						right = mid-1;
					}else if(card[mid] > num) {
						right = mid-1;
					}else {
						left = mid+1;
					}
				}
				ans[i] = upperBound - lowerBound;
			}
			
			for(int i=0; i<m; ++i) {
				bw.write(Integer.toString(ans[i]));
				bw.write(' ');
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
