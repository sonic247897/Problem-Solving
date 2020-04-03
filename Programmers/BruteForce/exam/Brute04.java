package BruteForce.exam;

public class Brute04 {
	public static void main(String[] args) {
		int brown = 8;
		int red = 1;
		int[] result = solution(brown, red);
		System.out.println(result[0]+":"+result[1]);
	}
	// ���ο� ����(���ΰ� �� ª���Ƿ� for���� 1���� ���� �� ���� ã���Ƿ�)
	// 2�� �������� ������� �� ���� ������ ���°� ���� ������.
	// 	=> ������ ������ �� �� ���� for������ 1���� �־ Ǫ�� ���� ����Ž�� ������ ��
	public static int[] solution(int brown, int red) {
        int[] answer = new int[2];
        // brown = (����+����)*2 + 4 [red�� ����, ����]
        // red = ����*����
        // ¦�� �ƴϹǷ� �׳� ���� ���� ���
        int b = (brown-4)/2; // brown�� �ּ� 8�̻� ¦���̹Ƿ� b�� ������ ����
        // �� ���� �� �� ª�� ���� ����
        // (2*����) = ����b - ������, ���� ������ ���� ���� ����
        int height = (int) ( (b - Math.sqrt(b*b - 4*red)) /2);
        int width = red/height;
        answer[0] = width+2; //[red�� ����, ����] +2
        answer[1] = height+2;
        return answer;
    }

}
