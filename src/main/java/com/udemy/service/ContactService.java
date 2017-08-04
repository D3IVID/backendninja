package com.udemy.service;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

import java.util.List;

/**
 * Created by Guillermo Loyo on 4/8/2017.
 */
public interface ContactService {
    public abstract  ContactModel addContact(ContactModel contactModel);
    public abstract List<ContactModel> listAllContacts();
}
