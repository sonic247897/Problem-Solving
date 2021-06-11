package DP.exam;

// => 5�� ���� dp Ǯ�� ����
public class DP05 {
	public static void main(String[] args) {
		int[] money = {1, 2, 3, 1};
		System.out.println(solution(money));
	}
	
	// O(n)
	// ���� �������� ��ġ -> ������ �� ���� �и� �溸�� �︰��.
	// ������ ��ĥ �� �ִ� ���� �ִ��� return
	public static int solution(int[] money) {
		int size = money.length;
		// d[i][0] = 0~i���� �ִ� ��ģ ��, i��° �� ������
		// d[i][1] = 0~i���� �ִ� ��ģ ��, i��° ������
		int[][] d = new int[size][2];
		
		// @���� ó�� - �� �� ��; �� ó�� ���� �зȴ��� �ƴ��� ������ ����ؾ� ��
		// ��� 1. �ð� - ù �� �ʹ� ���� �ƴ� ��츦 ���� simulation
		// 1) ù �� �ʹ� ��� => ������ ���� �� ����
		//	�� ��° ���� �� �ʹ� �ɷ� ������ => �� ��° ������ ����
		d[2][0] = money[0];
		d[2][1] = money[0] + money[2];
		for(int i=3; i<size-1; ++i) {
			d[i][0] = Math.max(d[i-1][0], d[i-1][1]); // �̹��� �� ��ħ
			d[i][1] = d[i-1][0] + money[i]; // �̹��� ��ħ
		}
		// d[size-1][0] = Math.max(d[size-2][0], d[size-2][1]);
		// => d[size-1][0]�� 2�� �������� �ùķ��̼� �� �� �������
		int case1 = Math.max(d[size-2][0], d[size-2][1]);
		
		// 2) ù �� ���� �ʴ� ��� => ������ ���� �� ���� �ִ�. (������ �ʹ°� �ƴ�)
		d[1][0] = 0;
		d[1][1] = money[1];
		for(int i=2; i<size; ++i) {
			d[i][0] = Math.max(d[i-1][0], d[i-1][1]); // �̹��� �� ��ħ
			d[i][1] = d[i-1][0] + money[i]; // �̹��� ��ħ
		}
		int case2 = Math.max(d[size-1][0], d[size-1][1]);
		
		return Math.max(case1, case2);
    }
}
