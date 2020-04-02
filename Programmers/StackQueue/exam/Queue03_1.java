package StackQueue.exam;

public class Queue03_1 {
	public static void main(String[] args) {
	
	}
	
	public static int solution(int[] priorities, int location) {
		int size = priorities.length;
		int limit = priorities[location];
		//int[] count = new int[10]; //1~9 index만 사용
		// 그냥 limit보다 큰 우선순위는 다 더해주고 
		// limit이랑 같은 것들만 index로 출력순서 비교하는게 필요하므로 배열에 넣어주기
		int answer =0; 
		int minOver = 10;
		int[] limits = new int[size]; int idx =0; 
		for(int i=0; i<size; ++i) { 
			if(priorities[i] > limit) {
				++answer;
				// limit보다 큰 수 중 가장 작은 수
				minOver = priorities[i] < minOver ? priorities[i] : minOver;
			}
			else if(priorities[i] == limit) {
				// 다같은 우선순위이므로 십의 자리수 더할 필요 없이 index만 넣어줘서 식별 가능 
				limits[idx++] = i;
			}
		}
		// 뒤에서부터 순회하면서 마지막 우선순위가 minOver인 
		
		// 무조건 마지막 수가 먼저 뽑히는게 아니라 그보다 높은 순위 수의 위치에도 영향을 받는다(재귀적)
		// => limit이 minOver순서의 영향을 받는다면 minOver도 그보다 높은순위 수의 순서의 영향을 받겠지..
		
		//gg 
		
		
		
        return answer;
    }

}
