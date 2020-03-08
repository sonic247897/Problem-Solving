package hash.exam;

import java.util.Arrays;

public class Hash02 {
	public static void main(String[] args) {
		
	}
	
	 public boolean solution(String[] phone_book) {
		 boolean answer = true;
		 	
		 Arrays.sort(phone_book);
		 int size = phone_book.length;
		 for(int i=0; i<size; ++i) {
		 	for(int j=i+1; j<size; ++j) {
		 		if(phone_book[j].startsWith(phone_book[i])) {
		 			answer = false;
		 			break;
		 		}
		 	}
		 	if(!answer) break;
		 }
		 	
	     return answer;
	 }

}
