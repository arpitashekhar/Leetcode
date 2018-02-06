package arraysAndStrings;
import java.util.*;
public class TwitterRecommendation {
	public static String[][] follow(String[][] followGraphEdges, String[][] likeGraphEdges, String targetUser, int minThreashold) {
		String[][] result = {};
		List<String> followers = new ArrayList<String>();
		int likes = 1;
		int k = 0;
		Map<String, Integer> tweetId = new HashMap<String, Integer>();
		
		for(int i = 0; i < followGraphEdges.length; i++) {
			if(followGraphEdges[i][0] == targetUser)
				followers.add(followGraphEdges[i][1]);
		}
		
		//System.out.println(Arrays.toString(followers.toArray()));
		
		for(int j = 0; j < likeGraphEdges.length; j++) {
			String follower = likeGraphEdges[j][0];
			String tid = likeGraphEdges[j][1];
			if(followers.contains(follower) && tweetId.containsKey(tid)) {
				tweetId.put(tid, tweetId.get(tid) + 1);
			} else if(followers.contains(follower)){
				tweetId.put(tid, likes);
			}
		}
		while(k < minThreashold) {
			tweetId.values().remove(k);
			k++;
		}
		tweetId.entrySet().forEach(System.out::println);
		return result;
	}
	
	public static void main(String args[]) {
		String[][] followGraphEdges = {{"A", "B"}, {"A", "C"}, {"B", "C"}};
		String[][] likeGraphEdges = {{"A", "T1"}, {"A", "T2"}, {"B", "T2"}, {"B", "T1"}, {"C", "T2"}};
		String targetUser = "A";
		int minThreashold = 2;
		follow(followGraphEdges, likeGraphEdges, targetUser, minThreashold);
	}
}
