import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
/**
 * Sort an array according to the order defined by another array
 * 
 * Space Complexity O(n)
 * Time Complexity  O(n) + O(m*n)
 */
class Array {
    public static void main(String[] args) {
        int a1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int a2[] = {2, 1, 8, 3};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<a1.length;i++) {
            if(map.containsKey(a1[i])) {
                int val = map.get(a1[i]);
                map.put(a1[i], val+1);
            } else {
                map.put(a1[i], 1);
            }
        }
        int j=0;
        for(int i=0;i<a2.length;i++) {
            int count = map.get(a2[i]);
            map.remove(a2[i]);
            while(count > 0) {
                a1[j++] = a2[i];
                count--;
            }
        }
        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> e:set) {
            int count = e.getValue();
            while(count > 0) {
                a1[j++] = e.getKey();
                count--;
            }
        }
        System.out.println(Arrays.toString(a1));
    }
}