import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {
	public int lengthOfLongestSubstring(String a) {
	    int n = a.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(a.charAt(j))){
                set.add(a.charAt(j++));
                if(maxLength < j - i) {
                    maxLength = j - i;
                }
            }
            else {
                set.remove(a.charAt(i++));
            }
        }
        return maxLength;
	}
}
