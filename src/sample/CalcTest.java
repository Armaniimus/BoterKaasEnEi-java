package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    private final Calc calc = new Calc();
    @Test
    void negate_test1() {
        assertEquals(-1, calc.negate(1) );
    }

    @Test
    void negate_test2() {
        assertEquals(2, calc.negate(-2) );
    }

    @Test
    void negate_test3() {
        assertEquals(0, calc.negate(0) );
    }

    @Test
    void add_test1() {
        assertEquals(2, calc.add(1, 1) );
    }

    @Test
    void add_test2() {
        assertEquals(10, calc.add(1, 9) );
    }

    @Test
    void sub_test1() {
        assertEquals(0, calc.sub(1, 1) );
    }

    @Test
    void sub_test2() {
        assertEquals(-9, calc.sub(0, 9) );
    }

    @Test
    void isEven_test1() {
        assertEquals(false, calc.isEven(1) );
    }

    @Test
    void isEven_test2() {
        assertEquals(true, calc.isEven(0) );
    }

    @Test
    void isEven_test3() {
        assertEquals(false, calc.isEven(159) );
    }

    @Test
    void isEven_test4() {
        assertEquals(true, calc.isEven(200) );
    }
}