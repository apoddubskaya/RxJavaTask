package com.company;

import io.reactivex.rxjava3.core.*;

public class Main {
    public static void main(String[] args) {

        SubCategory.getSubIds(0)
                .flatMap(subIds -> Product.getProducts(subIds))
                .flatMap(products -> Observable.fromIterable(products))
                .subscribe(product -> System.out.println(product.name));
    }
}