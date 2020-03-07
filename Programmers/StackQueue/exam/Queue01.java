package StackQueue.exam;

import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {

	public static void main(String[] args) {
		int[] truck_weights = {7, 4, 5, 6};
		solution(2, 10, truck_weights);
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
        // 초마다 루프
		int sec =1;
		int cap = weight - truck_weights[0];
		int truck_num = 1;
		// 큐
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(1); //길이1 지나감
		
		while(true) {
			sec++; //시간경과 - 끝 기준
			for (Integer truck_moved : q) {
				truck_moved++;  // @@이거 왜 1더하기 안됨? 머하는 코드냐?
			}
			// 트럭 퇴장
			System.out.println(q.peek());
			if(q.peek() == bridge_length) {
				cap += q.poll();
				System.out.println("퇴장: "+cap);
			}
			
			// 트럭 남아있고 cap 남아있으면 입장
			if((truck_num < truck_weights.length) && (cap - truck_weights[truck_num] >=0)) {
				q.offer(1);
				cap -= truck_weights[truck_num];
				truck_num++;
				System.out.println("입장: "+cap);
			}
			
			// 0초 이후 다시 cap이 원상태로 돌아오는 경우 종료
			if(cap == weight) {
				break;
			}
		}
		
		int answer = sec;
        return answer;
    }

}
