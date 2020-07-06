// Author Name: Sally Ellison
// Date: 7/5/20
// Program Name: Ellison_module8_unit_test
// Purpose: Analyze text through GUI

package module_10;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EllisonTextAnalyzerTest
{

    // Test that strings are properly analyzed with stats
    // sorted by ascending count order
    @Test
    public void stringAnalyzerTest_Asc()
    {
        String testString = "I wonder where Waldo is? Do you know? I do.";
        
        List<EllisonWordStat> exp = new ArrayList<>();
        
        exp.add(new EllisonWordStat("WALDO", 1));
        exp.add(new EllisonWordStat("WONDER", 1));
        exp.add(new EllisonWordStat("KNOW", 1));
        exp.add(new EllisonWordStat("IS", 1));
        exp.add(new EllisonWordStat("WHERE", 1));
        exp.add(new EllisonWordStat("YOU", 1));
        exp.add(new EllisonWordStat("I", 2));
        exp.add(new EllisonWordStat("DO", 2));
        
        EllisonTextAnalyzer eta = new EllisonTextAnalyzer();
        boolean isAscending = true;
        List<EllisonWordStat> act = eta.analyzeString(testString, isAscending);
        
        assertEquals(exp.size(), act.size());
        
        for (int i = 0; i < act.size(); i++)
        {
             assertEquals(exp.get(i).getWord(), act.get(i).getWord()); 
             assertEquals(exp.get(i).getFrequency(), act.get(i).getFrequency());
        }
    }
    
    // Test that strings are properly analyzed with stats
    // sorted by descending count order
    @Test
    public void stringAnalyzerTest_Desc()
    {
        String testString = "I wonder where Waldo is? Do you know? I do.";
        
        List<EllisonWordStat> exp = new ArrayList<>();
        
        exp.add(new EllisonWordStat("DO", 2));
        exp.add(new EllisonWordStat("I", 2));
        exp.add(new EllisonWordStat("YOU", 1));
        exp.add(new EllisonWordStat("WHERE", 1));
        exp.add(new EllisonWordStat("IS", 1));
        exp.add(new EllisonWordStat("KNOW", 1));
        exp.add(new EllisonWordStat("WONDER", 1));
        exp.add(new EllisonWordStat("WALDO", 1));
        
        EllisonTextAnalyzer eta = new EllisonTextAnalyzer();
        boolean isAscending = false;
        List<EllisonWordStat> act = eta.analyzeString(testString, isAscending);
        
        assertEquals(exp.size(), act.size());
        
        for (int i = 0; i < act.size(); i++)
        {
             assertEquals(exp.get(i).getWord(), act.get(i).getWord()); 
             assertEquals(exp.get(i).getFrequency(), act.get(i).getFrequency());
        }
    }

}
