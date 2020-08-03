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
			cnt = solve(n, 1, 3, sb); // n�� ����(1~n ����)�� 1���� 3���� �ű�� �Լ�
			
			bw.write(Integer.toString(cnt));
			bw.write('\n');
			bw.write(sb.toString());
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// public static int solve(int n, int from, int to, int cnt, StringBuilder sb) 
	//	=> �̹� �����ϴ� int�� cnt�� ���� �ǹ��̱� ������ �Ű������� cnt�� �ѱ�� �ȵȴ�.
	public static int solve(int n, int from, int to, StringBuilder sb) {
		if(n == 1) {
			sb.append(from).append(' ').append(to).append('\n');
			return 1; // �ű� ������ 1���̸� 1�� �ٷ� �ű�� ����
		}
		int cnt = 0; // @ �̹� ȣ�⿡������ ������ �ٽ� ���� �Ѱ���� �Ѵ�! - ���� ������������ ���� ���̱� ������ ���ϰ����� �ѱ�
		// @@ ū ������������ �޾ƿ;� �ϴ� ���� �Ű������� �޾ƿ´�.
		
		// sb.append(from).append(' ').append(6-from-to).append('\n');
		// -> ���⼭ ����ϸ� �ȵȴ�. �Լ��� ���ǰ� => 'n���� ������ �ű�� ����'�ε�, �����δ� �ѹ��� ���� �Ѱ����� ������ �� �ִ�.
		// => ���� ������ 1���� ���� �������� �Ѵ�.
		cnt += solve(n-1, from, 6-from-to, sb); // 1+2+3 = 6
		
		// ���� �� ���� �̵���Ű�� ���� solve ����Լ��� ���ǿ� �ٸ��Ƿ� ��ͷ� ǥ���� �� ����.
		sb.append(from).append(' ').append(to).append('\n');
		++cnt;
		
		//sb.append(6-from-to).append(' ').append(to).append('\n');
		cnt += solve(n-1, 6-from-to, to, sb);
		
		return cnt;
	}
}
