package leetcode.random;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * @author: slwhy
 * @date: 2020/4/13
 * @description: 355. 设计推特
 */

class Article {
    int userId;
    int articleId;

    public Article() {

    }

    public Article(int user, int article) {
        userId = user;
        articleId = article;
    }

}

public class Twitter {
    /**
     * Initialize your data structure here.
     */

    List<Article> articles = new ArrayList<>();
    HashMap<Integer, HashSet<Integer>> follows = new HashMap<>();

    public Twitter() {

    }

    /**
     * Compose a new tweet.
     */
    public void postTweet(int userId, int tweetId) {
        Article article = new Article(userId, tweetId);
        articles.add(0, article);
        if (!follows.keySet().contains(userId)) {
            HashSet<Integer> tmp = new HashSet<>();
            tmp.add(userId);
            follows.put(userId, tmp);
        }
    }

    /**
     * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> tweetIds = new ArrayList<>();
        if (!follows.keySet().contains(userId)) {
            HashSet<Integer> tmp = new HashSet<>();
            tmp.add(userId);
            follows.put(userId, tmp);
        }
        for (Article article : articles) {
            if (tweetIds.size() == 10) break;
            if (follows.get(userId).contains(article.userId)) tweetIds.add(article.articleId);
        }
        return tweetIds;
    }

    /**
     * Follower follows a followee. If the operation is invalid, it should be a no-op.
     */
    public void follow(int followerId, int followeeId) {
        if (!follows.keySet().contains(followerId)) {
            HashSet<Integer> tmp = new HashSet<>();
            tmp.add(followerId);
            follows.put(followerId, tmp);
        }
        follows.get(followerId).add(followeeId);
    }

    /**
     * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
     */
    public void unfollow(int followerId, int followeeId) {
        if (!follows.keySet().contains(followerId)) {
            HashSet<Integer> tmp = new HashSet<>();
            tmp.add(followerId);
            follows.put(followerId, tmp);
        }
        if (followeeId != followerId) follows.get(followerId).remove(followeeId);
    }
}
