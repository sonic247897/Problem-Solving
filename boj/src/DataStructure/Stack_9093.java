package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Stack_9093 {
	public static void main(String[] args) {
		/*int test = '\n';
		System.out.println((char)test+":"+test);*/ // => 결과: 10
		char[] stack = new char[20];
		int top=0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			// int n = Integer.parseInt(br.read()); 는 사용불가
			// br.read()가 이미 int(ascii char형)를 반환하기 때문에. 그렇다고 그냥 br.read() 출력하면 숫자의 ascii값을 출력해준다.
			int n = Integer.parseInt(br.readLine());
			for(int i=0; i<n; ++i) {
				int c;
				while(true) {
					c = br.read();
					// 띄어쓰기 만나면 출력
					if(c == ' ' || c == '\n') {
						while(top != 0) {
							bw.write(stack[--top]);
						}
						// 스택 출력 후에 띄어쓰기랑 뉴라인 버퍼에 저장
						if(c == ' ') bw.write(' ');
						if(c == '\n') {
							bw.write('\n'); 
							break;
						}
					} else if(c == '\r') {
						// @ 윈도우에서 개행은 캐리지리턴(CRLF, \r\n)이다!
					}else {
						// 스택에 띄어쓰기, 뉴라인 전부 넣으면 띄어쓰기부터 시작함(스택)
						stack[top++] = (char)c;
					}
					// System.out.println((char)c + ":" + c); // => 결과: 문장 끝에 13
					
				}
			}
			bw.flush();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
