package greedy.exam;

public class greedy03 {
	public static void main(String[] args) {
		System.out.println(solution("BBBBAAAAB"));
	}
	
	// �� ������ �׸��� �˰������� Ǯ�� �׽�Ʈ�� ����ϳ� �ּҰ��� Ȯ���� �������� �ʽ��ϴ�.
	
	// ����) AZAAAZ=5 - ���� ���� ���ٰ� ���������� ���� ����� �ּ�!
	
	// �̰� �׸��� �ƴϰ� ����Ž������ Ǫ�� �����..
	
	// Z ���� ���ĺ�=> A, �� ������ ĭ���� Ŀ�� ������ �̵� => �� ùĭ
	// ���� ���� ���� ���� - �ּ��̵��� ����� �� ���� �ʴ� �����̱� ����
	public static int solution(String name) {
		// 1. �¿� ��ġ�̵��� ���������� �� �̵�/ �������� �� �̵� ���� ���ؼ� 
		//	ª�� �� �����ָ� �ȴ�.
		int size = name.length();
        int right = size-1; // ù ��ġ�� �̵� ���ص� �ǹǷ�
        int left = size-1;
        // right: ���������� ó�� A�� �ƴ� ���ĺ� ������ ��ġ ���ϱ�
        boolean isAll_A = true; // 'A..A' ����ó��
        for(int i=size-1; i>=0; --i) {
        	if(name.charAt(i) != 'A') {
        		isAll_A = false;
        		break;
        	}
        	--right;
        }
        if(isAll_A == true) return 0;
        // left: ó��+1���� ó�� A�� �ƴ� ���ĺ� ������ ��ġ ���ϱ�
        for(int i=1; i<size ; ++i) {
        	if(name.charAt(i) != 'A') break;
        	--left;
        }
        int answer = (right <= left)? right: left;
        
        // 2. ���ĺ� �̵�
        for(int i=0; i<size; ++i) {
        	int up = name.charAt(i) - 'A';
        	int down = 26 - up;
        	answer += (up <= down)? up: down;
        }
        
        return answer;
    }
}
