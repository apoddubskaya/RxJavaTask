package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Category {
    String name;
    Integer id;

    Category(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    static List<Category> getCategories() {
        return new ArrayList<>(Arrays.asList(
                new Category("Продукты", 0),
                new Category("Хоз.товары", 1),
                new Category("Игрушки", 2)
        ));
    }
}
