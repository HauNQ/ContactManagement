/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsitory;

import DAO.ContactDAO;
import common.Validation;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import model.Contact;

/**
 *
 * @author Nguyen Quang Hau
 */
public class ContactResponsitory implements IContactResponsitory {

    private Validation val = new Validation();

    @Override
    public boolean addContact(List<Contact> list) {
        try {
            ContactDAO.getInstance().add(list);
            System.out.println("Added");
        } catch (Exception e) {
            System.out.println("Adding failure");
            return false;
        }

        return true;
    }

    @Override
    public void displayAll(List<Contact> list) {
        System.out.printf("%-5s%-15s%-15s%-15s%-10s%-15s%-15s\n", "ID", "Name", "FirstName", "LastName", "Group", "Address", "Phone");
        for (Contact contact : list) {
            System.out.printf("%-5s%-15s%-15s%-15s%-10s%-15s%-15s\n", contact.getId(), contact.getFullName(), contact.getFristName(), contact.getLastName(), contact.getGroup(), contact.getAddress(), contact.getPhone());
        }
    }

    @Override
    public boolean deleteContact(List<Contact> list) {
        try {
            int id = val.getIntData("Enter contact id: ", 1);
            if (ContactDAO.getInstance().delete(list, id)) {
                System.out.println("Deleted");
            }else{
                System.out.println("The ID does not exist");
            }
        } catch (Exception e) {
            System.out.println("Not Deleted");
            return false;
        }

        return true;
    }

}
