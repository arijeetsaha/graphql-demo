package com.arijeet.graphql.bean;

import lombok.Data;

@Data
public class Post {
    String id;
    String title;
    String url;
    String description;
    String category;
    String authorId;
}
