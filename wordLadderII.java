public class Solution {
	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		dict.add(end);

		Map<String, Set<List<String>>> map = new HashMap<String, Set<List<String>>>();
		Queue<String> queue = new LinkedList<String>();

		List<String> startPath = new ArrayList<String>();
		startPath.add(start);
		Set<List<String>> startSet = new HashSet<List<String>>();
		startSet.add(startPath);
		queue.offer(start);
		map.put(start, startSet);

		List<List<String>> ret = new ArrayList<List<String>>();

		while (!queue.isEmpty()) {
			String str = queue.poll();

			if (str.equals(end)) {
				ret.addAll(map.get(end));
				return ret;
			}

			for (int i = 0; i < str.length(); i++) {
				for (int j = 0; j < 26; j++) {
					String newStr = replace(str, i, (char) ('a' + j));

					if (dict.contains(newStr)) {
						if (!map.containsKey(newStr)) {
							// Construct a new path set.
							Set<List<String>> prevSet = map.get(str);
							Set<List<String>> newSet = new HashSet<List<String>>();
							for (List<String> path : prevSet) {
								List<String> newPath = new ArrayList<String>(
										path);
								newPath.add(newStr);
								newSet.add(newPath);
							}

							map.put(newStr, newSet);
							queue.offer(newStr);
						} else {
							Set<List<String>> prevSet = map.get(str);
							Set<List<String>> newSet = map.get(newStr);

							Iterator<List<String>> prevIt = prevSet.iterator();
							Iterator<List<String>> newIt = newSet.iterator();

							// Increase the path set.
							if (prevIt.next().size() + 1 == newIt.next().size()) {
								for (List<String> path : prevSet) {
									List<String> newPath = new ArrayList<String>(
											path);
									newPath.add(newStr);
									newSet.add(newPath);
								}
							}
						}
					}
				}
			}
		}

		return ret; // Return an empty set.
	}

	private String replace(String str, int index, char c) {
		StringBuilder sb = new StringBuilder(str);
		sb.setCharAt(index, c);
		return sb.toString();
	}
}