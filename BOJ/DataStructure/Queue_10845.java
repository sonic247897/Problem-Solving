package DataStructure;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Queue_10845 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int[] queue = new int[10000];
		int begin =0, end = 0;
		
		try {
			int n = Integer.parseInt(br.readLine());
			while(n-- > 0) {
				String operation = br.readLine();
				if(operation.startsWith("push")) {
					// 음수도 있으므로 그냥 char로 저장할 수는 없다.(음수 ascii는 없음)
					int num = Integer.parseInt((operation.split(" "))[1]);
					queue[end++] = num;
				}else if(operation.equals("pop")) {
					if(begin == end) sb.append("-1\n");
					// sb.append(queue[begin++]+"\n"); 
					// => 문자열 +연산은 String객체 2개 만들어서 연결하므로 시간 많이 걸림
					else sb.append(queue[begin++]).append("\n");
				}else if(operation.equals("size")) {
					sb.append(end-begin).append("\n");
				}else if(operation.equals("empty")) {
					if(begin == end) sb.append("1\n");
					else sb.append("0\n");
				}else if(operation.equals("front")) {
					if(begin == end) sb.append("-1\n");
					else sb.append(queue[begin]).append("\n");
				}else { // back
					if(begin == end) sb.append("-1\n");
					else sb.append(queue[end-1]).append("\n");
				}
			}
			sb.deleteCharAt(sb.length()-1); // 마지막 뉴라인 제거
			bw.write(sb.toString());
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
