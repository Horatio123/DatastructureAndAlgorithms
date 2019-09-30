package baimahu;

import static baimahu.ED.findEditDistance;
import static baimahu.LPS.findLPS;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AlgorithmsTest
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void testEditDistance()
    {
        String str1 = "CART";
        String str2 = "MARCH";
        assertEquals(findEditDistance(str1, str2), 3);
    }

    @Test
    public void testLongCommonSeq()
    {
        LCS lcs = new LCS();
        String str1 = "GXTXAYB";
        String str2 = "AGGTAB";
        //String str1 = "GX";
        //String str2 = "X";
        //System.out.println(lcs.findLCS(str1, str2));
        assertEquals(lcs.findLCS(str1, str2), 4);
    }

    @Test
    public void testLongPalindromeSeq()
    {
        String str = "BABCBAB";
        String str2 = "BABC";
        assertEquals(findLPS(str), 7);
        assertEquals(findLPS(str2), 3);

    }
}
