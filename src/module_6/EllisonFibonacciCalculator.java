// Author Name: Sally Ellison
// Date: 5/25/20
// Program Name: EllisonFibonacciCalculator
// Purpose: Demonstrate difference between recursion
//          and iteration in time complexity when
//          calculating the fibonacci sequence 

package module_6;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class EllisonFibonacciCalculator extends Application
{

    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Recursive vs Iterative Fibonacci");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Nth Element");
        yAxis.setLabel("Time in Nanoseconds");
        
        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis, yAxis);
                
        lineChart.setTitle("Recursive vs Iterative Fibonacci");
        
        //defining a series
        XYChart.Series iterativeSeries = new XYChart.Series();
        iterativeSeries.setName("Iterative");
        XYChart.Series recursiveSeries = new XYChart.Series();
        recursiveSeries.setName("Recursive");
        
        for (int i  = 1; i <= 10; i++)
        {
          long startTime = System.nanoTime();
          fibonacciLoop(i);
          long endTime = System.nanoTime();
          long totalTimeIterativeNanoSeconds = endTime - startTime;
          // Add data iterative data point to chart
          iterativeSeries.getData().add(new XYChart.Data(i, totalTimeIterativeNanoSeconds));
          
          startTime = System.nanoTime();
          fibonacciRecursion(i);
          endTime = System.nanoTime();
          long totalTimeRecursiveNanoSeconds = endTime - startTime;
          
          // Add recursion data point to chart
          recursiveSeries.getData().add(new XYChart.Data(i, totalTimeRecursiveNanoSeconds));
        }
        
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(iterativeSeries);
        lineChart.getData().add(recursiveSeries);
       
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String args[])
    {
        launch(args);
    }


    public static int fibonacciLoop(int nthNumber)
    {
        // use loop
        int previouspreviousNumber, previousNumber = 0, currentNumber = 1;

        for (int i = 1; i < nthNumber; i++)
        {

            previouspreviousNumber = previousNumber;

            previousNumber = currentNumber;

            currentNumber = previouspreviousNumber + previousNumber;

        }
        return currentNumber;
    }

    public static int fibonacciRecursion(int nthNumber)
    {
        // use recursion
        if (nthNumber == 0)
        {
            return 0;

        } else if (nthNumber == 1)
        {

            return 1;
        }
        return fibonacciRecursion(nthNumber - 1) + fibonacciRecursion(nthNumber - 2);
    }

}
