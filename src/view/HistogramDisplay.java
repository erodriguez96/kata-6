package view;

import java.awt.Container;
import java.awt.Dimension;
import model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author eduardo
 */
public class HistogramDisplay<T> extends ApplicationFrame {

    private final Histogram<T> histogram;
    private final String ejeX;

    public HistogramDisplay(Histogram<T> histogram, String ejeX) {
        super("Histograma");
        this.ejeX = ejeX;
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }

    public void execute() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private Container createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Histograma JFreeChart",
                ejeX,
                "Nº de emails",
                dataset,
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return chart;
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        for (T key : histogram.keySet()) {
            dataSet.addValue(histogram.get(key), "", (Comparable) key);
        }
        return dataSet;
    }
}
