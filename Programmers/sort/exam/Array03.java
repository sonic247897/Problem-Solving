package Sort.exam;

import java.util.Arrays;

public class Array03 {

	public static void main(String[] args) {
		int[] citations = {3, 0, 6, 1, 5};
		System.out.println(solution(citations));
	}
	
	public static int solution(int[] citations) {
		int answer=0;
        //시간 초과하면 shuffle
		Arrays.sort(citations);
		//뒤에서부터 순회
		int size = citations.length;
		int over = 0; boolean isEnd = true;
		// 한 바퀴 순회하면서 인용회수 바뀌는 구간별로 계산 
		for(int i=size-1; i>=1; --i) {
			int prev = citations[i];
			if(citations[i-1] != prev) {
				over = size-i;
				// min(citations[i], over)
				int h = citations[i] <= over ?  citations[i]: over;
				answer = h > answer ? h: answer;
				// 다음에 계산할 citations[i-1]이
				// 방금 계산된 현재의 h보다 더 크게 갱신할 수 없으면 break
				if(h>= citations[i-1]) {
					isEnd = false;
					break;
				}
			}
		}
		// 마지막 h
		if(isEnd) {
			over = size;
			int h = citations[size-1] <=over ? citations[size-1] : over;
			answer = h > answer ? h: answer;
		}
		
		return answer;
    }

}
