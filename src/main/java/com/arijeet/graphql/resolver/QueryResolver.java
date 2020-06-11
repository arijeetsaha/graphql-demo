package com.arijeet.graphql.resolver;

import com.arijeet.graphql.bean.Author;
import com.arijeet.graphql.bean.Post;
import com.arijeet.graphql.dao.AuthorDAO;
import com.arijeet.graphql.dao.PostDAO;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import java.util.List;

public class QueryResolver implements GraphQLQueryResolver {

    private PostDAO postDAO;

    private AuthorDAO authorDAO;

    public QueryResolver(PostDAO postDAO, AuthorDAO authorDAO) {
        this.postDAO = postDAO;
        this.authorDAO = authorDAO;
    }

    public List<Post> getRecentPosts(int count, int offset) {
        return postDAO.getRecentPosts(count, offset);
    }

    public  List<Author> getAuthors() {
        return authorDAO.getAuthors();
    }
}
