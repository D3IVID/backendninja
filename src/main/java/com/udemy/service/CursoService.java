package com.udemy.service;

import com.udemy.entity.Curso;

import java.util.List;

/**
 * Created by Guillermo Loyo on 18/05/2017.
 */
public interface CursoService {
    public abstract List<Curso> getAllCursos();
    public abstract Curso addCurso(Curso curso);
    public abstract int removeCurso(int id);
    public abstract Curso updateCurso(Curso curso);
}
