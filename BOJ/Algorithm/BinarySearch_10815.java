package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// �˻� - �̺�Ž���� ���� ����
// (���� ���� + �׳� ���翩�� Ž���̹Ƿ� boolean�迭�� ���� O(1)�� ã�� ���� ������
//	�־��� ������ ������ �ʹ� Ŀ�� �޸𸮰� �ʰ��� �� �ִ�.)
public class BinarySearch_10815 {
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
				int left = 0; 
				int right = n-1;
				boolean isFound = false;
				while(left <= right) {
					int mid = (left+right)/2;
					if(card[mid] == num) {
						ans[i] = 1;
						isFound = true;
						break;
					}else if(card[mid] > num) {
						right = mid-1;
					}else {
						left = mid+1;
					}
				}
				if(isFound == false) ans[i] = 0;
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
