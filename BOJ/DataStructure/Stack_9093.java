package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stack_9093 {
	public static void main(String[] args) {
		/*int test = '\n';
		System.out.println((char)test+":"+test);*/ // => ���: 10
		char[] stack = new char[20];
		int top=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			// int n = Integer.parseInt(br.read()); �� ���Ұ�
			// br.read()�� �̹� int(ascii char��)�� ��ȯ�ϱ� ������. �׷��ٰ� �׳� br.read() ����ϸ� ������ ascii���� ������ش�.
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; ++i) {
				int c;
				while(true) {
					c = br.read();
					// ���� ������ ���
					if(c == ' ' || c == '\n') {
						while(top != 0) {
							bw.write(stack[--top]);
						}
						// ���� ��� �Ŀ� ����� ������ ���ۿ� ����
						if(c == ' ') bw.write(' ');
						if(c == '\n') {
							bw.write('\n'); 
							break;
						}
					} else if(c == '\r') {
						// @ �����쿡�� ������ ĳ��������(CRLF, \r\n)�̴�!
					}else {
						// ���ÿ� ����, ������ ���� ������ ������� ������(����)
						stack[top++] = (char)c;
					}
					// System.out.println((char)c + ":" + c); // => ���: ���� ���� 13
					
				}
			}
			bw.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
