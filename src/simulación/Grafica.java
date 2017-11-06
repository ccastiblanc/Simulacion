package simulación;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Grafica {

    ArrayList<Integer> prueba = new ArrayList<>();

    public void Grafica_Intentos(ArrayList<Integer> puntos) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i = 0; i < puntos.size(); i++) {
            data.addValue(puntos.get(i), "intento", "" + (i + 1));

        }
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Gráfica intentos random",
                "Intentos", "Semilla",
                data,
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel contenedor = new ChartPanel(lineChart);
        JFrame ventana = new JFrame("Graficas en java");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(600, 600);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }
    public void Grafica_Puntos(ArrayList<Integer> semilla,ArrayList<Double> puntos) {
        DefaultCategoryDataset data = new DefaultCategoryDataset();
        for (int i = 0; i < semilla.size(); i++) {
            data.addValue(puntos.get(i), "intento", "" + semilla.get(i));

        }
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Gráfica Diferencias de pi",
                "Semilla", "diferencia entre Pi",
                data,
                PlotOrientation.VERTICAL,
                true, true, false);
        ChartPanel contenedor = new ChartPanel(lineChart);
        JFrame ventana = new JFrame("Graficas en java");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(contenedor);
        ventana.setSize(600, 400);
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }

}
