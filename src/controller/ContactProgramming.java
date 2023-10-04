/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.Contact;
import responsitory.ContactResponsitory;
import view.Menu;

/**
 *
 * @author Nguyen Quang Hau
 */
public class ContactProgramming extends Menu<String> {

    private List<Contact> list = new ArrayList<>();
    private ContactResponsitory cr = new ContactResponsitory();

    public ContactProgramming() {
        super("Contact Program", new String[]{"Add a Contact", "Display all Contact", "Delete a Contact", "Exit"});
    }

    @Override
    public void excute(int n) {
        switch (n) {
            case 1:
                cr.addContact(list);
                break;
            case 2:
                cr.displayAll(list);
                break;
            case 3:
                cr.deleteContact(list);
                break;
        }
    }

}
