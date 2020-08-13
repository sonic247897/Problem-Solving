package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �̺� Ž�� �����ΰ�? => ��� �������� YES/NO�� ��������
// N������ ���� ����� �͵� N���� ����� �Ϳ� ���Եȴ�. �̶� ���� �� �ִ� �ִ� ������ ���̸� ���϶�
// 	=> (���� - N�� ���̺��� ��������°�?)
public class BinarySearch_1654 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int k = Integer.parseInt(tmp[0]);
			int n = Integer.parseInt(tmp[1]);
			int[] cable = new int[k];
			for(int i=0; i<k; ++i)
				cable[i] = Integer.parseInt(br.readLine());
			// ���� ����ؾ� �ϴ� ���� �̺�Ž������ ã�´�.
			// ��� ����: �ڸ� ������ ���� ���ϱ� -> ���� ���� ��� 
			// N�� �̻�~ => �ִ���� : ���� ã��
			
			// @ left�� right�� long���� �ٲ���� �Ѵ�. �̺�Ž�� logic�� �� �� �������� +1 �Ǿ ����Ǵ� ��쵵 �ֱ� ����
			// 	��) ��� ���� ���̰� 2^31-1�̰� ���䵵 2^31-1�̸� �� ������ left�� right�� ��ġ�� �ǰ�, left = mid+1;��
			//		����Ǿ� int������ �ʰ��ϰ� �ȴ�.
			long left = 0; 
			long right = (1<<31)-1;
			long ans = 0;
			while(left <= right) {
				long mid = (left+right)/2;
				// mid ���̷� �߶� ���� ���� ���� ���
				int cnt = 0;
				for(int i=0; i<k; ++i)
					cnt += cable[i]/mid;
				
				if(cnt >= n) { // ���� �����ϴ� �� ū ���̰� �ִ��� ã��
					ans = mid;
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
			
			bw.write(Long.toString(ans));
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
