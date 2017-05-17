package com.udemy.service.impl;

import com.udemy.repository.Persona;
import com.udemy.service.ExampleService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillermo Loyo on 17/05/2017.
 */
@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {

    public static final Log LOG = LogFactory.getLog(ExampleServiceImpl.class);
    @Override
    public List<Persona> getListPeople() {
        List<Persona> people = new ArrayList<>();
        people.add(new Persona("David", 25));
        people.add(new Persona("Guillermo", 22));
        people.add(new Persona("Federico", 28));
        people.add(new Persona("Luisa", 22));
        LOG.info("HOLA DESDE SERVICE");
        return people;
    }
}
