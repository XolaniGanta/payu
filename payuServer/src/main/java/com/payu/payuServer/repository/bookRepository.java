package com.payu.payuServer.repository;

import com.payu.payuServer.model.book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface bookRepository extends JpaRepository<book,Integer> {
}
