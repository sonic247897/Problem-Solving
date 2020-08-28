package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BFS_13913 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int n = Integer.parseInt(tmp[0]);
			int k = Integer.parseInt(tmp[1]);
			
			int[] dist = new int[100001];
			int[] from = new int[100001]; // ������ ���� -> ��� �迭
			
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(n);
			dist[n] = 1;
			from[n] = -1; // ������� ���� ���� �����Ƿ� -1(���� ���)�� �����Ѵ�.
			while(!q.isEmpty()) {
				int cur = q.poll();
				// �ȱ�
				int next = cur-1;
				if(next >=0 && dist[next] == 0) {
					q.add(next);
					dist[next] = dist[cur]+1;
					from[next] = cur;
					if(next == k) break;
				}
				next = cur+1;
				if(next <= 100000 && dist[next] == 0) {
					q.add(next);
					dist[next] = dist[cur]+1;
					from[next] = cur;
					if(next == k) break;
				}
				// �����̵�
				next = cur*2;
				if(next <= 100000 && dist[next] == 0) {
					q.add(next);
					dist[next] = dist[cur]+1;
					from[next] = cur;
					if(next == k) break;
				}
			}
			StringBuilder sb = new StringBuilder();
			sb.append(dist[k]-1).append('\n');
			Stack<Integer> stack = new Stack<>();
			stack.add(k);
			int prev = from[k];
			while(prev != -1) {
				stack.add(prev);
				prev = from[prev]; 
			}
			while(!stack.isEmpty()) {
				sb.append(stack.pop()).append(' ');
			}
			bw.write(sb.toString());
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
