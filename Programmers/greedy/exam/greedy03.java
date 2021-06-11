package greedy.exam;

public class greedy03 {
	public static void main(String[] args) {
		System.out.println(solution("BBBBAAAAB"));
	}
	
	// 본 문제는 그리디 알고리즘으로 풀면 테스트는 통과하나 최소값을 확실히 보장하지 않습니다.
	
	// 예외) AZAAAZ=5 - 왼쪽 먼저 갔다가 오른쪽으로 가는 방법이 최소!
	
	// 이거 그리디 아니고 완전탐색으로 푸는 방법임..
	
	// Z 다음 알파벳=> A, 맨 마지막 칸에서 커서 오른쪽 이동 => 맨 첫칸
	// 위의 조건 없는 이유 - 최소이동을 고려할 때 쓰지 않는 선택이기 때문
	public static int solution(String name) {
		// 1. 좌우 위치이동은 오른쪽으로 쭉 이동/ 왼쪽으로 쭉 이동 수만 비교해서 
		//	짧은 거 더해주면 된다.
		int size = name.length();
        int right = size-1; // 첫 위치는 이동 안해도 되므로
        int left = size-1;
        // right: 끝에서부터 처음 A가 아닌 알파벳 나오는 위치 구하기
        boolean isAll_A = true; // 'A..A' 예외처리
        for(int i=size-1; i>=0; --i) {
        	if(name.charAt(i) != 'A') {
        		isAll_A = false;
        		break;
        	}
        	--right;
        }
        if(isAll_A == true) return 0;
        // left: 처음+1부터 처음 A가 아닌 알파벳 나오는 위치 구하기
        for(int i=1; i<size ; ++i) {
        	if(name.charAt(i) != 'A') break;
        	--left;
        }
        int answer = (right <= left)? right: left;
        
        // 2. 알파벳 이동
        for(int i=0; i<size; ++i) {
        	int up = name.charAt(i) - 'A';
        	int down = 26 - up;
        	answer += (up <= down)? up: down;
        }
        
        return answer;
    }
}
