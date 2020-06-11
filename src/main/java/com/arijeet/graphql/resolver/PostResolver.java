package com.arijeet.graphql.resolver;

import com.arijeet.graphql.bean.Author;
import com.arijeet.graphql.bean.Post;
import com.arijeet.graphql.dao.AuthorDAO;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.Optional;

public class PostResolver implements GraphQLResolver<Post> {

    private AuthorDAO authorDAO;

    public PostResolver(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    public Optional<Author> getAuthor(Post post) {
        return authorDAO.getAuthor(post.getAuthorId());
    }
}
