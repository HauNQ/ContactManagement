/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package responsitory;

import java.util.List;
import model.Contact;

/**
 *
 * @author Nguyen Quang Hau
 */
public interface IContactResponsitory {
   boolean addContact(List<Contact> list);
   public void displayAll(List< Contact > list);
   public boolean deleteContact(List<Contact> list);
}
