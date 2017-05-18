package com.udemy.service.impl;

import com.udemy.entity.Curso;
import com.udemy.repository.CursoJpaRepository;
import com.udemy.service.CursoService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Guillermo Loyo on 18/05/2017.
 */
@Service("cursoService")
public class CursoServiceImpl implements CursoService {

    @Autowired
    @Qualifier("cursoJpaRepository")
    CursoJpaRepository cursoJpaRepository;

    @Override
    public List<Curso> getAllCursos() {
        return cursoJpaRepository.findAll();
    }

    @Override
    public Curso addCurso(Curso curso) {
        return cursoJpaRepository.save(curso);
    }

    @Override
    public int removeCurso(int id) {
        cursoJpaRepository.delete(id);
        return 0;
    }

    @Override
    public Curso updateCurso(Curso curso) {
        return cursoJpaRepository.save(curso);
    }
}
