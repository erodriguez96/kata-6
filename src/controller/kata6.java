package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import model.Histogram;
import model.Mail;
import model.Person;
import view.DataBaseList;
import view.HistogramDisplay;
import view.MailHistogramBuilder;
import view.MailListReader;
/**
 *
 * @author eduardo
 */
public class kata6 {
    private List<Mail> mailList;
    private MailHistogramBuilder<Mail> builder;
    private MailHistogramBuilder<Person> builderPerson;
    private Histogram<String> domains;
    private Histogram<Character> letters, gender;
    private Histogram<Float> weight;

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        new kata6().execute();
    }

    public void execute() throws IOException, ClassNotFoundException, SQLException {
        input();
        process();
        output();
    }

    private void input() throws IOException {
        String filname = "emails.txt";
        mailList = MailListReader.read(filname);
    }

    private void process() throws ClassNotFoundException, SQLException {
        builder = new MailHistogramBuilder<>(mailList);
        domains = builder.build((Mail item) -> item.getMail().split("@")[1]);
        letters = builder.build((Mail item) -> item.getMail().charAt(0));

        List<Person> people = DataBaseList.read();
        builderPerson = new MailHistogramBuilder<>(people);
        gender = builderPerson.build((Person item) -> item.getGender());
        weight = builderPerson.build((Person item) -> item.getWeight());
    }

    private void output() {
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay(letters, "Primer Caracter").execute();
        new HistogramDisplay(gender, "Gender").execute();
        new HistogramDisplay(weight, "Weight").execute();
    }
}
