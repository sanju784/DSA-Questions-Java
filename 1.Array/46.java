import java.util.*;

/**
 * find all elements that appear more than n/k times
 * 
 * Space Complexity O(k)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {3, 1, 2, 2, 1, 2, 3, 3};
		System.out.println(Arrays.toString(a));
		maxOcc(a);
	}

	static void  maxOcc(int a[]) {
		int n = a.length;
		int k = 4;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for(int i=0;i<n;i++) {
			if(hm.containsKey(a[i])) {
				int count = hm.get(a[i]);
				hm.put(a[i], count +1);
			} else {
				hm.put(a[i], 1);
			}
		}

		Set<Integer> set = hm.keySet();
		for(int i : set) {
			int val = hm.get(i);
			if(val > n/k)
				System.out.println(i + " appear " + val + " times.");
		}
	}
}
