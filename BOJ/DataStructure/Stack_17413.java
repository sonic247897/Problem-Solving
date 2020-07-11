package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 태그 시작문자가 나오면 태그 종료문자가 나올때까지 스택에 넣지 말고 그대로 출력
// 맨 끝에 공백 없어야 하므로 StringBuilder 사용
// 런타임 에러 -> StringBuilder 길이제한 넘었나? : length가 int형이므로 괜찮음
// 아니면 bw.write 제한? : 자동으로 중간에 flush 해줌
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
			// 0(ascii) = null	--> 실패! 끝난 뒤에도 공백을 많이 읽음 
			// 3(ascii) = EndOfText --> 같은 결과
			// IDE에서는 '\r'로 해야 결과 나오고 boj에서는 '\n'해야 결과 나옴
			while((c=(char) br.read()) != '\n') { 
				// <, >는 스택에 넣지 말고 바로 출력
				if(c == '<') {
					// 띄어쓰기 만날 때 외에 출력해야 할 때 
					// 1. 태그 다시 시작할 때
					while(top > 0) {
						sb.append(stack[--top]);
					}
					
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
			// 띄어쓰기 만날 때 외에 출력해야 할 때 
			// 2. 다 끝났을 때
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
