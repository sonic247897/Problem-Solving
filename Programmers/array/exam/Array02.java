package array.exam;

import java.util.Arrays;
import java.util.Comparator;

// 규칙 찾아서 풀기
public class Array02 {

	public static void main(String[] args) {

	}
	
	// 0과 양수 - 0이 몇개 중복될수 있을지 모르므로 수 예측 불가
	// 경우의 수 줄이기 => 0은 무조건 맨 뒤에 붙인다. 근데 다 같이 붙이므로 0 무시
	// int타입의 sort 작성해서 그냥 이어붙이기 => 무조건 맨 처음 나오는 수가 클수록 앞에 붙여야 큰 수
	public String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        String[] tmp = new String[size];
        
        // compareTo - int는 object가 아니므로 Comparator 사용 불가
        // 	=> 어차피 안에서 toString해줘야 하니까 그냥 String배열 만들어서 넣자
        for(int i=0; i<size; ++i) {
        	tmp[i] = Integer.toString(numbers[i]);
        }
        
        Arrays.sort(tmp, new Comparator<String>() {
        	// 0 될 때까지 10으로 나누는 것보다 String으로 변환해서 첫자리 뽑는게 빠른가? 
        	// 1) 1000이하 수.. 최대 3번 나눠서 .. 근데 2번째, 3번째 자리수도 같은 경우 비교 힘듬
        	//		=> 어차피 네 개 자리수를 각 int변수에 저장해놔야 함(char배열과 비슷할듯)
        	// 2) String으로 변환 후 각 자리수 비교가 더 편할듯
        	// *** 비교하는 수의 길이가 다를 때 처리 
        	
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
