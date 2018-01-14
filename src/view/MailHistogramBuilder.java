package view;

import controller.Attribute;
import java.util.List;
import model.Histogram;
import model.Mail;

/**
 *
 * @author eduardo
 */
public class MailHistogramBuilder<T> {

    private final List<T> items;

    public MailHistogramBuilder(List<T> items) {
        this.items = items;
    }

    public <A> Histogram<A> build(Attribute<T, A> attribute) {
        Histogram<A> histo = new Histogram<>();
        for (T item : items) {
            A value = attribute.get(item);
            histo.increment(value);
        }
        return histo;
    }
}

