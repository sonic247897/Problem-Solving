package hash.exam;

import java.util.Arrays;

public class Hash01 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		solution(participant, completion);
	}
	
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
        
		Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; ++i) {
        	// 문자열 비교는 != 사용하지 말 것
        	if(!completion[i].equals(participant[i])) {
        		answer = participant[i];
        		break;
        	}
        }
        if(answer.equals("")) answer = participant[participant.length-1];

        return answer;
    }

}
