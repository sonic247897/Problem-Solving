package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �±� ���۹��ڰ� ������ �±� ���Ṯ�ڰ� ���ö����� ���ÿ� ���� ���� �״�� ���
// �� ���� ���� ����� �ϹǷ� StringBuilder ���
public class Stack_17413 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		char[] stack = new char[100000];
		int top = 0;
		char c = 0;
		boolean isInTag = false;
		try {
			// 0(ascii) = null	--> ����! ���� �ڿ��� ������ ���� ���� 
			// 3(ascii) = EndOfText --> ���� ���
			while((c=(char) br.read()) != '\n') { 
				System.out.println(c);
				/*// <, >�� ���ÿ� ���� ���� �ٷ� ���
				if(c == '<') {
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
						if(c != ' ') {
							while(top-- > 0) {
								sb.append(stack[top]);
							}
							sb.append(' ');
						}else {
							stack[top++] = c;
						}
					}
				}*/
			}
			bw.write(sb.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
