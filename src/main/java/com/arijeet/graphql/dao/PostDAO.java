package com.arijeet.graphql.dao;

import com.arijeet.graphql.bean.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostDAO {

    private List<Post> posts;

    public PostDAO(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return posts.stream().skip(offset).limit(count).collect(Collectors.toList());
    }

    public List<Post> getAuthorsPost(String author) {
        return posts.stream().filter(post -> author.equals(post.getAuthorId())).collect(Collectors.toList());
    }

    public void savePost(Post post) {
        posts.add(0,post);
    }
}
