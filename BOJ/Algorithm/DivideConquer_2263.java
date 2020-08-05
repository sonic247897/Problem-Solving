package Algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// �ð����⵵ - ����Ʈó�� ��յ� �����̹Ƿ�, �־��� ��� �ұ���Ʈ���� ������������ Ǯ� O(N) ������ �ɸ���.
// 		�� ���ܿ��� �ο����� ��Ʈ�� ã�� �� �̺�Ž���� ���� O(lgN), �ؽ��Լ��� ���� O(1)�� �ɸ���.
public class DivideConquer_2263 {
	static int[] inOrder = new int[100000];
	static int[] inOrderIndex = new int[100001]; //�ؽ��Լ�ó�� ����
	static int[] postOrder = new int[100000];
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			String[] tmp = br.readLine().split(" ");
			for(int i=0; i<n; ++i) {
				inOrder[i] = Integer.parseInt(tmp[i]);
				inOrderIndex[inOrder[i]] = i; //�ؽ��Լ�ó�� ���
			}
			
			tmp = br.readLine().split(" ");
			for(int i=0; i<n; ++i)
				postOrder[i] = Integer.parseInt(tmp[i]);
			//�������� => ��ͷ� ����
			// 1. ����Ʈ������ �� ���� ��Ʈ�̹Ƿ�, ��Ʈ�� �������� �ο��� �迭�� ������ �� �ִ�. (��յ� ����)
			// 2. �ο��� �迭�� �����ϸ� ����, ������ �迭 ���� ������ ����Ʈ������ ������ �� �ִ�.
			StringBuilder sb = new StringBuilder();
			// ���ҵ� �迭�� ���۰� ��, �ο������� ��Ʈ ��ġ, ��¹��ڿ�
			go(0, n-1, inOrderIndex[postOrder[n-1]] , sb);
			
			bw.write(sb.toString());
			bw.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ����Ʈ������ ��Ʈ�� �ѹ��� ã�� �� ������, �̰��� �̿��Ͽ� �ο����� ��Ʈ�� ��� ã�����ΰ�?
	// 1. ����Ž�� - O(N)
	// 2. �̺�Ž�� - O(lgN) => ���ĵ� ���� �ƴϹǷ� �Ұ���
	// 3. �ο����� �� ������ ��ġ�� ����س��� - O(1) 
	//	 => <�ڿ���, 0+�ڿ���> ���̱� ������ �ؽø� ��� �迭�� ����ؼ� ������ �� �ִ�. (������ ������ ������)
	static void go(int start, int end, int inorder_root, StringBuilder sb) {
		if(start == end) { // ���ҵ� �迭�� �� �� ���� ������ ���� �� ���� ���
			System.out.println("start:"+start+" inorder_root:"+inorder_root);
			sb.append(Integer.toString(inOrder[start])).append(' '); // ???? start�� inorder_root�� �ٸ���
			return;
		}
		// �������� - ��Ʈ ���
		sb.append(Integer.toString(inOrder[inorder_root])).append(' ');
		// ���� ���
		if(inorder_root-1 >= start)
			go(start, inorder_root-1, inOrderIndex[postOrder[inorder_root-1]], sb);
		// ������ ���
		if(inorder_root+1 <= end) 
			go(inorder_root+1, end, inOrderIndex[postOrder[end-1]], sb)
	}
}
