package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;

public class Stack_1935 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// ABCDE -> ���� 
		// 1:1 �����̹Ƿ� Symbol table ���� ����(HashMap)
		// �Ȱ��� Symbol table������ map �� ������ ���ĺ� 26�� �迭 �����
		// ���ĺ��� ascii�� index ����
		double[] alphaToNum = new double[26];
		try {
			int n = Integer.parseInt(br.readLine());
			// postfix: ���� ���� �迭
			// String�� char[]�� ����
			// - String ��ü�� ���� ���� ���� �� ������ ������ �� ����.
			char[] postfix = br.readLine().toCharArray();

			for(int i=0; i<n; ++i)
				alphaToNum[i] = Double.parseDouble(br.readLine());
			
			// ���
			double[] stack = new double[100];
			int top = 0;
			int size = postfix.length;
			double result;
			for(int i=0; i<size; ++i) {
				// ���� ������ ���ÿ� �ְ�, �����ڸ� ������ ���ÿ��� �� ���� ������ �����ϰ� �ٽ� ���ÿ� �ִ´�.
				switch (postfix[i]) {
					case '+':
						result = stack[top-2] + stack[top-1];
						stack[top-2] = result;
						--top;
						break;
					case '-':
						result = stack[top-2] - stack[top-1];
						stack[top-2] = result;
						--top;
						break;
					case '*':
						result = stack[top-2] * stack[top-1];
						stack[top-2] = result;
						--top;
						break;
					case '/':
						result = stack[top-2] / stack[top-1];
						stack[top-2] = result;
						--top;
						break;
					default: // ���ĺ��̸�
						int idx = postfix[i] - 'A';
						stack[top++] = alphaToNum[idx];
				}
			}
			// 2��° �ڸ������� ���
			DecimalFormat form = new DecimalFormat("#.##");
			System.out.println(stack[0]);
			bw.write(form.format(stack[0]));
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
