package com.udemy.repository;

import com.udemy.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Guillermo Loyo on 4/8/2017.
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact,Serializable>{

}
