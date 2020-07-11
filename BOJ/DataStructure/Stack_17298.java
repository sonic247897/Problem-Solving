package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stack_17298 {
	// Ai���� ū �� �߿��� ���� ���ʿ� �ִ� �� = ������ ��
	//	-> ����
	// ������ index�� ������ ���� ���� => ���� ��� index�� �־��ش�!
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			// index�� �����ϱ� ���� input�迭 �ʿ�
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] input = new int[n];
			for(int i=0; i<n; ++i) {
				input[i] = Integer.parseInt(tmp[i]);
			}
			
			int stack[] = new int[n];
			int top=0;
			int answer[] = new int[n];
			for(int i=0; i<n-1; ++i) {
				stack[top++] = i; // ���� ���� index �־��ֱ�
				int next = input[i+1];
				while(top-1 >= 0 && input[stack[top-1]] < next) {
					--top; // pop
					answer[stack[top]] = next;
				}
			}
			answer[n-1] = -1; // ������ ����
			// ���ÿ� ���� ���ҵ� -1
			while(top-- > 0) {
				answer[stack[top]] = -1;
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n-1; ++i) 
				// bw.write(answer[i]);�� ascii char�� int�̱� ������ ������ ���´�. 
				sb.append(answer[i]).append(' ');
			sb.append(answer[n-1]);
			bw.write(sb.toString()); // bw.append(sb);���� �ణ ����
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
