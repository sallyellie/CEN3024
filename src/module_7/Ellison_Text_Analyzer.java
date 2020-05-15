// Author Name: Sally Ellison
// Date: 5/15/20
// Program Name: Ellison_Text_Analyzer
// Purpose: Analyze text

package module_7;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Ellison_Text_Analyzer
{
    List<EllisonWordStat> statList = new ArrayList<>();

    public void analyzeFile(String pathToFile, boolean isAscending)
    {
        statList.clear();
        Map<String, Integer> statMap = new HashMap<>();
        String contents = readFile(pathToFile);
        StringTokenizer tokenizer = new StringTokenizer(contents.toString(), " ");
        
        while (tokenizer.hasMoreElements()) 
        {
            String word = tokenizer.nextToken();
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
        
        for (Map.Entry<String, Integer> entry : statMap.entrySet())
        {
            statList.add(new EllisonWordStat(entry.getKey(), entry.getValue()));
        }

        Collections.sort(statList);
        if (!isAscending)
        {
            Collections.reverse(statList);
        }
    }

    public List<EllisonWordStat> getResults()
    {
        return statList;
    }
    
    // Reads file and stores in contents
    private String readFile(String pathToFile)
    {        
        StringBuilder sb = new StringBuilder();
        try (FileReader fr = new FileReader(pathToFile))
        {
            int i; 
            while ((i = fr.read()) != -1) sb.append((char) i);
            
            return sb.toString().replace(".", " ").replace("!", " ")
                                .replace("?", " ").replace(",", " ")
                                .replace("\r", " ");  
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        return "";
    }
    
}
