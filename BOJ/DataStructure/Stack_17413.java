package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 태그 시작문자가 나오면 태그 종료문자가 나올때까지 스택에 넣지 말고 그대로 출력
// 맨 끝에 공백 없어야 하므로 StringBuilder 사용
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
			// 0(ascii) = null	--> 실패! 끝난 뒤에도 공백을 많이 읽음 
			// 3(ascii) = EndOfText --> 같은 결과
			while((c=(char) br.read()) != '\n') { 
				System.out.println(c);
				/*// <, >는 스택에 넣지 말고 바로 출력
				if(c == '<') {
					isInTag = true;
					sb.append(c);
				}else if(c == '>') {
					isInTag = false;
					sb.append(c);
				}else { // 특수문자가 아닐 때
					// 1. 태그 안 문자열 - 그대로 출력
					if(isInTag == true) {
						sb.append(c);
					} // 2. 태그 바깥 문자열 - 띄어쓰기 기준으로 단어 거꾸로 출력
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
