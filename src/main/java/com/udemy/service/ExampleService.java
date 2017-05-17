package com.udemy.service;

import com.udemy.repository.Persona;

import java.util.List;

/**
 * Created by Guillermo Loyo on 17/05/2017.
 */
public interface ExampleService {
    public abstract List<Persona> getListPeople();
}
