package StackQueue.exam;

public class Queue03_1 {
	public static void main(String[] args) {
	
	}
	
	public static int solution(int[] priorities, int location) {
		int size = priorities.length;
		int limit = priorities[location];
		//int[] count = new int[10]; //1~9 index�� ���
		// �׳� limit���� ū �켱������ �� �����ְ� 
		// limit�̶� ���� �͵鸸 index�� ��¼��� ���ϴ°� �ʿ��ϹǷ� �迭�� �־��ֱ�
		int answer =0; 
		int minOver = 10;
		int[] limits = new int[size]; int idx =0; 
		for(int i=0; i<size; ++i) { 
			if(priorities[i] > limit) {
				++answer;
				// limit���� ū �� �� ���� ���� ��
				minOver = priorities[i] < minOver ? priorities[i] : minOver;
			}
			else if(priorities[i] == limit) {
				// �ٰ��� �켱�����̹Ƿ� ���� �ڸ��� ���� �ʿ� ���� index�� �־��༭ �ĺ� ���� 
				limits[idx++] = i;
			}
		}
		// �ڿ������� ��ȸ�ϸ鼭 ������ �켱������ minOver�� 
		
		// ������ ������ ���� ���� �����°� �ƴ϶� �׺��� ���� ���� ���� ��ġ���� ������ �޴´�(�����)
		// => limit�� minOver������ ������ �޴´ٸ� minOver�� �׺��� �������� ���� ������ ������ �ް���..
		
		//gg 
		
		
		
        return answer;
    }

}
