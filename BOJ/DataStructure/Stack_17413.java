package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �±� ���۹��ڰ� ������ �±� ���Ṯ�ڰ� ���ö����� ���ÿ� ���� ���� �״�� ���
// �� ���� ���� ����� �ϹǷ� StringBuilder ���
// ��Ÿ�� ���� -> StringBuilder �������� �Ѿ���? : length�� int���̹Ƿ� ������
// �ƴϸ� bw.write ����? : �ڵ����� �߰��� flush ����
public class Stack_17413 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		char[] stack = new char[100001];
		int top = 0;
		char c = 0;
		boolean isInTag = false;
		try {
			// 0(ascii) = null	--> ����! ���� �ڿ��� ������ ���� ���� 
			// 3(ascii) = EndOfText --> ���� ���
			// IDE������ '\r'�� �ؾ� ��� ������ boj������ '\n'�ؾ� ��� ����
			while((c=(char) br.read()) != '\n') { 
				// <, >�� ���ÿ� ���� ���� �ٷ� ���
				if(c == '<') {
					// ���� ���� �� �ܿ� ����ؾ� �� �� 
					// 1. �±� �ٽ� ������ ��
					while(top > 0) {
						sb.append(stack[--top]);
					}
					
					isInTag = true;
					sb.append(c);
				}else if(c == '>') {
					isInTag = false;
					sb.append(c);
				}else { // Ư�����ڰ� �ƴ� ��
					// 1. �±� �� ���ڿ� - �״�� ���
					if(isInTag == true) {
						sb.append(c);
					} // 2. �±� �ٱ� ���ڿ� - ���� �������� �ܾ� �Ųٷ� ���
					else {
						if(c == ' ') {
							while(top > 0) {
								sb.append(stack[--top]);
							}
							sb.append(' ');
						}else {
							stack[top++] = c;
						}
					}
				}
			}
			// ���� ���� �� �ܿ� ����ؾ� �� �� 
			// 2. �� ������ ��
			while(top > 0) {
				sb.append(stack[--top]);
			}
			
			bw.write(sb.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
