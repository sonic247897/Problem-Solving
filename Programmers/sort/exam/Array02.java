package Sort.exam;

import java.util.Arrays;
import java.util.Comparator;

// ��Ģ ã�Ƽ� Ǯ��   => StringBuilder
public class Array02 {

   public static void main(String[] args) {
      //int[] numbers = {0,0,0,0}; -> 0���� ���
      int[] numbers = {11, 118};
      //int[] numbers = {9876, 987};
            
      //int[] numbers = {12,121};   -> 12121
      //int[] numbers = {21,212}; //-> 21212 "21221"
      System.out.println(solution(numbers));
   }
   
   // ����� �� ���̱� => 0�� ������ �� �ڿ� ���δ�. �ٵ� �� ���� ���̹Ƿ� 0 ����
   // intŸ���� sort �ۼ��ؼ� �׳� �̾���̱� => �� ó�� ������ ���� Ŭ���� �տ� �ٿ��� ū ��
   // *���̰� �ٸ� ��� ����ó��
   public static String solution(int[] numbers) {
        String answer = "";
        int size = numbers.length;
        String[] tmp = new String[size];
        
        // compareTo - int�� object�� �ƴϹǷ� Comparator ��� �Ұ�
        //    => ������ �ȿ��� toString����� �ϴϱ� �׳� String�迭 ���� ����
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
           // 0 �� ������ 10���� ������ �ͺ��� String���� ��ȯ�ؼ� ù�ڸ� �̴°� ������? 
           // 1) 1000���� ��.. �ִ� 3�� ������ .. �ٵ� 2��°, 3��° �ڸ����� ���� ��� �� ����
           //      => ������ �� �� �ڸ����� �� int������ �����س��� ��(char�迭�� ����ҵ�)
           // 2) String���� ��ȯ �� �� �ڸ��� �񱳰� �� ���ҵ�
           // *** ���ϴ� ���� ���̰� �ٸ� �� ó�� (��ⷯ)
           
           @Override
           public int compare(String o1, String o2) {
              //�׳� �ΰ� ���ΰ� �߿� ū�� ��µǰ� ����
              String tmp1 = (new StringBuilder()).append(o1).append(o2).toString();
              String tmp2 = (new StringBuilder()).append(o2).append(o1).toString();
              if(tmp1.compareTo(tmp2) > 0) {
            	  // o1�� o2���� �տ� �;� ��
            	  return -1;
              }else if(tmp1.compareTo(tmp2)<0) {
            	  // o2�� o1���� �տ� �;� ��
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