// Author Name: Sally Ellison
// Date: 5/15/20
// Program Name: Ellison_Text_Analyzer
// Purpose: Analyze text

package module_7;

import java.util.Arrays;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class TextAnalyzerView extends BorderPane
{
    private VBox mainTopLayoutVbox = new VBox();
    
    private HBox titleHBox = new HBox();
    private Label titleLabel = new Label("Ellison Text Analyzer");
    
    private AnchorPane fileSelectAnchorPane = new AnchorPane();
    private Button fileSelectButton = new Button();
    private TextField currentlySelectedFileTextField = new TextField();
    
    private AnchorPane analyzeAndOptionsAnchorPane = new AnchorPane();
    
    private Button analyzeButton = new Button("Analyze");
    
    private VBox optionsVBox = new VBox();
    private HBox countOptionsHBox = new HBox();
    private ToggleGroup resultCountToggleGroup = new ToggleGroup();
    private Label descriptionLabel = new Label("Number of results to display:");
    private RadioButton radioButtonOption1 = new RadioButton();
    private RadioButton radioButtonOption2 = new RadioButton();
    
    private HBox ascDescHBox = new HBox();
    private RadioButton descRadioButton = new RadioButton("Descending");
    private RadioButton ascRadioButton = new RadioButton("Ascending");
    private ToggleGroup descAscToggleGroup = new ToggleGroup();

    private TextArea resultsTextArea = new TextArea();
    
    public TextAnalyzerView()
    {
        setupUI();
    }
    
    public void setupUI()
    {   
        this.setTop(mainTopLayoutVbox);
        this.setCenter(resultsTextArea);
        mainTopLayoutVbox.getChildren().addAll(Arrays.asList(titleHBox, fileSelectAnchorPane, analyzeAndOptionsAnchorPane));

        titleLabel.setText("Ellison Text Analyzer");
        titleLabel.setFont(Font.font(50.0));
        titleHBox.getChildren().add(titleLabel);
        titleHBox.setAlignment(Pos.CENTER);

        fileSelectAnchorPane.getChildren().addAll(Arrays.asList(fileSelectButton, currentlySelectedFileTextField));
        fileSelectAnchorPane.setMinHeight(30.0);

        AnchorPane.setTopAnchor(fileSelectButton, 10.0);
        AnchorPane.setBottomAnchor(fileSelectButton, 10.0);
        AnchorPane.setLeftAnchor(fileSelectButton, 10.0);

        AnchorPane.setLeftAnchor(currentlySelectedFileTextField, 100.0);
        AnchorPane.setRightAnchor(currentlySelectedFileTextField, 10.0);
        AnchorPane.setTopAnchor(currentlySelectedFileTextField, 10.0);
        AnchorPane.setBottomAnchor(currentlySelectedFileTextField, 10.0);

        fileSelectButton.setText("Select File");
        currentlySelectedFileTextField.setPromptText("Click \"Select File\" button to choose a file to analyze");
        currentlySelectedFileTextField.setEditable(false);

        analyzeAndOptionsAnchorPane.getChildren().addAll(Arrays.asList(analyzeButton, optionsVBox));

        AnchorPane.setLeftAnchor(analyzeButton, 10.0);
        AnchorPane.setTopAnchor(analyzeButton, 10.0);
        AnchorPane.setBottomAnchor(analyzeButton, 10.0);

        AnchorPane.setRightAnchor(optionsVBox, 100.0);
        optionsVBox.setAlignment(Pos.CENTER);
        optionsVBox.getChildren().addAll(countOptionsHBox, ascDescHBox);

        countOptionsHBox.getChildren().addAll(Arrays.asList(descriptionLabel, radioButtonOption1, radioButtonOption2));
        countOptionsHBox.setSpacing(10.0);

        ascDescHBox.getChildren().addAll(Arrays.asList(descRadioButton, ascRadioButton));
        ascDescHBox.setSpacing(10.0);
        descRadioButton.setToggleGroup(descAscToggleGroup);
        ascRadioButton.setToggleGroup(descAscToggleGroup);
        descAscToggleGroup.selectToggle(descRadioButton);
                

        radioButtonOption1.setToggleGroup(resultCountToggleGroup);
        radioButtonOption1.setText("20");
        radioButtonOption2.setToggleGroup(resultCountToggleGroup);
        radioButtonOption2.setText("100");
        resultCountToggleGroup.selectToggle(radioButtonOption1);


    }

    public Button getFileSelectButton()
    {
        return fileSelectButton;
    }

    public TextField getCurrentlySelectedFileTextField()
    {
        return currentlySelectedFileTextField;
    }

    public Button getAnalyzeButton()
    {
        return analyzeButton;
    }

    public ToggleGroup getDescAscToggleGroup()
    {
        return descAscToggleGroup;
    }

    public ToggleGroup getResultCountToggleGroup()
    {
        return resultCountToggleGroup;
    }

    public TextArea getResultsTextArea()
    {
        return resultsTextArea;
    }



}

