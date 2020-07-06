// Author Name: Sally Ellison
// Date: 5/15/20
// Program Name: Ellison_Text_Analyzer
// Purpose: Analyze text through GUI

package module_10;
 
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class EllisonTextAnalyzer
{
    List<EllisonWordStat> statList = new ArrayList<>();
    
    /**
     * Returns a list of EllisonWordStat objects
     * 
     * @param contents       The string to analyze
     * @param isAscending    Order in descending or ascending order
     * @return A list of ordered word occurrence statistics
     */
    public List<EllisonWordStat> analyzeString(String contents, boolean isAscending)
    {
        contents = removeExtraneousCharacters(contents);
        // Clear old stats from list
        statList.clear();
        Map<String, Integer> statMap = new HashMap<>();
        StringTokenizer tokenizer = new StringTokenizer(contents.toString(), " ");
        
        // Loop over each word and add it to the map. If the word
        // already exists in the map, increment its frequency. If it doesn't,
        // add it to the map and set its frequency to 1
        while (tokenizer.hasMoreElements()) 
        {
            String word = tokenizer.nextToken().toUpperCase();
            if (statMap.containsKey(word))
            {
                Integer freq = statMap.get(word) + 1;
                statMap.put(word, freq);
            }
            else
            {
                statMap.put(word, 1);
            }
        }
        
        // Generate EllisonWordStat objects and add them to a list
        for (Map.Entry<String, Integer> entry : statMap.entrySet())
        {
            statList.add(new EllisonWordStat(entry.getKey(), entry.getValue()));
        }
        
        // Sort ascending
        Collections.sort(statList);
        
        // Reverse the list if descending list is desired
        if (!isAscending)
        {
            Collections.reverse(statList);
        }
        
        return statList;
    }

    /**
     * Returns a list of EllisonWordStat objects based off contents
     * of file
     * 
     * @param pathToFile    Path to file to be read
     * @param isAscending   Order in descending or ascending order
     * @return A list of ordered word occurrence statistics
     */
    public List<EllisonWordStat> analyzeFile(String pathToFile, boolean isAscending)
    {
        String contents = readFile(pathToFile);
        return analyzeString(contents, isAscending);
    }
    
    private String removeExtraneousCharacters(String content)
    {
        return content.replace(".", " ")
                .replace("!", " ")
                .replace("?", "")
                .replace(",", " ")
                .replace("\r", " ")
                .replace("\"", " ")
                .replace(";", " ")
                .replace(":", " ")
                .replace("&", " ");
    }
    
    /**
     * Reads a file and returns its contents
     * 
     * @param pathToFile    Path to the file to be read
     * @return    Contents of the file
     */
    private String readFile(String pathToFile)
    { 
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(pathToFile))
        {
            int i; 
            while ((i = fr.read()) != -1) sb.append((char) i);
            
            return sb.toString();  
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return "";
    }
    
}
