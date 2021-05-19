package sample;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcStuffTest {
    private final CalcStuff calc = new CalcStuff();
    @Test
    void evenMessage_test1() {
        assertEquals("Nr even = false", calc.evenMessage(1) );
    }

    @Test
    void evenMessage_test2() {
        assertEquals("Nr even = true", calc.evenMessage(2) );
    }

    @Test
    void addMessage_test1() {
        assertEquals("Nr + Nr = 2", calc.addMessage(1) );
    }

    @Test
    void subMessage_test1() {
        assertEquals("Nr - Nr = 0", calc.subMessage(1) );
    }

    @Test
    void negateMessage() {
        assertEquals("Nr negated = -1", calc.negateMessage(1) );
    }
}