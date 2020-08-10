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
	// 오름차순 - this를 기준으로 빼기 연산
	// (내림차순은 this가 뒤로 간다)
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
				// int로 정렬하지 않고 String으로 정렬하면 시간복잡도가 더 올라간다.
				//	=> String은 비교하는데 길이만큼의 시간이 걸리지만, int는 비트연산을 사용하므로 O(1)이다.
				//	-> String으로 정렬하면 11111이 21보다 앞에 오도록 정렬된다.
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
