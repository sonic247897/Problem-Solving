package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// LIS
public class DP_14002 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[] input = new int[1000];
		int[] dp = new int[1000]; // �ִ� ���� ����
		int[] prev = new int[1000];// ������(���߿� �����̳� ��ͷ� ���)
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int size = tmp.length;
			for(int i=0; i< size; ++i) {
				input[i] = Integer.parseInt(tmp[i]);
				dp[i] = 1; // �ڱ� �ڽ� �����ϹǷ� �ּұ���=1
				prev[i] = -1; // �ʱ�ȭ
				// �ڿ������� ����ϴ� ���� Ȯ�������� �ִ������ ���ɼ��� �����Ƿ� if���ǹ� �� �����ϰ� �� ��
				for(int j= i-1; j >= 0; --j) { 
					if(input[j] < input[i]) { // ���� �����ؾ� ��
						int length = dp[j]+1;
						if(length > dp[i]) {
							dp[i] = length;
							prev[i] = j;
						}
					}
				}
			}
			// �ִ� ���� ���ϰ�, �� �ε����� �����Ͽ� ���� �κм����� ���Ѵ�.
			int max_len = 0; 
			int index = -1;
			for(int i=0; i<size; ++i) {
				if(dp[i] > max_len) {
					max_len = dp[i];
					index = i;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(max_len).append('\n');
			
			int[] stack = new int[1000];
			int top = 0;
			while(index != -1) {
				stack[top++] = input[index]; 
				index = prev[index];
			}
			while(top-- > 0) {
				sb.append(stack[top]).append(' ');
			}
			
			bw.write(sb.toString());
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
