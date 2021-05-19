package sample;

public class Calc extends CalcTemp {
    @Override
    int negate(int nr) {
        int returnNr;

        if (nr == 0) {
            return 0;
        }

        if (nr > 0) {
            returnNr = nr - (nr * 2);
            return returnNr;

        } else {
            returnNr = nr - (nr * 2);
            return returnNr;
        }
    }

    @Override
    public int add(int nr, int nr2) {
        return nr + nr2;
    }

    @Override
    public int sub(int nr, int nr2) {
        return nr - nr2;
    }

    public boolean isEven(int nr) {
        if (nr%2 > 0) {
            return false;
        }
        return true;
    }

}
