// Author Name: Sally Ellison
// Date: 5/15/20
// Program Name: Ellison_Text_Analyzer
// Purpose: Analyze text

package module_7;

import java.io.File;
import java.util.List;

import javax.lang.model.util.ElementScanner6;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class EllisonTextAnalyzerController
{

    private final Stage stage;

    private final Button fileSelectButton;
    private final TextField currentSelectedTextField;
    private final Button analyzeButton;
    private final ToggleGroup descAscToggleGroup;
    private final ToggleGroup resultCountToggleGroup;
    private final TextArea resultsTextArea;
    
    private String pathToFile;

    private final Ellison_Text_Analyzer analyzer = new Ellison_Text_Analyzer();
    
    
    private final FileChooser fileChooser = new FileChooser();

    public EllisonTextAnalyzerController(final TextAnalyzerView textAnalyzerView, final Stage stage)
    {
        this.stage = stage;

        fileSelectButton = textAnalyzerView.getFileSelectButton();
        currentSelectedTextField = textAnalyzerView.getCurrentlySelectedFileTextField();
        analyzeButton = textAnalyzerView.getAnalyzeButton();
        descAscToggleGroup = textAnalyzerView.getDescAscToggleGroup();
        resultCountToggleGroup = textAnalyzerView.getResultCountToggleGroup();
        resultsTextArea = textAnalyzerView.getResultsTextArea();

        actionListeners();
    }
    
    public void actionListeners()
    {
        
        fileSelectButton.setOnMouseClicked(e -> 
        {
            final File file = fileChooser.showOpenDialog(stage);
            if (file != null) 
            {
                pathToFile = file.getAbsolutePath();
                currentSelectedTextField.setText(pathToFile);
            }
        });

        analyzeButton.setOnMouseClicked(e -> 
        {
            List<EllisonWordStat> statList;

            // Check if asc or desc
            final RadioButton selectedRadioButton = (RadioButton) descAscToggleGroup.getSelectedToggle();
            final String selectedRadioButtonText = selectedRadioButton.getText();
            if (selectedRadioButtonText.equals("Descending"))
            {
                analyzer.analyzeFile(pathToFile, false);
            }
            else
            {
                analyzer.analyzeFile(pathToFile, true);
            }

            statList = analyzer.getResults();

            List<EllisonWordStat> trimmedList;

            final RadioButton selectedResultCountRadioButton = (RadioButton) resultCountToggleGroup.getSelectedToggle();
            String selectResultCountText = selectedResultCountRadioButton.getText(); 
            if (selectResultCountText.equals("20"))
            {
                trimmedList = statList.subList(0, 20);
            }
            else
            {
                trimmedList = statList.subList(0, 100);
            }

            resultsTextArea.clear();
            for (EllisonWordStat wordStat : trimmedList)
            {
                resultsTextArea.appendText(wordStat.toString() + "\n");
            }

        });

    }
}

