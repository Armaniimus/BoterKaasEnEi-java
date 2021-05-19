package sample;

import java.util.ArrayList;

public class CalcStuff extends Calc {
    public void testNr(int nr) {
        System.out.println("Start Novi Assignment extra methods");

        System.out.println(this.evenMessage(nr));
        System.out.println(this.addMessage(nr));
        System.out.println(this.subMessage(nr));
        System.out.println(this.negateMessage(nr));

        try {
            ArrayList<Board> nr2 = new ArrayList<Board>();
            nr2.get(9);
        } catch(Exception e) {
            System.out.println("exception ran");
        }

        System.out.println("Continue normal program");
    };

    public String evenMessage(int nr) {
        return "Nr even = "      + this.isEven(nr);
    }

    public String addMessage(int nr) {
        return "Nr + Nr = "     + this.add(nr, nr);
    }

    public String subMessage(int nr) {
        return "Nr - Nr = "     + this.sub(nr, nr);
    }

    public String negateMessage(int nr) {
        return "Nr negated = "  + this.negate(nr);
    }
}
