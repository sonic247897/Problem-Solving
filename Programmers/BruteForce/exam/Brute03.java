package BruteForce.exam;

public class Brute03 {
	public static void main(String[] args) {
		
	}
	// ���ھ߱� ���� 3�� �� ���� �����༭ �����
	// ����x,��Ʈ����ũx: ���� 123~987
	// ���� ���������� �Ź� 3�б� �� ���
	// (���ڱ���3)^(��ɰ���3) *���� 100�� = 900
	public static int solution(int[][] baseball) {
		// �� ���� ��ɾ��� ���ǿ� �´��� Ȯ��
        // boolean[] correct = new boolean[988]; // 0~ 987
        int[] correct = new int[988]; // 0~ 987
        
        // ����=3 ���
        int size_baseball = baseball.length;
        for(int i=0; i<size_baseball; ++i) {
        	// baseball�迭�� ��°�� �Ѱ��ָ� �ȿ��� ����Լ� �� ������ ��
        	int num = baseball[i][0];
        	int strike = baseball[i][1];
        	int ball = baseball[i][2];
        	if(strike == 0 && ball == 0) { // �ƿ��� ���� ��� �� �ʿ� X
        		 correct[num] = 1;
        		 // @����!! boolean�迭�� true, false�� �ϸ� 
        		 // �̹� �湮�� ���� �ٽ� �湮�ؼ� ����� �ȵǹǷ� �ּ� 3���� ���� �ʿ�
        		 // 	: 0(�湮X), 1(�湮�ߴµ� false), 2(�湮�ߴµ� true)
        		 //	=> �ȵ�. ���� ���ǿ� ���� true->false�� ������� �� ���� ����/ false�� ��� false��
        		 // ������ ����� ����: ��� ���� ��ɾ ���� true�� false�� ����� ����
        		 
        	}
        	go(num, strike, ball, correct, 0);
        }
        
        int answer = 0;
        int size_correct = correct.length;
        for(int i=0; i<size_correct; ++i) {
        	if(correct[i] == 2)
        		++answer;
        }
        
        return answer;
    }
	
	public static void go(int num, int strike, int ball, int[] correct, int idx) {
		// base case - 1. ��Ʈ����ũ, �� �� ��ų�  2. ���ڸ� ��� �˻����� ��
		if((strike==0 && ball==0) || idx == 3) {
			// correct�迭 trueó��
			// if(correct[i] == 0) �湮���� �ʾҴٸ�
			return;
		}
		// ��Ʈ����ũ
		if(strike >= 0) {
			// �� �����ϳ�.. StringBuilder.append�� ����..
			// -> �ȵ�. �� ���Ǹ��� correct�迭 �����ؾ���..?
			//	=> base case�� �������� �ϸ� �ȵǳ�??
			int tmp = num;
			for(int i=0; i<2-idx; ++i) {
				tmp /= 10; 
			}
			tmp *= 10
			
			for(int i=0; i<988; ++i) {
				correct[idx]
			}
			go(num, strike-1, ball, correct, 1);
		}
		// ��
		if(ball >= 0) {
			go(num,)
		}
		
		
	}
}
