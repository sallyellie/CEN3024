// Author Name: Sally Ellison
// Date: 5/15/20
// Program Name: Ellison_Text_Analyzer
// Purpose: Analyze text through GUI

package module_10;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EllisonTextAnalyzerApp extends Application
{

    public static void main(String args[])
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception
    {
        EllisonTextAnalyzerView textAnalyzerView = new EllisonTextAnalyzerView();
        EllisonTextAnalyzerController textAnalyzerController = new EllisonTextAnalyzerController(textAnalyzerView, stage);

        // create a scene
        Scene scene = new Scene(textAnalyzerView, 900, 650);

        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();

    }

}