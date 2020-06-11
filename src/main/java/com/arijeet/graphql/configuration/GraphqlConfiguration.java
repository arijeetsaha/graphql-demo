package com.arijeet.graphql.configuration;

import com.arijeet.graphql.bean.Author;
import com.arijeet.graphql.bean.Post;
import com.arijeet.graphql.dao.AuthorDAO;
import com.arijeet.graphql.dao.PostDAO;
import com.arijeet.graphql.resolver.AuthorResolver;
import com.arijeet.graphql.resolver.PostResolver;
import com.arijeet.graphql.resolver.QueryResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Configuration
public class GraphqlConfiguration {

    @Bean
    public PostDAO postDAO() {
        List<Post> posts = new ArrayList<>();
        for(int postId = 0; postId < 10; ++postId){
            for(int authorId = 0; authorId < 10; ++authorId) {
                Post post = new Post();
                post.setAuthorId("Author"+authorId);
                post.setCategory("Category"+authorId+postId);
                post.setDescription("Description"+ authorId+postId);
                post.setId("Post"+authorId+postId);
                post.setTitle("Title"+authorId+postId);
                post.setUrl("url"+authorId+postId);
                System.out.println(post);
                posts.add(post);
            }
        }
        return new PostDAO(posts);
    }

    @Bean
    public AuthorDAO authorDAO() {
        List<Author> authors = new ArrayList<>();
        for(int authorId = 0; authorId <10; ++authorId) {
            Author author = new Author();
            author.setId(UUID.randomUUID().toString());
            author.setName("Author"+authorId);
            authors.add(author);
            System.out.println(author);
        }
        return new AuthorDAO(authors);
    }

    @Bean
    public PostResolver postResolver(AuthorDAO authorDAO) {
        return new PostResolver(authorDAO);
    }

    @Bean
    public AuthorResolver authorResolver(PostDAO postDAO){
        return new AuthorResolver(postDAO);
    }

    @Bean
    public QueryResolver query(PostDAO postDAO, AuthorDAO authorDAO) {
        return new QueryResolver(postDAO, authorDAO);
    }

}
