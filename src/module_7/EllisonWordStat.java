// Author Name: Sally Ellison
// Date: 5/15/20
// Program Name: Ellison_Text_Analyzer
// Purpose: Analyze text

package module_7;

public class EllisonWordStat implements Comparable<EllisonWordStat>
{
    private String word;
    private int frequency;
    
    public EllisonWordStat(String word, int frequency)
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
    public int compareTo(EllisonWordStat o)
    {
        return this.frequency - o.frequency; 
    }

    @Override
    public String toString()
    {
        return word + " : " + frequency;
    }
}