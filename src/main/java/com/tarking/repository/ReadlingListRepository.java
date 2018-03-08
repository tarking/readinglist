package com.tarking.repository;

import com.tarking.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by tuojinguo on 2018/3/6.
 */
public interface ReadlingListRepository extends JpaRepository<Book,Long> {

    List<Book> findByReader(String reader);
}
