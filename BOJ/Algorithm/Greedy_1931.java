package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

class Meeting implements Comparable<Meeting>{
	int begin, end;

	public Meeting(int begin, int end) {
		this.begin = begin;
		this.end = end;
	}
	
	@Override
	public int compareTo(Meeting that) {
		// 문제 조건: 시작시간 = 끝나는시간 의 경우 존재하므로
		// 오름차순 정렬 - this 기준 뺄셈 
		if(this.end == that.end)
			return this.begin - that.begin;
		return this.end - that.end;
	}
}

public class Greedy_1931 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		try {
			int n = Integer.parseInt(br.readLine());
			Meeting[] meetings = new Meeting[n];
					
			for(int i=0; i<n; ++i) {
				String[] tmp = br.readLine().split(" ");
				int begin = Integer.parseInt(tmp[0]);
				int end = Integer.parseInt(tmp[1]);
				meetings[i] = new Meeting(begin, end);
			}
			
			// 오름차순 정렬해야 함
			Arrays.sort(meetings);
			
			int cnt = 0; // 회의 수
			int prev_end = 0; // 이전 종료 시간
			for(int i=0; i<n; ++i) {
				if(meetings[i].begin < prev_end) continue;
				prev_end = meetings[i].end;
				++cnt;
			}
			
			bw.write(Integer.toString(cnt));
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
