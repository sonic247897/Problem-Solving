package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 1 1 1 ... 1 1 5 �̷� ���̽��� �ֱ� ������ ��� ������ �� �˻��غ��� �Ѵ�
// boolean[] check �迭���� �̺�Ž�� ����?
// 	=> x. false�� �� ���� �ƴ϶� ���� �� ����. �׳� �����˻����� ã��
public class Recursion_14225 {
	// ������ ���� ���� int�� linked list�� �����ϸ� ���ĵ� �ؾߵǰ� �ߺ��� ���� ó���ؾ� �ϹǷ� �����ϴ�.
	// ������ 1���� ������ ��� �ڿ��� Ȯ���غ��� �ϴµ�
	// �迭�� '�ڿ��� = index'�̹Ƿ� �ߺ��� �ذ�ǰ� Ȯ���� �� ����.
	static boolean[] check = new boolean[2000001]; // �ִ� �� = 20*100,000
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			int[] num = new int[n];
			for(int i=0; i<n; ++i)
				num[i] = Integer.parseInt(tmp[i]);
			
			go(0, 0, n, num);
			
			for(int i=1; ; ++i) {
				if(!check[i]) {
					bw.write(Integer.toString(i));
					break;
				}
			}
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void go(int idx, int sum, int n, int[] num) {
		if(idx == n) {
			check[sum] = true;
			return;
		}
		// ���� idx�� ����Ű�� ���� �����ϴ� ���
		go(idx+1, sum+num[idx], n, num);
		// �������� �ʴ� ���
		go(idx+1, sum, n, num);
	}
}
