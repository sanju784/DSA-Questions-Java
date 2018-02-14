import java.util.*;

/**
 * Given a sequence of words, print all anagrams together
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n^2)
 */
class MyString {
	
	public static void main(String args[]) {
		String wordArr[] = {"cat", "dog", "tac", "god", "act"};
		int n = wordArr.length;
		HashMap<String, HashSet<String>> hm = new HashMap<>();
		for(int i=0;i<n-1;i++) {
			for(int j=i+1;j<n;j++) {
				if(isAnagram(wordArr[i], wordArr[j])) {
					char c[] = wordArr[i].toCharArray();
					Arrays.sort(c);
					String key = new String(c);
					if(hm.containsKey(key)) {
						HashSet<String> ll = hm.get(key);
						ll.add(wordArr[j]);
						hm.put(key, ll);
					} else {
						HashSet<String> ll = new HashSet<>();
						ll.add(wordArr[i]);
						ll.add(wordArr[j]);
						hm.put(key, ll);
					}
				}
			}
		}
		Set<String> set = hm.keySet();
		for(String str : set) {
			System.out.println(hm.get(str));
		}
	}
	
	static boolean isAnagram(String str1, String str2) {
		if(str1.length() != str2.length())
			return false;
		HashMap<Character, Integer> hm = new HashMap<>();
		for(int i=0;i<str1.length();i++) {
			char c = str1.charAt(i);
			if(hm.containsKey(c)) {
				int count = hm.get(c);
				hm.put(c, count+1);
			} else {
				hm.put(c, 1);
			}
		}
		for(int i=0;i<str2.length();i++) {
			char c = str2.charAt(i);
			if(hm.containsKey(c)) {
				int count = hm.get(c);
				hm.put(c, count-1);
			} else {
				return false;
			}
		}
		Set<Character> set = hm.keySet();
		for(char c:set) {
			int cnt = hm.get(c);
			if(cnt != 0)
				return false;
		}
		return true;
	}
}