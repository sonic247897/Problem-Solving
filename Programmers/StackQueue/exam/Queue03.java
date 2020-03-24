package StackQueue.exam;

public class Queue03 {
	public static void main(String[] args) {
	
	}
	// 두 방법 다 맨 처음에 구하려고 하는 원소의 우선순위 구해서 그 밑은 저장,탐색 안해도 된다
	// 방법1. 0 10 20 30.. 더해줘서 십의자리가 원래 위치고 일의자리로 우선순위 구별
	// 1~9 카운트배열? 찾고자 하는 우선순위(일의자리수)보다 큰거는 그냥 다 더해주고
	// 마지막에 내보낸 수에 따라 계산 - 더하기, %연산 필요
	// 방법2. 해시맵에 (순서, 우선순위)쌍 저장하고 우선순위=9,8,7.. 뽑아서 더하고 
	// 마지막에 내보낸 수에 따라 계산 - 정렬된 상태로 뽑거나 순회 가능? 
	// (순서를 바로 계산할수 있는가) 정렬해야함: 최대 O(nlgn) => 방법1 사용!
	public static int solution(int[] priorities, int location) {
		int size = priorities.length;
		int limit = priorities[location];
		int[] count = new int[10]; //1~9 index만 사용
		
		System.out.println("limit: "+limit);
		for(int i=0; i<size; ++i) { // if문으로 limit체크 해주는게 더 비용높음
			priorities[i] += (i*10);
			count[priorities[i]]++;
		}
		// limit+1 이상의 우선순위 가진 것들 더하기(limit+1은 따로 뺀다?=>X)
		int answer = 0;
		for(int i=limit+1; i<=9; ++i) {
			answer += count[i];
		}
		// limit+1은 따로 빼도 count정보로는 알 수 있는 정보가 없다
		// 따라서 limit+1까지는 그냥 count를 다 더하고 규칙을 이용해야 함
		// location이용? %이용?
		// 처음에 for문 돌 때 flag로 limit보다 큰 원소 체크
		
		
		
        return answer;
    }

}
