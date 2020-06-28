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
		
		// ABCDE -> 숫자 
		// 1:1 대응이므로 Symbol table 쓰면 편함(HashMap)
		// 똑같은 Symbol table이지만 map 안 쓰려면 알파벳 26개 배열 만들고
		// 알파벳의 ascii로 index 접근
		double[] alphaToNum = new double[26];
		try {
			int n = Integer.parseInt(br.readLine());
			// postfix: 수식 저장 배열
			// String과 char[]의 차이
			// - String 객체는 읽을 수만 있을 뿐 내용을 변경할 수 없다.
			char[] postfix = br.readLine().toCharArray();

			for(int i=0; i<n; ++i)
				alphaToNum[i] = Double.parseDouble(br.readLine());
			
			// 계산
			double[] stack = new double[100];
			int top = 0;
			int size = postfix.length;
			double result;
			for(int i=0; i<size; ++i) {
				// 수를 만나면 스택에 넣고, 연산자를 만나면 스택에서 두 수를 꺼내서 연산하고 다시 스택에 넣는다.
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
					default: // 알파벳이면
						int idx = postfix[i] - 'A';
						stack[top++] = alphaToNum[idx];
				}
			}
			// 2번째 자리수까지 출력
			DecimalFormat form = new DecimalFormat("#.##");
			System.out.println(stack[0]);
			bw.write(form.format(stack[0]));
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
