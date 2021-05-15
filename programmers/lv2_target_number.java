/*
 * DFS 참고 : https://www.pymoon.com/entry/Programmers-%ED%83%80%EA%B2%9F-%EB%84%98%EB%B2%84-BFSDFS-Java-%ED%92%80%EC%9D%B4?category=929770
 * */

class Solution {
	public int solution(int[] numbers, int target) {
		int answer = 0;

		answer += dfs(numbers[0], 1, numbers, target);
		answer += dfs(-numbers[0], 1, numbers, target);

		return answer;
	}

	static int dfs(int calcResult, int index, int[] numbers, int target) {
		if (index >= numbers.length) {
			if (target == calcResult) {
				return 1;
			}
			return 0;
		}

		return dfs(calcResult + numbers[index], index + 1, numbers, target)
				+ dfs(calcResult - numbers[index], index + 1, numbers, target);
	}
}
