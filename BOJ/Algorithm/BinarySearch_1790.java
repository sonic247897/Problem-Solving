package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BinarySearch_1790 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int k = Integer.parseInt(tmp[1]);
			
			// �� ��° ������ ������ �� �� Ȯ���� ����.
			int left = 1; // �ּҰ�
			int right = n; // �ִ밪
			int ans = -1;
			while(left <= right) {
				int mid = (left+right)/2;
				// 1~mid���� ��ģ ���� ���� ���ϱ�
				// 1 �� N �� 100000000 (�ִ� 9�ڸ�)
				int length = 0;
				int d = 1; // 10���� �������� ���
				int cnt = 1; // �ڸ���
				while(mid-d >= 0) {
					// d*10-1 = 9, 99, 999, ..
					length += (Math.min(d*10-1, mid)-d+1)*cnt; 
					d *= 10;
					++cnt;
				}
				// mid�� ���� ���� �����Ǵ� ���� �ȿ� k�� ���ϴ��� Ȯ��
				if(length-cnt+1 <= k && k <= length){
					int start = length-cnt+1;
					int end = length;
					// ��ⷯ ����� ������ �������� ���ʴ�� ���� ���� ���� ���ڸ����� ���ϴ� ���� ����
					for(int i=end; i>=start ; --i) {
						int num = mid%10;
						mid /= 10;
						if(i == k) { 
							ans = num;
						}
					}
				}
				// ���� ã������ ��
				if(ans != -1) break;
				// ���� �� ã������ �̺�Ž�� ���
				if(k < length-cnt+1) right = mid-1;
				if(k > length) left = mid+1;
			}
			
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
