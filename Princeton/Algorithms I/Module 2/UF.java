//Array id based approach
import java.util.Scanner;

public class UF {
	
	private int[] id;
	
	public UF(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
			// id of each is the index itself
		}
	}
	
	public void union(int p, int q) {
		if (!connected(p,q)) {
			int pid = id[p];
			int qid = id[q];
			for (int i = 0; i < id.length; i++) {
				if (id[i] == pid) id[i] = qid;
			}
		}
	}
	
	public boolean connected(int p, int q) {
		return (id[p] == id[q]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		UF uf = new UF(N);
		while(sc.hasNextInt()) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			if (!uf.connected(p,q)) {
				uf.union(p,q);
				System.out.println(p + " " + q);
			}
		}
		System.out.println(uf.connected(4, 3));
		System.out.println(uf.connected(4, 5));
	}
}
