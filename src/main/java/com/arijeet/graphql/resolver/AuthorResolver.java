package com.arijeet.graphql.resolver;

import com.arijeet.graphql.bean.Author;
import com.arijeet.graphql.bean.Post;
import com.arijeet.graphql.dao.PostDAO;
import com.coxautodev.graphql.tools.GraphQLResolver;

import java.util.List;

public class AuthorResolver implements GraphQLResolver<Author> {

    public PostDAO postDAO;

    public AuthorResolver(PostDAO postDAO){
        this.postDAO = postDAO;
    }

    public List<Post> getPosts(Author author){
        return postDAO.getAuthorsPost(author.getName());
    }

}
