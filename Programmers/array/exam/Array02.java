package array.exam;

import java.util.Arrays;
import java.util.Comparator;

// ��Ģ ã�Ƽ� Ǯ��
public class Array02 {

	public static void main(String[] args) {

	}
	
	// 0�� ��� - 0�� � �ߺ��ɼ� ������ �𸣹Ƿ� �� ���� �Ұ�
	// ����� �� ���̱� => 0�� ������ �� �ڿ� ���δ�. �ٵ� �� ���� ���̹Ƿ� 0 ����
	// intŸ���� sort �ۼ��ؼ� �׳� �̾���̱� => ������ �� ó�� ������ ���� Ŭ���� �տ� �ٿ��� ū ��
	public String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        String[] tmp = new String[size];
        
        // compareTo - int�� object�� �ƴϹǷ� Comparator ��� �Ұ�
        // 	=> ������ �ȿ��� toString����� �ϴϱ� �׳� String�迭 ���� ����
        for(int i=0; i<size; ++i) {
        	tmp[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(tmp, new Comparator<String>() {
        	// 0 �� ������ 10���� ������ �ͺ��� String���� ��ȯ�ؼ� ù�ڸ� �̴°� ������? 
        	// 1) 1000���� ��.. �ִ� 3�� ������ .. �ٵ� 2��°, 3��° �ڸ����� ���� ��� �� ����
        	//		=> ������ �� �� �ڸ����� �� int������ �����س��� ��(char�迭�� ����ҵ�)
        	// 2) String���� ��ȯ �� �� �ڸ��� �񱳰� �� ���ҵ�
        	// *** ���ϴ� ���� ���̰� �ٸ� �� ó�� 
        	
        	@Override
        	public int compare(String o1, String o2) {
        		int result=0;
        		if
        		
        		return 0;
        	}
        	
        });
        
        return answer;
    }
}
