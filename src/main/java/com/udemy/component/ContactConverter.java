package com.udemy.component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import org.springframework.stereotype.Component;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillermo Loyo on 4/8/2017.
 */
@Component
public class ContactConverter {

    public Contact convertContactModelToContactEntity(ContactModel contactModel){
        Contact entity = new Contact();
        entity.setFirstname(contactModel.getFirstname());
        entity.setLastname(contactModel.getLastname());
        entity.setTelephone(contactModel.getTelephone());
        entity.setCity(contactModel.getCity());
        return entity;
    }

    public ContactModel covertContactEntityToContactModel(Contact contact){
       ContactModel model = new ContactModel();
       model.setFirstname(contact.getFirstname());
       model.setLastname(contact.getLastname());
       model.setTelephone(contact.getTelephone());
       model.setCity(contact.getCity());
       return model;
    }

    public List<Contact> covertListContactModelToListContact(List<ContactModel> models){
        List<Contact> entities = new ArrayList<Contact>();
        for (ContactModel model: models) {
            entities.add(convertContactModelToContactEntity(model));
        }
        return entities;
    }

    public List<ContactModel> convertListContactToListContactModel(List<Contact> entities){
        List<ContactModel> models = new ArrayList<ContactModel>();
        for (Contact entity: entities) {
            models.add(covertContactEntityToContactModel(entity));
        }
        return models;
    }
}
