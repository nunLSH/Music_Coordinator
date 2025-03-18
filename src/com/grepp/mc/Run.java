package com.grepp.mc;

import com.google.gson.Gson;
import java.util.function.BiPredicate;

public class Run {

    public static void main(String[] args) {
        Book book = new Book("해리포터", "조앤롤링", 300, 10000);

        Gson gson = new Gson();
        String json = gson.toJson(book);
        System.out.println(json);

        Book book2 = gson.fromJson(json, Book.class);
        System.out.println(book2);

    }
}
