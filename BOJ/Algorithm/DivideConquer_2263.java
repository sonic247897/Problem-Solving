package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// 시간복잡도 - 퀵소트처럼 비균등 분할이므로, 최악의 경우 불균형트리는 분할정복으로 풀어도 O(N) 스텝이 걸린다.
// 		각 스텝에서 인오더의 루트를 찾을 때 이분탐색을 쓰면 O(lgN), 해시함수를 쓰면 O(1)이 걸린다.
public class DivideConquer_2263 {
	static int[] inOrder = new int[100000];
	static int[] inOrderIndex = new int[100001]; //해시함수처럼 동작
	static int[] postOrder = new int[100000];
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			for(int i=0; i<n; ++i) {
				inOrder[i] = Integer.parseInt(tmp[i]);
				inOrderIndex[inOrder[i]] = i; //해시함수처럼 사용
			}
			
			tmp = br.readLine().split(" ");
			for(int i=0; i<n; ++i)
				postOrder[i] = Integer.parseInt(tmp[i]);
			//분할정복 => 재귀로 구현
			// 1. 포스트오더의 맨 끝이 루트이므로, 루트를 기준으로 인오더 배열을 분할할 수 있다. (비균등 분할)
			// 2. 인오더 배열을 분할하면 왼쪽, 오른쪽 배열 원소 개수로 포스트오더를 분할할 수 있다.
			StringBuilder sb = new StringBuilder();
			// 분할된 배열의 시작과 끝, 인오더에서 루트 위치, 출력문자열
			go(0, n-1, inOrderIndex[postOrder[n-1]] , sb);
			
			bw.write(sb.toString());
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 포스트오더의 루트는 한번에 찾을 수 있지만, 이것을 이용하여 인오더의 루트는 어떻게 찾을것인가?
	// 1. 순차탐색 - O(N)
	// 2. 이분탐색 - O(lgN) => 정렬된 수가 아니므로 불가능
	// 3. 인오더의 각 정점의 위치를 기록해놓음 - O(1) 
	//	 => <자연수, 0+자연수> 쌍이기 때문에 해시맵 대신 배열을 사용해서 저장할 수 있다. (범위도 가능한 범위내)
	static void go(int start, int end, int inorder_root, StringBuilder sb) {
		if(start == end) { // 분할된 배열에 한 개 원소 남았을 때는 그 원소 출력
			System.out.println("start:"+start+" inorder_root:"+inorder_root);
			sb.append(Integer.toString(inOrder[start])).append(' '); // ???? start랑 inorder_root랑 다른가
			return;
		}
		// 프리오더 - 루트 출력
		sb.append(Integer.toString(inOrder[inorder_root])).append(' ');
		// 왼쪽 재귀
		if(inorder_root-1 >= start)
			go(start, inorder_root-1, inOrderIndex[postOrder[inorder_root-1]], sb);
		// 오른쪽 재귀
		if(inorder_root+1 <= end) 
			go(inorder_root+1, end, inOrderIndex[postOrder[end-1]], sb)
	}
}
