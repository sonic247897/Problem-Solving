package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class _Point implements Comparable<_Point>{
	int x, y;
	_Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	// �������� - this�� �������� ���� ����
	// (���������� this�� �ڷ� ����)
	@Override
	public int compareTo(_Point o) {
		int result = this.y - o.y;
		if(result == 0)
			return this.x - o.x;
		return result;
	}
}

public class Sorting_11651 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp;
			_Point[] point = new _Point[n];
			for(int i=0; i<n; ++i) {
				tmp = br.readLine().split(" ");
				// int�� �������� �ʰ� String���� �����ϸ� �ð����⵵�� �� �ö󰣴�.
				//	=> String�� ���ϴµ� ���̸�ŭ�� �ð��� �ɸ�����, int�� ��Ʈ������ ����ϹǷ� O(1)�̴�.
				//	-> String���� �����ϸ� 11111�� 21���� �տ� ������ ���ĵȴ�.
				point[i] = new _Point(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));
			}
			
			Arrays.sort(point);
			
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<n; ++i) {
				sb.append(point[i].x).append(' ').append(point[i].y).append('\n');
			}
			bw.write(sb.toString());
			bw.flush();
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
