package DfsBfs.exam;

public class Dfs01 {
	public static void main(String[] args) {
		int[] numbers = {1, 1, 1, 1, 1};
		int target = 3;
		System.out.println(solution(numbers, target));
	}
	
	// �� ���� �տ� +,- �� �ϳ� ���̴°� ���� (2^20 = 10^6)
	// ���� �����������Ƿ� check�迭 �ʿ���� => �׷��� �𵨸� �ʿ� ���� �ܼ��� ����
	// ����Ž�� -> for�� ���� 2^20���� ����� ������ ���� ������� �����ϴ� ������ �ʿ��ϹǷ� ��� ���
	public static int solution(int[] numbers, int target) {
        // ����� �� ���ϱ�
		int answer = 0;
		answer = go(numbers, 0, 0, target);
		
        return answer;
    }
	// �������� �ƴϹǷ� numbers�迭�� target �Ź� �Ѱ���� �Ѵ�
	public static int go(int[] numbers, int idx, int result, int target) {
		// ��������� ��������� target�ѹ��� ������ +1
		if(idx == numbers.length) {
			if(result == target)
				return 1;
			else return 0; //�̰� ���ϸ� ���� �ƴҶ� ���� go ȣ���ؼ� ����
		}
		return go(numbers, idx+1, result+numbers[idx], target) + go(numbers, idx+1, result-numbers[idx], target);
	}

}
