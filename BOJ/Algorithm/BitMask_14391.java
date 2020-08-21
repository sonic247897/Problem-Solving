package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// ������ ĭ�� ���ؼ� �������� �������� ���ϸ� �ȴ�.
// 2���� �迭 -> 1���� �迭 (��Ʈ����ũ ��)
// �ִ� ���� ���� = 16�� �̹Ƿ� bitmask���� ��Ÿ�� �� �ִ�.
public class BitMask_14391 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int m = Integer.parseInt(tmp[1]);
			// 2���� �迭 -> 1���� �迭 (��Ʈ����ũ ��)
			int[] a = new int[n*m];
			for(int i=0; i<n; ++i) {
				String str = br.readLine();
				for(int j=0; j<m; ++j) {
					a[i*m+j] = str.charAt(j)-'0';
				}
			}
			
			int ans = 0;
			// ��Ʈ����ũ �� (0: ����, 1: ����)
			int total = (1<< (n*m));
			for(int i=0; i< total; ++i) {
				// ���θ� �� ������ �˻�, ���θ� �� ���� �˻�
				// 	=> �ߺ����� �� ���°� ��������? check�迭 �ʿ� 
				// 	-> check�迭�� ���� �˻��ϴ� �迭�� ������ �����Ƿ� �Ȱ��� ��Ʈ����ũ ���� �ٲ���
				int sum = 0;
				int check = 0; // 0: ���� �˻� �� ��, 1: �̹� �˻��� 
				for(int k=0; k< n*m; ++k) {
					if((check & (1<<k)) != 0) continue;
					if((i & (1<<k)) == 0) { // ���� ���� - ���� ������� �˻��ؾ� ��
						int _tmp = a[k];
						int cur_row = k/m; // ���� ��
						check |= (1<<k);
						int next = k+1;
						while((i & (1<<next)) == 0 && next/m == cur_row) {
							_tmp = _tmp*10 + a[next];
							check |= (1<<next);
							++next;
						}
						sum += _tmp;
					// ����k�� ���µ� �׳� if���� ���� �ʴ� ������ k<n*m������ for������ �ٽ� üũ���ַ��� �̴�.
					}else { // ���� ���� - ���� �������� �˻�
						int _tmp = a[k];
						check |= (1<<k);
						int next = k + m; // ���� ��
						while((i & (1<<next)) != 0 && next < n*m) {
							_tmp = _tmp*10 + a[next];
							check |= (1<<next);
							next += m;
						}
						sum += _tmp;
					}
				}
				if(ans < sum) ans = sum;
			}
			
			bw.write(Integer.toString(ans));
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
