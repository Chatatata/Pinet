package com.thenopebox.pinet.training.question.repository;

import com.thenopebox.pinet.training.question.model.Option;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OptionRepository extends CrudRepository<Option, Long> {
    Option save(Option option);
}
