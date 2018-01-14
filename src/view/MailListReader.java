/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Mail;

/**
 *
 * @author eduardo
 */
public class MailListReader {

    public static List read(String fileName) throws FileNotFoundException, IOException {
        List<Mail> mailList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        String mail;
        Integer id = 0;
        while ((mail = reader.readLine()) != null) {
            if (!mail.contains("@")) continue;
            mailList.add(new Mail(id, mail));
        }
        reader.close();
        return mailList;
    }
}
