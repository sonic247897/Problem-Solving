package greedy.exam;

public class greedy01 {
	public static void main(String[] args) {
		
	}
	// 가능한 체육복 여벌 수 - 0, 1, 2 (2개 가져온 학생이 도둑맞으면 1)
	// 처음 분배 시작할 때부터 2개 갖고 있는 학생만 줄 0개 학생한테 줄 수 있음
	// 0개 학생 좌우로 2개 학생인지 검사 
	public static int solution(int n, int[] lost, int[] reserve) {
        int[] uniform = new int[n]; 
        for(int i=0; i<n; ++i)
        	uniform[i] = 1;
        for(int i=0; i<lost.length; ++i)
        	--uniform[lost[i]-1];
        for(int i=0; i<reserve.length; ++i)
        	++uniform[reserve[i]-1];
        
        for(int i=0; i<n; ++i) {
        	if(uniform[i] == 0) {
        		if(i-1>=0 && uniform[i-1]==2) {
        			++uniform[i];
        			--uniform[i-1];
        		}else if(i+1<n && uniform[i+1]==2) {
        			++uniform[i];
        			--uniform[i+1];
        		}
        	}
        }
        
        // 한바퀴 돌면서 세줘야 함(lost, reserve 겹친거 처리 - 복잡한 방법보다 쉬운 방법 사용)
        int answer = 0;
        for(int i=0; i<n; ++i) {
        	if(uniform[i] >= 1)
        		++answer;
        }
        
        return answer;
    }

}
