package StackQueue.exam;

public class Stack01 {
	public static void main(String[] args) {

	}
	// 이건 스택으로 푸는게 아니라 거꾸로 탐색 아닌가? O(N^2)-2중 for문
	public static int[] solution(int[] heights) {
        int size = heights.length;
        int[] answer = new int[size]; //정답
        
        for(int i=size-1; i>=0; --i) {
        	int h = heights[i];
        	boolean isReceived = false;
        	for(int j = i-1; j>=0; --j) {
        		if(heights[j] > h) {
        			answer[i] = j+1; //~번째 탑 (1부터 시작)
        			isReceived = true;
        			break;
        		}
        	}
        	if(!isReceived) answer[i] = 0;        	
        }
		
        return answer;
    }
}
