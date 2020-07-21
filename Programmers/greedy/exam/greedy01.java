package greedy.exam;

public class greedy01 {
	public static void main(String[] args) {
		
	}
	// ������ ü���� ���� �� - 0, 1, 2 (2�� ������ �л��� ���ϸ����� 1)
	// ó�� �й� ������ ������ 2�� ���� �ִ� �л��� �� 0�� �л����� �� �� ����
	// 0�� �л� �¿�� 2�� �л����� �˻� 
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
        
        // �ѹ��� ���鼭 ����� ��(lost, reserve ��ģ�� ó�� - ������ ������� ���� ��� ���)
        int answer = 0;
        for(int i=0; i<n; ++i) {
        	if(uniform[i] >= 1)
        		++answer;
        }
        
        return answer;
    }

}
