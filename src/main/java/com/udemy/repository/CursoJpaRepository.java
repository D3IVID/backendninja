package com.udemy.repository;

import com.udemy.entity.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Guillermo Loyo on 17/05/2017.
 */
@Repository("cursoJpaRepository")
public interface CursoJpaRepository extends JpaRepository<Curso,Serializable>{
}
