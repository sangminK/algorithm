import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
	public String solution(int[] numbers) {
		String answer = "";

		List<Integer> numbersArr = new ArrayList<Integer>();

		int zero_cnt = 0;
		for (int n : numbers) {
			if (n == 0)
				zero_cnt++;
			numbersArr.add(n);
		}

		// 예외 케이스 [0,0,0, ...]
		if (zero_cnt == numbersArr.size())
			return "0";

		answer = numbersArr.stream().sorted((a, b) -> {
			// 정렬
			String strA = String.valueOf(a);
			String strB = String.valueOf(b);

			if (Integer.parseInt(strA + strB) > Integer.parseInt(strB + strA))
				return -1;
			else if (Integer.parseInt(strA + strB) < Integer.parseInt(strB + strA))
				return 1;
			else
				return 0;

		}).map(n -> String.valueOf(n)).collect(Collectors.joining(""));

		return answer;
	}
}
