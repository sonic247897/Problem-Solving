package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// �� �̻� swap �� �ϴ� ���� -> ������ �Ϸ�� step�� ���� step
// O(N^2)�� �����Ʈ�� ������ ���� ����.
// => ����Ʈ(+����)�� ������Ʈ �Ἥ ���ϴ� ����� ����Ѵ�.
class Number implements Comparable<Number>{
	int num, order;
	public Number(int num, int order) {
		this.num = num;
		this.order = order;
	}
	@Override
	public int compareTo(Number o) {
		return this.num - o.num; // num������ �������� ����
	}
}

public class Sorting_1377 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			Number[] number = new Number[n];
			for(int i=0; i<n; ++i) 
				number[i] = new Number(Integer.parseInt(br.readLine()), i);
				
			Arrays.sort(number);
			
			// �ϳ��� step�� ������ ������ �ڿ� �ִ� ���� ���� �� ĭ���� ������ �� �� �����Ƿ�(������ �ִ� �� �ָ� ���ϱ� ����)
			// �̵��� step�� �ִ밪�� �����Ʈ�� �� step [���� �ڿ� �ִ� ������ ������ ������� ���� ������ ���������̹Ƿ�] 
			int max_step = 0;
			for(int i=0; i<n; ++i) {
				int swap = number[i].order - i;
				if(swap > max_step) max_step = swap;
			}
			// ������ �ҽ��ڵ� ���: ������ �Ϸ�� step�� ���� step 
			bw.write(Integer.toString(max_step+1));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
