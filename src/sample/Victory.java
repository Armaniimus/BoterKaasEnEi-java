package sample;

import java.lang.reflect.Array;

public class Victory {
    private Board Board;
    private Players Players;

    public Victory(Board Board, Players Players) {
        this.Board = Board;
        this.Players = Players;
    }

    public boolean CheckVictory(int ID) {
        int[] cross1 = {1,5,9};
        int[] cross2 = {3,5,7};
        int x;
        int y;


        BoardField field = this.Board.getField(ID);
        x = field.get_xPos();
        y = field.get_yPos();

        if ( checkX(y) ) {
            return true;

        } else if ( checkY(x)) {
            return true;

        } else if ( checkCross(ID, cross1) ) {
            return true;

        } else if ( checkCross(ID, cross2) ) {
            return true;
        }

        return false;
    }

    private boolean checkX( int y) {
        int playerID = this.Players.getPlayer();
        for (int x=0; x<3; x++) {
            if ( this.Board.getFieldValue(x,y) !=  playerID ) {
                return false;
            }
        }

        return true;
    }

    private boolean checkY(int x) {
        int playerID = this.Players.getPlayer();
        for (int y=0; y<3; y++) {
            if ( this.Board.getField(x,y).getValue() != playerID ) {
                return false;
            }
        }

        return true;
    }

    private boolean checkCross(int ID, int[] cross) {
        int playerID = this.Players.getPlayer();
        if (ID != cross[0] && ID != cross[1] && ID != cross[2]) {
            return false;
        }

        for (int i=0; i<3; i++) {
            int nr = cross[i];
            if (this.Board.getField(nr).getValue() != playerID ) {
                return false;
            }
        }

        return true;
    }
}
