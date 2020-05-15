// Author Name: Sally Ellison
// Date: 5/14/20
// Program Name: Ellison_Text_Analyzer
// Purpose: Analyze text

package module_3;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Ellison_Text_Analyzer
{
    private List<WordStat> wordStatSet = new ArrayList<>();
    
    public void analyzeFile(String pathToFile)
    {
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
            wordStatSet.add(new WordStat(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(wordStatSet);
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
    
    public void print()
    {   
        for (int i = wordStatSet.size() - 1; i >= wordStatSet.size() - 20; i--)
        {
            WordStat stat = wordStatSet.get(i);
            System.out.println(stat.getWord() + " : " + stat.getFrequency());
        }
    }
}

class WordStat implements Comparable<WordStat>
{
    private String word;
    private int frequency;
    
    public WordStat(String word, int frequency)
    {
        this.word = word;
        this.frequency = frequency;
    }
    
    public String getWord()
    {
        return word;
    }
    
    public int getFrequency()
    {
        return frequency;
    }
    
    @Override
    public int compareTo(WordStat o)
    {
        return this.frequency - o.frequency; 
    }
}
