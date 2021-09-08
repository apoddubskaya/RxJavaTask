package com.company;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SubCategory {
    String name;
    Integer id;
    Integer categoryId;

    SubCategory(String name, Integer id, Integer categoryId) {
        this.name = name;
        this.id = id;
        this.categoryId = categoryId;
    }

    static List<SubCategory> getSubCategories() {
        return new ArrayList<>(Arrays.asList(
                new SubCategory("Молочная продукция", 0, 0),
                new SubCategory("Напитки", 1, 0),
                new SubCategory("Хлебобулочные изделия", 2, 0),

                new SubCategory("Для стирки", 3, 1),

                new SubCategory("Для мальчиков", 4, 2),
                new SubCategory("Для девочек", 5, 2)
        ));
    }

    static Observable<List<Integer>> getSubIds(Integer categoryId) {
        return Observable.just(
                getSubCategories()
                        .stream()
                        .filter(sub -> Objects.equals(categoryId, sub.categoryId))
                        .map(sub -> sub.id)
                        .collect(Collectors.toList())
        );
    }

}
