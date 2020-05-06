package testing.number;

import algorithm.numericalProblem.NumberMultiplication;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author : Nguyen Trong TRUNG
 */
public class NumberMultiplicationTest {
    @Test
    public void checkRussianPeasantMultiplication(){
        long actual = NumberMultiplication.RussianPeasantMethod(50,65);
        long expected = 3250;
        Assertions.assertEquals(expected,actual);
    }

}