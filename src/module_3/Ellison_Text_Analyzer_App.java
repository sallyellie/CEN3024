// Author Name: Sally Ellison
// Date: 5/14/20
// Program Name: Ellison_Text_Analyzer
// Purpose: Analyze text

package module_3;

public class Ellison_Text_Analyzer_App
{

    public static void main(String[] args)
    {
        String pathToFile = "/Users/theking/Development/CEN3024/res/The Tragedy of Macbeth.txt";
        Ellison_Text_Analyzer ta = new Ellison_Text_Analyzer();
        ta.analyzeFile(pathToFile);
        ta.print();
    }

}
