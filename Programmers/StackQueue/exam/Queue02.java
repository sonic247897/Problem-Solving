package StackQueue.exam;

public class Queue02 {
	public static void main(String[] args) {
		int[] progresses = {90,99,98,97};
		int[] speeds = {1,1,1,1};
		int[] result = solution(progresses, speeds);
		for(int i=0; i<result.length; ++i) {
			System.out.print(result[i]+" ");
		}
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int size = progresses.length;
		int[] finDay = new int[size];
		// 올림 - 실수형의 연산은 오차나 오류가 발생할 수 있으므로 int연산으로 만들어줌
		int day=0; int cnt =1;
		int tmparr[] = new int[size]; //임시 저장소
		float tmp = (100 - progresses[0])/speeds[0];
		finDay[0] = (int) ((int)(tmp*10)%10 == 0 ? tmp: tmp+1);
		int max = finDay[0]; 
		for(int i=1; i<size; ++i) {
			tmp = (100 - progresses[i])/speeds[i];
			finDay[i] = (int) ((int)(tmp*10)%10 == 0 ? tmp: tmp+1);
			// 바로 인접한 것끼리만 비교하면 안됨
			// 바로 앞에서까지 max인것보다 커야 함
			if(max < finDay[i]) {
				max = finDay[i];
				tmparr[day] = cnt;
				cnt = 0;
				day++;
			}
			++cnt;
		}
		// 마지막
		tmparr[day] = cnt;
		int[] answer = new int[day+1];
		for(int i=0; i<answer.length; ++i) {
			answer[i] = tmparr[i];
		}
		return answer;
    }

}
