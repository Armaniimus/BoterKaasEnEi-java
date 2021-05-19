package sample;

public class CpuOpponent extends Victory {
    private boolean active;
    private Board Board;
    private Players Players;

    public CpuOpponent(Board Board, Players Players) {
        super(Board, Players);
        this.Board = Board;
        this.Players = Players;
    }

    public void init() {
        if (!this.Players.getCpu()) {
            this.active = false;
            return;
        }
        this.active = true;
    }

    public int play() {
        if (!active) {
            return -1;
        }

        int middleMove = this.captureMiddle();
        if (middleMove > 0) { return middleMove; }

        int horMove = this.horizontalMoves();
        if (horMove > 0) { return horMove; }

        int vertMove = this.verticalMoves();
        if (vertMove > 0) { return vertMove; }

        int crossMove = this.crossMoves();
        if (crossMove > 0) { return crossMove; }

        int otherMove = this.otherMoves();
        if (otherMove > 0) { return otherMove; }

        return -1;
    }

    private int captureMiddle() {
        if ( this.emptyField(5) ) {
            return(5);
        }

        return -1;
    }

    private int horizontalMoves() {
        //horizontal1
        if ( emptyField(1) && sameField(2,3)) {
            return 1;
        } else if ( emptyField(2) && sameField(1,3) ) {
            return 2;
        } else if ( emptyField(3) && sameField(1,2) ) {
            return 3;

        //horizontal2
        } else if ( emptyField(4) && sameField(5,6 )) {
            return 4;
        } else if ( emptyField(5) && sameField(4,6)) {
            return 5;
        } else if ( emptyField(6) && sameField(4,5)) {
            return 6;

        //horizontal3
        } else if ( emptyField(7) && sameField(8,9) ) {
            return 7;
        } else if ( emptyField(8) && sameField(7,9) ) {
            return 8;
        } else if ( emptyField(9) && sameField(7,8) ) {
            return 9;
        }

        return -1;
    }

    private int verticalMoves() {
        //vertical1
        if ( emptyField(1) && sameField(4,7) ) {
            return 1;
        } else if ( emptyField(4) && sameField(1,7) ) {
            return 4;
        } else if ( emptyField(7) && sameField(1,4) ) {
            return 7;

        //vertical2
        } else if (emptyField(2) && sameField(5,8) ) {
            return 2;
        } else if (emptyField(5) && sameField(2,8) ) {
            return 5;
        } else if (emptyField(8) && sameField(2,5) ) {
            return 8;

        //vertical3
        } else if ( emptyField(3) && sameField(6,9)) {
            return 3;
        } else if ( emptyField(6) && sameField(3,9)) {
            return 6;
        } else if ( emptyField(9) && sameField(3,6)) {
            return 9;
        }

        return -1;
    }


    private int crossMoves() {
        //makes sure the \\ diagonalrow isn't captured
        if (this.emptyField(1) && this.sameField(5,9) ) {
            return(1);
        } else if (this.emptyField(5) && this.sameField(1,9) ) {
            return(5);
        } else if (this.emptyField(9) && this.sameField(1,5) ) {
            return(9);

        //makes sure the // diagonalrow isn't captured
        } else if (this.emptyField(3) && this.sameField(5,7) ) {
            return(3);
        } else if (this.emptyField(5) && this.sameField(3,7) ) {
            return(5);
        } else if (this.emptyField(7) && this.sameField(3,5) ) {
            return(7);
        }

        return -1;
    }

    private int otherMoves() {
        //counterMoves
        if (this.hostileField(1) && this.emptyField(9) ) {
            return 9;
        } else if (this.hostileField(3) && this.emptyField(7) ) {
            return 7;
        } else if (this.hostileField(7) && this.emptyField(3) ) {
            return 3;
        } else if (this.hostileField(9) && this.emptyField(1) ) {
            return 1;

        // playout moves
        } else if ( this.emptyField(1) ) {
            return 1;
        } else if ( this.emptyField(2) ) {
            return 2;
        } else if ( this.emptyField(3) ) {
            return 3;
        } else if ( this.emptyField(4) ) {
            return 4;
        } else if ( this.emptyField(6) ) {
            return 6;
        } else if ( this.emptyField(7) ) {
            return 7;
        } else if ( this.emptyField(8) ) {
            return 8;
        } else if ( this.emptyField(9) ) {
            return 9;
        }
        return -1;
    }


    private int getField(int ID) {
       return this.Board.getField(ID).getValue();
    }

    private boolean hostileField(int ID) {
        if ( this.Board.getField(ID).getValue() == 1) {
            return true;
        }
        return false;
    }

    private boolean emptyField(int ID) {
        if ( this.Board.getField(ID).getValue() == 0) {
            return true;
        }
        return false;
    }

    private boolean sameField(int ID1, int ID2) {
        int fieldVal1 = this.Board.getField(ID1).getValue();
        int fieldVal2= this.Board.getField(ID2).getValue();

        if ( fieldVal1 == fieldVal2) {
            return true;
        }
        return false;
    }

    public boolean getActive() {
        return active;
    }

    public void kill() {
        this.active = false;
    }
}
