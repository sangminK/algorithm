import java.util.*;

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";

		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String part : participant) {
			/* 1. getOrDefault 적용안함 */
			/*if (map.get(part) == null) {
				map.put(part, 1);
			} else {
				int cnt = map.get(part) + 1;
				map.put(part, cnt);
			}*/

			/* 2. getOrDefault 적용 */
			map.put(part, map.getOrDefault(part, 0) + 1);
		}

		for (String comp : completion) {
			map.put(comp, map.get(comp) - 1);
		}

		for (String key : map.keySet()) {
			if (map.get(key) == 1)
				answer = key;
		}

		return answer;
	}
}
