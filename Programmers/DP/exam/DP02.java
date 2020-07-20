package DP.exam;

public class DP02 {
	public static void main(String[] args) {
		System.out.println(solution(2));
	}
	// ��ȭ�� = DP
	public static long solution(int N) {
		if(N==1) return 4;
        
		// d[i] = i��° ���簢�� Ÿ���� �Ѻ� ����
        long[] d = new long[80];
        d[0] = 1;
        d[1] = 1;
        for(int i=2; i<N; ++i) {
        	d[i] = d[i-1] + d[i-2];
        }
        
        long answer = 4*d[N-1] + 2*d[N-2];
        return answer;
    }

}
