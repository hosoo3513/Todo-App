package com.codestates.ToDoApp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
public class ToDoDto {
    @Getter
    @AllArgsConstructor
    @ToString
    public static class Post {
        private String title;
        private int order;
        private boolean completed;
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class Patch {
        private long id;
        private String title;
        private int order;
        private boolean completed;

        public void setToDoId(long id) {
            this.id = id;
        }
    }

    @Getter
    @AllArgsConstructor
    @ToString
    public static class Response {
        private Long id;
        private String title;
        private int order;
        private boolean completed;
    }
}
