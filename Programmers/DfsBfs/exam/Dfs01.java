package DfsBfs.exam;

public class Dfs01 {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
	// 각 수의 앞에 +,- 중 하나 붙이는것 선택 (2^20 = 10^6)
	// 순서 정해져있으므로 check배열 필요없음 => 그래프 모델링 필요 없는 단순한 문제
	// 완전탐색 -> for문 쓰면 2^20개의 경우의 수마다 각자 결과값을 저장하는 변수가 필요하므로 재귀 사용
	public static int solution(int[] numbers, int target) {
        // 경우의 수 구하기
		int answer = 0;
		answer = go(numbers, 0, 0, target);
		
        return answer;
    }
	// 전역변수 아니므로 numbers배열과 target 매번 넘겨줘야 한다
	public static int go(int[] numbers, int idx, int result, int target) {
		// 사이즈까지 재귀했을때 target넘버와 같으면 +1
		if(idx == numbers.length) {
			if(result == target)
				return 1;
			else return 0; //이거 안하면 정답 아닐때 다음 go 호출해서 에러
		}
		return go(numbers, idx+1, result+numbers[idx], target) + go(numbers, idx+1, result-numbers[idx], target);
	}

}
