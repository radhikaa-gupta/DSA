import java.util.Scanner;
public class QuickUnionUF {
	
	private int[] id;
	
	public QuickUnionUF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
	}
	
	private int root(int i) {
		while (i != id[i]) i = id[i];
		return i;
	}
	
	public boolean connected(int p, int q) {
		return (root(p) == root(q));
	}
	
	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		QuickUnionUF uf = new QuickUnionUF(n);
		while(scn.hasNextInt()) {
			int p = scn.nextInt();
			int q = scn.nextInt();
			
			if (!uf.connected(p,q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}
		}
		System.out.println(uf.connected(1, 2));
		System.out.println(uf.connected(5, 8));
		System.out.println(uf.connected(8, 2));
		
	}
}
