package algorithm;

public class UnionFind {
	private int[] id;
	// i를 루트로 하는 트리에 붙어있는 object들의 수
	private int[] sz;
	
	public UnionFind(int N) {
		id = new int[N];
		sz = new int[N];
		// 자기 자신으로 id 초기화
		for(int i=0; i<N; ++i) {
			id[i] = i;
			sz[i] = 1;
		}
			
	}
	
	private int root(int i) {
		// 루트에 도달할 때까지 부모 포인트 추적
		while(i != id[i]) i = id[i];
		return i;
	}
	
	public boolean connected(int p, int q) {
		// 같은 루트인지 체크
		return root(p) == root(q);
	}
	
	// 큰 트리의 루트에 작은 트리의 루트 붙이기 
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
