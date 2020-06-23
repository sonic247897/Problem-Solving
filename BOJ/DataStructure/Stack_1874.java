package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// ����ʰ� 
// => BufferedWriter�� ���۰� ������� ���� ������������ flush�� �ϱ� ������ 
// 	 N�� Ŀ���� �ڵ����� bw�� ����ϱ� ������ NO�� ����ؾ� �ϴ� case���� ������ ���� ��
// �ذ���
// => StringBuilder�� �̿��ؼ� �� ���ڿ��� ���� �� �ѹ��� ���
public class Stack_1874 {
	public static void main(String[] args) {
		int[] stack = new int[100000];
		int top = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw_no = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			// �������� ����(������ �Է�)
			int asc_number = 1;
			while(n-- > 0) { // �� ���� �� ������ pop() �� �� ���� �� �ؾ���
				int num = Integer.parseInt(br.readLine());
				// ���� num�� asc_number���� �� ũ�� num������ ���� ���ÿ� �ֱ�
				while(asc_number <= num) {
					stack[top++] = asc_number; 
					//bw.write("+\n");
					sb.append("+\n");
					++asc_number;
				}
				// pop
				if(stack[--top] == num) {
					if(n > 0) 
						//bw.write("-\n");
						sb.append("-\n");
				}else {
					bw_no.write("NO"); 
					bw_no.flush();
					return;
				}
			}
			// ������ pop
			//bw.write("-");
			sb.append("-");
			// ���� ��ġ�ϸ� operation�迭 ���(���������� \n ����� ��)
			bw.write(sb.toString());
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
