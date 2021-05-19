package sample;

public class BoardField {
    private byte ID;
    private int value = 0;
    private byte xPos;
    private byte yPos;

    public BoardField(byte ID) {
        this.ID = ID;

        if (this.ID == 0) {
            this.xPos = -1;
            this.yPos = -1;
        }

        if (this.ID == 1 || this.ID == 4 || this.ID == 7) {
            this.xPos = 0;
        } else if(this.ID == 2 || this.ID == 5 || this.ID == 8) {
            this.xPos = 1;
        } else {
            this.xPos = 2;
        }

        if (this.ID == 1 || this.ID == 2 || this.ID == 3) {
            this.yPos = 0;
        }  else if(this.ID == 4 || this.ID == 5 || this.ID == 6) {
            this.yPos = 1;
        } else {
            this.yPos = 2;
        }
    }

    public byte getID() {
        return ID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public byte get_xPos() {
        return xPos;
    }

    public byte get_yPos() {
        return yPos;
    }
}
