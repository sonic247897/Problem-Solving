package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 출력초과 
// => BufferedWriter는 버퍼가 어느정도 차면 비정기적으로 flush를 하기 때문에 
// 	 N이 커지면 자동으로 bw가 출력하기 때문에 NO만 출력해야 하는 case에서 오류가 나는 것
// 해결방법
// => StringBuilder를 이용해서 한 문자열로 만든 뒤 한번에 출력
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
			// 오름차순 수열(스택의 입력)
			int asc_number = 1;
			while(n-- > 0) { // 한 바퀴 돌 때마다 pop() 한 번 씩은 꼭 해야함
				int num = Integer.parseInt(br.readLine());
				// 만약 num이 asc_number보다 더 크면 num까지의 수를 스택에 넣기
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
			// 마지막 pop
			//bw.write("-");
			sb.append("-");
			// 전부 일치하면 operation배열 출력(마지막에는 \n 없어야 함)
			bw.write(sb.toString());
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
