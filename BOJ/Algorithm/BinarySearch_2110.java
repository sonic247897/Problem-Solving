package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// ���� ������ �� ������ ������ �Ÿ� ���
public class BinarySearch_2110 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] tmp = br.readLine().split(" ");
			int N = Integer.parseInt(tmp[0]);
			int C = Integer.parseInt(tmp[1]);
			int[] home = new int[N];
			for(int i=0; i<N; ++i) 
				home[i] = Integer.parseInt(br.readLine());
		
			// ��ǥ�� ������� �־����� �����Ƿ� ���� �ʿ�
			Arrays.sort(home);
			
			// ������ ���� ��ŭ ���� ����ؾ� �Ѵ�.
			// ���� ������ �� ������ ������ �Ÿ� -> �ִ��: ��� ������ ��ġ ������ ��Ȳ �� ����
			int left = 1; // (����)�� �������� ���� ��ǥ�� ������ ���� ����.
			int right = home[N-1]-home[0];
			while(left <= right) {
				int mid = (left+right)/2;
				int router = C; // ���� ������ ����
				// @ ���Ʈ ����? �׸���? => �׸���� Ǯ����.. �� ���������� �𸣰���
				// @ �� ������(���Ʈ ����)�� �ٲ� �� �ִ� �κ�?
				for(int i=0; i<N; ++i) {
					int l = 
					int dist = home[i]-home[]
				}
				if(router < 0) 
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
