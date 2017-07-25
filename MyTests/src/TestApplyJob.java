import java.util.HashMap;
import java.util.Set;

public class TestApplyJob {

	public static void main(String[] args) {

		System.out.println();
		TestApplyJob t = new TestApplyJob();
		float f = t.getAverageBetween3Points(7, 5, 5, 15, 9, -1);
		System.out.println("average: " + f);
		System.out.println(t.isAlmostPalindrome("abccbx"));
		Integer[] a = { 34, 24, 34, 36, 34, 34 };
		t.mostPopularNumber(a);
	}

	public float getAverageBetween3Points(float x1, float x2, float y1, float y2, float z1, float z2) {
		float d1, d2;
		d1 = (float) Math.sqrt(Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
		d2 = (float) Math.sqrt(Math.pow((y1 - y2), 2) + Math.pow((z1 - z2), 2));
		float average = (d1 + d2) / 2;
		return average;
	}

	public boolean isAlmostPalindrome(String p) {
		StringBuilder b = new StringBuilder(p);
		StringBuilder r = b.reverse();
		if (p.toString().equalsIgnoreCase(r.toString())) {
			return true; // it's a palindrome;
		}
		int size = p.length();
		int middle = Math.round(size / 2);
		String p1 = p.substring(0, middle);
		String p2 = p.substring(middle, size);
		StringBuilder p3 = new StringBuilder(p2).reverse();
		int match = 0;
		for (int i = middle - 1; i > 0; i--) {
			if (p1.charAt(i) == p3.toString().charAt(i)) {
				match++;
			}
		}
		return match == middle || match == middle - 1;
	}

	public void mostPopularNumber(Integer[] array) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer i : array) {
			if (map.get(i) != null) {
				int c = map.get(i);
				c = c + 1;
				map.put(i, c);
			} else {
				map.put(i, 1);
			}
		}
		Set<Integer> keys = map.keySet();
		int m = 0, g = 0, vm = 0, vg = 0;
		for (Integer k : keys) {
			g = map.get(k);
			vg = k;
			if (k != null) {
				if (g > m) {
					m = g;
					vm = vg;
				}
			}
		}
		System.out.println(vm + " || " + m);
	}
}
