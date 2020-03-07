package BruteForce.exam;

public class Brute01 {

	public static void main(String[] args) {
		int[] answers = {1,2,3,4,5};
		System.out.println(solution(answers));
	}
	
	public static int[] solution(int[] answers) {
        
        int size = answers.length;
        int[] su1 = {1,2,3,4,5}; 
        int[] su2 = {2,1,2,3,2,4,2,5};
        int[] su3 = {3,3,1,1,2,2,4,4,5,5};
        int sum1=0, sum2=0, sum3=0;
        
        for(int i=0; i<size; ++i) {
        	int ans = answers[i];
        	int idx1 = i % su1.length;
        	int idx2 = i % su2.length;
        	int idx3 = i % su3.length;
        	if(su1[idx1] == ans) ++sum1;
        	if(su2[idx2] == ans) ++sum2;
        	if(su3[idx3] == ans) ++sum3;
        }
        // max값 먼저 구하고 한번 더 돌기
        int max = Math.max(Math.max(sum1,sum2), sum3);  
        int[] tmp = new int[3];
        int cnt=0;
        if(sum1 == max) { tmp[0] = 1; ++cnt;}
        if(sum2 == max) { tmp[1] = 2; ++cnt;}
        if(sum3 == max) { tmp[2] = 3; ++cnt;}
        
        int[] answer = new int[cnt];
        for(int i=2; i>=0; --i) {
        	if(tmp[i] > 0) answer[--cnt] = tmp[i];
        }
        
        return answer;
    }

}
