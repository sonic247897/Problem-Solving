package StackQueue.exam;

import java.util.LinkedList;
import java.util.Queue;

public class Queue01 {

	public static void main(String[] args) {
		//int[] truck_weights = {7, 4, 5, 6};
		int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
		solution(100, 100, truck_weights);
	}
	
	// 1초마다 시뮬레이션(변화가 일어나는 단위)

	// 1. 다리 길이만큼의 큐 사용(0으로 초기화): 1초마다 한 칸씩 이동 해야 하므로 LinkedList 사용!
	//	매 시간마다 total값에 들어오는 값 더하고 나가는 값 빼서 갱신.
	//		=> 최대 10^4*10^4 = 10^8
	// 2. 개념적 큐(LinkedList 없이 구현 -> 각 트럭마다 시간초도 계산해줘야 하므로 map필요)
	//	 => 복잡하고 직관적이지 않다.
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		Queue<Integer> queue = new LinkedList<Integer>();
		// 초기화 - bridge_length만큼 0 넣어줌
		int qsize = bridge_length;
		while(qsize-- > 0) {
			queue.add(0);
		}
		int truckNum = truck_weights.length;
		// 1초부터 시작 => 예외 case에(ex.트럭이 1대) 걸릴 확률이 높은 방법!
		/*int bridgeWeight = truck_weights[0];
		queue.add(truck_weights[0]); 
		queue.poll();
		int truck_idx = 1;
		int second = 1;*/
		
		// 0초부터 시작(예시와 같음)
		int bridgeWeight = 0;
		int truck_idx = 0;
		int second = 0;
		// @@ 순서 주의! 예시에 의하면 트럭이 빠져나가고 들어옴(반대 순서 틀림)
		// 동시에 2개 이상의 처리를 하는 문제(나가고 들어오는)는 예시나 조건을 주의해서 봐야한다.
		while(true) {
			bridgeWeight -= queue.poll();
			++second;
			if(truck_weights[truck_idx] <= weight-bridgeWeight) {
				bridgeWeight += truck_weights[truck_idx];
				queue.add(truck_weights[truck_idx]); // 큐(다리)에 트럭 넣기
				++truck_idx;
				if(truck_idx == truckNum) { 
					// 트럭 다 지나갔으면 끝날 때까지 초만 증가
					second += bridge_length;
					break;
				}
			}else {
				queue.add(0);
			}
		}
		return second;
    }

}
