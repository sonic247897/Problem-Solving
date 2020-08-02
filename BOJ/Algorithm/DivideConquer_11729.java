package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class DivideConquer_11729 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			// StringBuilder�� char[] �迭�̹Ƿ� call by reference
			int cnt = 0;
			StringBuilder sb = new StringBuilder(); 
			cnt = solve(n, 1, 3, cnt, sb); // n�� ����(1~n ����)�� 1���� 3���� �ű�� �Լ�
			
			bw.write(Integer.toString(cnt));
			bw.write('\n');
			bw.write(sb.toString());
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static int solve(int n, int from, int to, int cnt, StringBuilder sb) {
		if(n == 0) {
			return cnt; // �ű� ������ 0���̸� ����
		}
		sb.append(from).append(' ').append(6-from-to).append('\n');
		solve(n-1, from, 6-from-to, cnt, sb); // 1+2+3 = 6
		++cnt;
		
		// ���� �� ���� �̵���Ű�� ���� solve ����Լ��� ���ǿ� �ٸ��Ƿ� ��ͷ� ǥ���� �� ����.
		sb.append(from).append(' ').append(to).append('\n');
		++cnt;
		
		sb.append(6-from-to).append(' ').append(to).append('\n');
		solve(n-1, 6-from-to, to, cnt, sb);
		++cnt;
		
		return cnt;
	}
}
