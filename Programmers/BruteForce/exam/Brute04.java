package BruteForce.exam;

public class Brute04 {
	public static void main(String[] args) {
		int brown = 8;
		int red = 1;
		int[] result = solution(brown, red);
		System.out.println(result[0]+":"+result[1]);
	}
	// 세로에 대해(세로가 더 짧으므로 for문을 1부터 돌릴 때 빨리 찾으므로)
	// 2차 방정식이 만들어질 때 근의 공식을 쓰는게 가장 빠르다.
	// 	=> 공식이 생각이 안 날 때는 for문으로 1부터 넣어서 푸는 것이 완전탐색 문제가 됨
	public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        // brown = (가로+세로)*2 + 4 [red의 가로, 세로]
        // red = 가로*세로
        // 짝수 아니므로 그냥 근의 공식 사용
        int b = (brown-4)/2; // brown은 최소 8이상 짝수이므로 b는 무조건 정수
        // 두 길이 중 더 짧은 것이 세로
        // (2*세로) = 정수b - 제곱근, 따라서 제곱근 안의 수는 정수
        int height = (int) ( (b - Math.sqrt(b*b - 4*red)) /2);
        int width = red/height;
        answer[0] = width+2; //[red의 가로, 세로] +2
        answer[1] = height+2;
        return answer;
    }

}
