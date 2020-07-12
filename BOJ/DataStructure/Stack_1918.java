package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 차량기지 알고리즘
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
				// 1. 피연산자는 그대로 출력, 연산자는 스택에 저장
				switch(c) {
					case '(': // 열린 괄호는 스택에 그대로 넣는다.
						stack[top++] = c;
						break;
					case ')': // 열린 괄호 만날 때까지 pop
						while(top > 0) {
							if(stack[top-1] == '(') {
								--top; break; // 열린괄호는 pop해서 버림
							}
							bw.write(stack[--top]);
						}
						break;
					case '*':
					case '/':
						// top에 우선순위가 더 낮은 연산자가 나타날 때까지 pop
						// 그 후에 스택에 push
						while(top > 0) {
							if(stack[top-1] == '(') break; // 닫는 괄호를 만날 때까지 pop하지 않는다.
							if(stack[top-1] == '+' || stack[top-1] == '-') {
								break; // 낮은 연산자는 pop하지 않음
							}
							bw.write(stack[--top]);
						}
						stack[top++] = c;
						break;
					case '+':
					case '-':
						// 우선순위가 더 낮은 연산자가 없으므로 pop을 계속한다.
						// 그 후에 스택에 push
						while(top > 0) {
							if(stack[top-1] == '(') break; // 닫는 괄호를 만날 때까지 pop하지 않는다.
							bw.write(stack[--top]);
						}
						stack[top++] = c;
						break;
					default:
						bw.write(c);
				}
			}	
			// 끝나면 스택에 남아있는 연산자 pop
			while(top-- > 0) 
				bw.write(stack[top]);
			
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
