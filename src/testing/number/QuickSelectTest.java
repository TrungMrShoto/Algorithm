package algorithm.numericalProblem;

import algorithm.ErrorMessage;
import algorithm.searching.QuickSelect;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * @author : Nguyen Trong TRUNG
 */
public class QuickSelectTest {
    @Test
    public void checkFindingMedian(){
        int[] array = {4,1,10,8,7,12,9,2,15};
        int expected = 8;
        QuickSelect select = new QuickSelect();
        int actual = select.searchKthSmallestValue(array,5);
        Assertions.assertEquals(actual,expected);
    }

    @Test
    public void checkError1(){
        int[] array = {4,1,10,8,7,12,9,2,15};
        int expected = ErrorMessage.WRONG_POSITION;
        QuickSelect select = new QuickSelect();
        int actual = select.searchKthSmallestValue(array,-1);
        Assertions.assertEquals(actual,expected);
    }
    @Test
    public void checkError2(){
        int[] array = {4,1,10,8,7,12,9,2,15};
        int expected = ErrorMessage.WRONG_POSITION;
        QuickSelect select = new QuickSelect();
        int actual = select.searchKthSmallestValue(array,array.length+1);
        Assertions.assertEquals(actual,expected);
    }

}