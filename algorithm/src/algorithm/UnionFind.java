package algorithm;

public class UnionFind {
	private int[] id;
	// i�� ��Ʈ�� �ϴ� Ʈ���� �پ��ִ� object���� ��
	private int[] sz;
	
	public UnionFind(int N) {
		id = new int[N];
		sz = new int[N];
		// �ڱ� �ڽ����� id �ʱ�ȭ
		for(int i=0; i<N; ++i) {
			id[i] = i;
			sz[i] = 1;
		}
			
	}
	
	private int root(int i) {
		// ��Ʈ�� ������ ������ �θ� ����Ʈ ����
		while(i != id[i]) i = id[i];
		return i;
	}
	
	public boolean connected(int p, int q) {
		// ���� ��Ʈ���� üũ
		return root(p) == root(q);
	}
	
	// ū Ʈ���� ��Ʈ�� ���� Ʈ���� ��Ʈ ���̱� 
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if(i==j) return;
		if(sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		}
		else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
}
