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
					// ������ �����Ƿ� �׳� char�� ������ ���� ����.(���� ascii�� ����)
					int num = Integer.parseInt((operation.split(" "))[1]);
					queue[end++] = num;
				}else if(operation.equals("pop")) {
					if(begin == end) sb.append("-1\n");
					// sb.append(queue[begin++]+"\n"); 
					// => ���ڿ� +������ String��ü 2�� ���� �����ϹǷ� �ð� ���� �ɸ�
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
			sb.deleteCharAt(sb.length()-1); // ������ ������ ����
			bw.write(sb.toString());
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
