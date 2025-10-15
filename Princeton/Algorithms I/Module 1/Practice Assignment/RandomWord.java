import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
	public static void main(String[] args) {
		String champion = null; // current winning word
		int i = 0; // word counter
		
		// read words one by one until input ends
		while (!StdIn.isEmpty()) {
			String word = StdIn.readString();
			i++;
			
			// With probability 1/i, select the new word as champion
			if (StdRandom.bernoulli(1.0/i)) {
				champion = word;
			}
		}
		
		// After all words are read, print the final champion
		if(champion != null) {
			StdOut.println(champion);
		}
	}
}
