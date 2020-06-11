package com.arijeet.graphql.dao;

import com.arijeet.graphql.bean.Author;

import java.util.List;
import java.util.Optional;

public class AuthorDAO {

    private List<Author> authors;

    public AuthorDAO(List<Author> authors) {
        this.authors = authors;
    }

    public Optional<Author> getAuthor(String id) {
        return authors.stream().filter(author -> id.equals(author.getName())).findFirst();
    }

    public List<Author> getAuthors() {
        return authors;
    }
}
