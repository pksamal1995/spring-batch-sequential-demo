package com.morganstanley.batch.sequential.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.morganstanley.batch.sequential.demo.entities.Library;

@Repository
public interface LibraryRepo extends JpaRepository<Library, Long>{

}
