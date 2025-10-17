import java.util.Scanner;
public class QuickUnionUFImproved {
	
	private int[] id;
	private int[] sz;
	
	public QuickUnionUFImproved(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private int root(int i) {
		while(id[i] != i)i = id[i];
		return i;
	}
	
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}
	
	public static void main(String[] args) {
		
		Scanner scn = new Scanner(System.in);
		int N = scn.nextInt();
		QuickUnionUFImproved uf = new QuickUnionUFImproved(N);
		
		while(scn.hasNextInt()) {
			int p = scn.nextInt();
			int q = scn.nextInt();
			if (!uf.connected(p,q)) {
				uf.union(p,q);
				System.out.println(p + " " + q);
			}
		}
		System.out.println(uf.connected(4,5));
	}
}
