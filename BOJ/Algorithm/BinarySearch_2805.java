package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// ���ܱ� ���� ���� -> ���� ���� ���
public class BinarySearch_2805 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int M = Integer.parseInt(tmp[1]);
			
			tmp = br.readLine().split(" ");
			int[] tree = new int[N];
			int max = 0;
			for(int i=0; i<N; ++i) {
				tree[i] = Integer.parseInt(tmp[i]);
				if(max < tree[i]) max = tree[i];
			}
			
			// ��� M������ ������ ���� �������� ���ؼ� ���ܱ⿡ ������ �� �ִ� ������ �ִ� ã��
			int left = 0;
			int right = max;
			int ans = 0;
			while(left <= right) {
				int mid = (left+right)/2;
				// mid������ ���ܱⰡ �ڸ� �������� ���� ���ϱ�
				long cut = 0; // @ ���� ���� �� int�� �Ѿ �� �ִ�.
				for(int i=0; i<N; ++i) {
					int diff = tree[i] - mid;
					if(diff > 0) cut += diff;
				}
				// M���� �̻� - ���ܱ� �ִ����: ����
				if(cut >= M) {
					ans = mid;
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
			bw.write(Integer.toString(ans));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
