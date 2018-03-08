package com.tarking.repository;

import com.tarking.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tuojinguo on 2018/3/8.
 */

public interface ReaderRepository extends JpaRepository<Reader,String>{
    //Reader findOne(String username);
}
