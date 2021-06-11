package Sort.exam;

import java.util.Arrays;

public class Array01 {

	public static void main(String[] args) {

	}
	
	public int[] solution(int[] array, int[][] commands) {
		int size = commands.length;
		int[] answer = new int[size];
		// commands마다 반복
		for(int idx=0; idx<size; ++idx) {
			int i=commands[idx][0];
			int j=commands[idx][1];
			int k=commands[idx][2];
			int[] a = new int[j-i+1];
			int cnt=0;
			for(int idx2=i-1; idx2<=j-1; ++idx2) {
				a[cnt++] = array[idx2];
			}
			// 시간 초과하면 셔플
			// shuffle(a);
			Arrays.sort(a);
			answer[idx]=a[k-1];
		}
		return answer;
	}

}
