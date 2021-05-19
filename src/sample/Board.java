package sample;

import java.util.ArrayList;

public class Board {
    private BoardField[][] BoardFields = new BoardField[3][3];
    private ArrayList<BoardField> BoardFieldsArrayList = new ArrayList<BoardField>();

    public Board() {
        for (Byte ID = 0; ID<=9; ID++) {
            BoardFieldsArrayList.add(ID, new BoardField(ID));
        }
        BoardFields[0][0] = BoardFieldsArrayList.get(1);
        BoardFields[1][0] = BoardFieldsArrayList.get(2);
        BoardFields[2][0] = BoardFieldsArrayList.get(3);

        BoardFields[0][1] = BoardFieldsArrayList.get(4);
        BoardFields[1][1] = BoardFieldsArrayList.get(5);
        BoardFields[2][1] = BoardFieldsArrayList.get(6);

        BoardFields[0][2] = BoardFieldsArrayList.get(7);
        BoardFields[1][2] = BoardFieldsArrayList.get(8);
        BoardFields[2][2] = BoardFieldsArrayList.get(9);
    }

    public void reset() {
        for (byte i=1; i<=9; i++) {
            BoardFieldsArrayList.get(i).setValue(0);
        }
    }

    public BoardField getField(int ID) {
        return BoardFieldsArrayList.get(ID);
    }

    public BoardField getField(int x, int y) {
        return BoardFields[x][y];
    }

    public int getFieldValue(int ID) {
        return BoardFieldsArrayList.get(ID).getValue();
    }

    public int getFieldValue(int x, int y) {
        return BoardFields[x][y].getValue();
    }
}
