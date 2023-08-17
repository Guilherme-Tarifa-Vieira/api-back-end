package com.stack.apibooklovers.specification;

import com.stack.apibooklovers.domain.book.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> titleLike(String title) {

        return (root, query, builder) -> {
            return builder.like(
                    builder.lower(root.get("title")),
                    "%" + title.toLowerCase() + "%");
        };
    }


}
