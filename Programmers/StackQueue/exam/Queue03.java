package StackQueue.exam;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 필요한 정보: 내가 지정한 원소의 위치(이동할 때마다 추적), 
 * 			현재 프린트보다 우선순위 높은 프린트 있는지 정보 
 */

public class Queue03 {
	public static void main(String[] args) {
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		solution(priorities, location);
	}
	// 큐를 이용한 시뮬레이션(그냥 해보기)
	// 최대 100+99+98+...+2+1 = 5050
	// location 정보도 같이 이동해야 하므로 큐 2개 사용 
	// 매번 이동하므로 LinkedList로 구현된 큐 사용 (ArrayList말고)
	public static int solution(int[] priorities, int location) {
		Queue<Integer> priorities_Queue = new LinkedList<Integer>();
		Queue<Boolean> location_Queue = new LinkedList<Boolean>();
		// 현재 원소보다 큰 우선순위 프린트 몇 개 남았는지 정보 필요
		int[] leftPriority = new int[10]; // 1~9 사용
		int currentMaxNum = 0;
		
		int size = priorities.length;
		for(int i=0; i<size; ++i) {
			// 자바는 자동으로 wrapper타입으로 변경해준다
			priorities_Queue.add(priorities[i]);
			if(i == location) 
				location_Queue.add(true);
			else
				location_Queue.add(false);
			
			++leftPriority[priorities[i]];
		}
		for(int i=9; i>=0; --i) {
			if(leftPriority[i] != 0) {
				currentMaxNum = i;
				break;
			}
		}
		// 시뮬레이션 시작
		int order = 0;
		while(true) {
			// 순서: poll -> add
			int print = priorities_Queue.poll();
			boolean isFound = location_Queue.poll();
			// 현재 최고 우선순위 프린트이면
			if(print == currentMaxNum) {
				++order; // 하나 출력함
				if(isFound == true)  // 내가 찾던 프린트이면 순서 리턴
					return order;
				// 최고 우선순위 남은 값 없으면 그 다음 우선순위 찾기
				if(--leftPriority[print] == 0) {
					for(int i=currentMaxNum-1; i>=0; --i) {
						if(leftPriority[i] != 0) {
							currentMaxNum = i;
							break;
						}
					}
				}
			// 최고 우선순위가 아니라면 다시 큐 뒤에 추가
			}else {
				priorities_Queue.add(print);
				location_Queue.add(isFound);
			}
		}
    }

}
