package com.mysite.sbb;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface CardRepository extends JpaRepository <Card, Integer> {

    Page<Card> findAll(Pageable pageable);
}
