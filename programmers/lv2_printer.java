import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 0;

		// push : offer(n)
		// pop : poll()
		// peek() : 값을 꺼내지 않고 Q 맨 앞의 값 확인하기
		Queue<Integer> q = new LinkedList<>();
		List<Integer> prList = new ArrayList<Integer>();

		for (int i = 0; i < priorities.length; i++) {
			prList.add(priorities[i]);
			q.offer(i); // A B C D
		}

		while (!q.isEmpty()) {
			int lo = q.poll(); // A B C D
			int max = Collections.max(prList);

			if (prList.get(lo) < max) {
				q.offer(lo); // 큐 뒤에 넣기
			} else {
				answer++; // 출력
				prList.remove(lo);
				prList.add(lo, -1);
				if (lo == location)
					break;
			}
		}

		return answer;
	}
}
