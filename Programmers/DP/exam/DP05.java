package DP.exam;

// => 5배 빠른 dp 풀이 있음
public class DP05 {
	public static void main(String[] args) {
		int[] money = {1, 2, 3, 1};
		System.out.println(solution(money));
	}
	
	// O(n)
	// 집은 원형으로 배치 -> 인접한 두 집을 털면 경보가 울린다.
	// 도둑이 훔칠 수 있는 돈의 최댓값을 return
	public static int solution(int[] money) {
		int size = money.length;
		// d[i][0] = 0~i까지 최대 훔친 돈, i번째 안 훔쳤음
		// d[i][1] = 0~i까지 최대 훔친 돈, i번째 훔쳤음
		int[][] d = new int[size][2];
		
		// @원형 처리 - 맨 끝 집; 맨 처음 집이 털렸는지 아닌지 정보를 기록해야 함
		// 방법 1. 시간 - 첫 집 터는 경우와 아닌 경우를 각자 simulation
		// 1) 첫 집 터는 경우 => 마지막 집은 못 털음
		//	두 번째 집은 못 터는 걸로 정해짐 => 세 번째 집부터 시작
		d[2][0] = money[0];
		d[2][1] = money[0] + money[2];
		for(int i=3; i<size-1; ++i) {
			d[i][0] = Math.max(d[i-1][0], d[i-1][1]); // 이번에 안 훔침
			d[i][1] = d[i-1][0] + money[i]; // 이번에 훔침
		}
		// d[size-1][0] = Math.max(d[size-2][0], d[size-2][1]);
		// => d[size-1][0]이 2번 조건으로 시뮬레이션 할 때 덮어씌워짐
		int case1 = Math.max(d[size-2][0], d[size-2][1]);
		
		// 2) 첫 집 털지 않는 경우 => 마지막 집을 털 수도 있다. (무조건 터는건 아님)
		d[1][0] = 0;
		d[1][1] = money[1];
		for(int i=2; i<size; ++i) {
			d[i][0] = Math.max(d[i-1][0], d[i-1][1]); // 이번에 안 훔침
			d[i][1] = d[i-1][0] + money[i]; // 이번에 훔침
		}
		int case2 = Math.max(d[size-1][0], d[size-1][1]);
		
		return Math.max(case1, case2);
    }
}
