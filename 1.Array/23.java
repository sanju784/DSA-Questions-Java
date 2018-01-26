import java.util.*;
/**
 * Sort elements by frequency
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n)
 */
class Array {
	public static void main(String args[]) {
		int a[] = {2,3,2,4,5,12,2,3,3,3,12};
		System.out.println(Arrays.toString(a));
		frequencySort(a);
		System.out.println(Arrays.toString(a));
		System.out.println("----------------");
		int a2[] = {2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8};
		System.out.println(Arrays.toString(a2));
		frequencySort2(a2);
		System.out.println(Arrays.toString(a2));
	}
	
	//order of element is not maintained here
	static void frequencySort(int a[]) {
		Map<Integer, Integer> hm = new HashMap<Integer, Integer>();
		for(int i=0;i<a.length;i++) {
			if(hm.containsKey(a[i])) {
				int count = hm.get(a[i]);
				hm.put(a[i], count+1);
			} else {
				hm.put(a[i], 1);
			}
		}
		Set<Map.Entry<Integer,Integer>> set = hm.entrySet();
		List<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>> (){
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		int j=0;
		for(Map.Entry<Integer, Integer> entry : list) {
			int count = entry.getValue();
			for(int i=0;i<count;i++) {
				a[j++] = entry.getKey();
			}
		}
	}
	
	//order of element is maintained here
	static void frequencySort2(int a[]) {
		LinkedHashMap<Integer, Integer> linkedHash = new LinkedHashMap<>();
		TreeMap<Integer, LinkedList<Integer>> treeMap = new TreeMap<>(Collections.reverseOrder());
		for(int i=0;i<a.length;i++) {
			if(linkedHash.containsKey(a[i])) {
				int count = linkedHash.get(a[i]);
				linkedHash.put(a[i], count+1);
			} else {
				linkedHash.put(a[i], 1);
			}
		}
		
		LinkedList<Integer> linkedList = null;
		for(Integer key:linkedHash.keySet()) {
			Integer val = linkedHash.get(key);
			if(treeMap.containsKey(val)) {
				linkedList = treeMap.get(val);
			} else {
				linkedList = new LinkedList<>();
			}
			linkedList.add(key);
			treeMap.put(val, linkedList);
		}
		int j=0;
		for(Integer key : treeMap.keySet()) {
			List<Integer> list = treeMap.get(key);
			for(Integer l:list) {
				for(int i=0;i<key;i++) {
					a[j++] = l;
				}
			}
			
		}
	}
}
