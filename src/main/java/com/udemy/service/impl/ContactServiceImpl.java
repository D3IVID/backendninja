package com.udemy.service.impl;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Guillermo Loyo on 4/8/2017.
 */
@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    ContactConverter contactConverter;

    @Override
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.convertContactModelToContactEntity(contactModel));
        return contactConverter.covertContactEntityToContactModel(contact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        return contactConverter.convertListContactToListContactModel(contactRepository.findAll());
    }
}
