package com.company;

import io.reactivex.rxjava3.core.Observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Product {
    String name;
    Integer subCategoryId;

    Product(String name, Integer subCategoryId) {
        this.name = name;
        this.subCategoryId = subCategoryId;
    }

    static List<Product> getProducts() {
        return new ArrayList<>(Arrays.asList(
                new Product("Творог", 0),

                new Product("Кофе", 1),
                new Product("Чай", 1),

                new Product("Булка", 2),
                new Product("Багет", 2),
                new Product("Батон", 2),

                new Product("Стиральный порошок", 3),
                new Product("Кондиционер для белья", 3),

                new Product("Машинка", 4),

                new Product("Барби", 5),
                new Product("Пупс", 5)
        ));
    }

    static Observable<List<Product>> getProducts(List<Integer> subCategoryIds) {
        return Observable.just(
                getProducts()
                        .stream()
                        .filter(p -> subCategoryIds.contains(p.subCategoryId))
                        .collect(Collectors.toList())
        );
    }
}
