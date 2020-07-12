package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �������� �˰���
public class Stack_1918 {
	public static void main(String[] args) {
		// Ascii char
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		char[] stack = new char[100]; 
		int top = 0;

		try {
			char c = 0;
			while((c=(char)br.read()) != '\n') {
				// 1. �ǿ����ڴ� �״�� ���, �����ڴ� ���ÿ� ����
				switch(c) {
					case '(': // ���� ��ȣ�� ���ÿ� �״�� �ִ´�.
						stack[top++] = c;
						break;
					case ')': // ���� ��ȣ ���� ������ pop
						while(top > 0) {
							if(stack[top-1] == '(') {
								--top; break; // ������ȣ�� pop�ؼ� ����
							}
							bw.write(stack[--top]);
						}
						break;
					case '*':
					case '/':
						// top�� �켱������ �� ���� �����ڰ� ��Ÿ�� ������ pop
						// �� �Ŀ� ���ÿ� push
						while(top > 0) {
							if(stack[top-1] == '(') break; // �ݴ� ��ȣ�� ���� ������ pop���� �ʴ´�.
							if(stack[top-1] == '+' || stack[top-1] == '-') {
								break; // ���� �����ڴ� pop���� ����
							}
							bw.write(stack[--top]);
						}
						stack[top++] = c;
						break;
					case '+':
					case '-':
						// �켱������ �� ���� �����ڰ� �����Ƿ� pop�� ����Ѵ�.
						// �� �Ŀ� ���ÿ� push
						while(top > 0) {
							if(stack[top-1] == '(') break; // �ݴ� ��ȣ�� ���� ������ pop���� �ʴ´�.
							bw.write(stack[--top]);
						}
						stack[top++] = c;
						break;
					default:
						bw.write(c);
				}
			}	
			// ������ ���ÿ� �����ִ� ������ pop
			while(top-- > 0) 
				bw.write(stack[top]);
			
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
