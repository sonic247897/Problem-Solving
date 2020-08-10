package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

// 더 이상 swap 안 하는 순간 -> 정렬이 완료된 step의 다음 step
// O(N^2)의 버블소트를 직접할 수는 없다.
// => 퀵소트(+셔플)나 머지소트 써서 구하는 방법을 써야한다.
class Number implements Comparable<Number>{
	int num, order;
	public Number(int num, int order) {
		this.num = num;
		this.order = order;
	}
	@Override
	public int compareTo(Number o) {
		return this.num - o.num; // num만으로 오름차순 정렬
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
			
			// 하나의 step을 실행할 때마다 뒤에 있는 작은 수가 한 칸씩만 앞으로 올 수 있으므로(인접해 있는 두 쌍만 비교하기 때문)
			// 이동한 step의 최대값이 버블소트의 총 step [제일 뒤에 있는 역위를 앞으로 끌어오기 위한 과정이 버블정렬이므로] 
			int max_step = 0;
			for(int i=0; i<n; ++i) {
				int swap = number[i].order - i;
				if(swap > max_step) max_step = swap;
			}
			// 문제의 소스코드 출력: 정렬이 완료된 step의 다음 step 
			bw.write(Integer.toString(max_step+1));
			bw.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
