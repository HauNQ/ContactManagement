/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import common.Validation;
import java.util.List;
import java.util.regex.Pattern;
import model.Contact;

/**
 *
 * @author Nguyen Quang Hau
 */
public class ContactDAO {

    private static ContactDAO instance = null;
    private Validation val = new Validation();

    public static ContactDAO getInstance() {
        if (instance == null) {
            synchronized (ContactDAO.class) {
                if (instance == null) {
                    instance = new ContactDAO();
                }
            }
        }
        return instance;
    }

    public void add(List<Contact> list) {
        int id;
        if (list.isEmpty()) {
            id = 1;
        } else {
            id = list.get(list.size() - 1).getId() + 1;
        }

        String fullName = val.getString("Enter Name: ").trim().replaceAll("\\s", " ");
        String group = val.getString("Enter Group: ");
        String address = val.getString("Enter Address: ");
        String phone = getPhone();
        list.add(new Contact(id, fullName, group, address, phone));
    }

    private String getPhone() {
        String phone = "";

        while (true) {
            phone = val.getString("Enter phone: ");
//            Pattern p1 = Pattern.compile("^\\d{10}$");
//            Pattern p2 = Pattern.compile("^\\d{3}-\\d{3}-\\d{4}$");
//            Pattern p3 = Pattern.compile("^\\d{3}.\\d{3}.\\d{4}$");
//            Pattern p4 = Pattern.compile("^\\d{3} \\d{3} \\d{4}$");
//            Pattern p5 = Pattern.compile("^\\d{3}-\\d{3}-\\d{4} (x|ext)\\d{4}$");
//            Pattern p6 = Pattern.compile("^\\(\\d{3}\\)-\\d{3}-\\d{4}$");
           
            Pattern p = Pattern.compile("(^\\(\\d{3}\\)-\\d{3}-\\d{4}$|^\\d{10}$|^\\d{3}-\\d{3}-\\d{4}$|^\\d{3}.\\d{3}.\\d{4}$|^\\d{3} \\d{3} \\d{4}$|^\\d{3}-\\d{3}-\\d{4} (x|ext)\\d{4}$)");

            if (p.matcher(phone).find()) {
                break;
            } else {
                System.out.println("""
                                   Please input Phone following the formats: 
                                   \u2022 1234567890
                                   \u2022 123-456-7890 
                                   \u2022 123-456-7890 x1234
                                   \u2022 123-456-7890 ext1234
                                   \u2022 (123)-456-7890
                                   \u2022 123.456.7890
                                   \u2022 123 456 7890""");
            }
        }

        return phone;
    }

    public boolean delete(List<Contact> list, int id) {
        return list.removeIf(contact -> contact.getId() == id);
    }
}
