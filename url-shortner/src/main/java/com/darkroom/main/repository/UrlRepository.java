package com.darkroom.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darkroom.main.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

}
