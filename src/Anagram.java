import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagram {
	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
		boolean anagram = false;
		// ArrayList<Integer> anagramPair = new ArrayList<>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		boolean[] visited = new boolean[a.size()];
		if (a.size() == 1) {
			ArrayList<Integer> temp = new ArrayList<Integer>(Arrays.asList(1));

			result.add(temp);
			return result;
		}
		for (int i = 0; i < a.size(); i++) {
			if (!visited[i]) {
				ArrayList<Integer> anagramPair = new ArrayList<>();
				anagramPair.add(i + 1);
				for (int j = i + 1; j < a.size(); j++) {

					anagram = isAnagram(a.get(i), a.get(j));
					if (anagram) {

						anagramPair.add(j + 1);
						visited[j] = true;

						continue;
					}
				}

				result.add(anagramPair);
				// if(!anagram) {
				// temp.add(i+1);
				// result.add(temp);
				// }
			}
		}
		return result;
	}

	public static boolean isAnagram(String a, String b) {
		if (a.length() != b.length()) {
			return false;
		} else {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (int i = 0; i < a.length(); i++) {
				if (map.containsKey(a.charAt(i))) {
					map.put(a.charAt(i), (map.get(a.charAt(i)) + 1));
				} else {
					map.put(a.charAt(i), 1);
				}
			}
			for (int i = 0; i < b.length(); i++) {
				if (!(map.containsKey(b.charAt(i)))) {
					return false;
				} else {
					if (map.containsKey(b.charAt(i))) {
						map.put(b.charAt(i), (map.get(b.charAt(i)) - 1));
					}
				}
			}
			for (Map.Entry<Character, Integer> entry : map.entrySet()) {
				if (entry.getValue() != 0) {
					return false;
				}

			}

		}
		return true; // edit
	}
	
}

