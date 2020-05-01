package Design;

import java.util.*;

public class DesignTwitter {

    private int timeStamp = 0;
    private HashMap<Integer, User> map;

    public DesignTwitter() {
        this.map = new HashMap<>();
    }

    class User{

        public int id;
        public HashSet<Integer> followed;
        public Tweet tweetHead;

        public User(int id) {
            this.id = id;
            this.followed = new HashSet<>();
            follow(id);
            this.tweetHead = null;
        }

        public void follow(int id){
            followed.add(id);
        }

        public void unfollow(int id){
            followed.remove(id);
        }

        public void post(int id){
            Tweet tweet = new Tweet(id);
            tweet.next = tweetHead;
            tweetHead = tweet;
        }
    }

    class Tweet{

        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            this.time = timeStamp++;
            this.next = null;
        }
    }

    public void postTweet(int userId, int tweetId){
        if(!map.containsKey(userId)){
            User user = new User(userId);
            map.put(userId, user);
        }
        map.get(userId).post(tweetId);
    }

    public void follow(int followerId, int followeeId){
        if(!map.containsKey(followerId)){
            User follower = new User(followerId);
            map.put(followerId, follower);
        }
        if(!map.containsKey(followeeId)){
            User followee = new User(followeeId);
            map.put(followeeId, followee);
        }
        map.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId){
        if(!map.containsKey(followerId) || followerId == followeeId){
            return;
        }
        map.get(followerId).unfollow(followeeId);
    }

    public List<Integer> getNewsFeed(int id){
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>((a, b) -> (b.time - a.time));
        HashSet<Integer> friends = map.get(id).followed;
        for(Integer friend : friends){
            Tweet tweet = map.get(friend).tweetHead;
            while(tweet != null){
                priorityQueue.add(tweet);
                tweet = tweet.next;
            }
        }
        int count = 10;
        while(!priorityQueue.isEmpty() && count > 0){
            Tweet tweet = priorityQueue.poll();
            res.add(tweet.id);
            count--;
        }
        return res;
    }

}
