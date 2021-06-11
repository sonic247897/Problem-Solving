package Sort.exam;

import java.util.Arrays;
import java.util.Comparator;

// 규칙 찾아서 풀기   => StringBuilder
public class Array02 {

   public static void main(String[] args) {
      //int[] numbers = {0,0,0,0}; -> 0으로 출력
      int[] numbers = {11, 118};
      //int[] numbers = {9876, 987};
            
      //int[] numbers = {12,121};   -> 12121
      //int[] numbers = {21,212}; //-> 21212 "21221"
      System.out.println(solution(numbers));
   }
   
   // 경우의 수 줄이기 => 0은 무조건 맨 뒤에 붙인다. 근데 다 같이 붙이므로 0 무시
   // int타입의 sort 작성해서 그냥 이어붙이기 => 맨 처음 나오는 수가 클수록 앞에 붙여야 큰 수
   // *길이가 다를 경우 예외처리
   public static String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        String[] tmp = new String[size];
        
        // compareTo - int는 object가 아니므로 Comparator 사용 불가
        //    => 어차피 안에서 toString해줘야 하니까 그냥 String배열 만들어서 넣자
        boolean isAllZero = true;
        for(int i=0; i<size; ++i) {
           tmp[i] = Integer.toString(numbers[i]);
           if(numbers[i]!=0){
              isAllZero= false;
           }
        }
        // tc: {0,0,0,0}=>0
        if(isAllZero) return "0";
        
        
        Arrays.sort(tmp, new Comparator<String>() {
           // 0 될 때까지 10으로 나누는 것보다 String으로 변환해서 첫자리 뽑는게 빠른가? 
           // 1) 1000이하 수.. 최대 3번 나눠서 .. 근데 2번째, 3번째 자리수도 같은 경우 비교 힘듬
           //      => 어차피 네 개 자리수를 각 int변수에 저장해놔야 함(char배열과 비슷할듯)
           // 2) String으로 변환 후 각 자리수 비교가 더 편할듯
           // *** 비교하는 수의 길이가 다를 때 처리 (모듈러)
           
           @Override
           public int compare(String o1, String o2) {
              //그냥 두개 붙인거 중에 큰거 출력되게 리턴
              String tmp1 = (new StringBuilder()).append(o1).append(o2).toString();
              String tmp2 = (new StringBuilder()).append(o2).append(o1).toString();
              if(tmp1.compareTo(tmp2) > 0) {
            	  // o1이 o2보다 앞에 와야 함
            	  return -1;
              }else if(tmp1.compareTo(tmp2)<0) {
            	  // o2가 o1보다 앞에 와야 함
            	  return 1;
              }else {
            	  return 0;
              }
           }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<size; ++i) {
           sb.append(tmp[i]);
        }
        answer = sb.toString();
        return answer;
    }
}