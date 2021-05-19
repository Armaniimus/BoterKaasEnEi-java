package sample;

public class Players {
    private int player;
    private String icon;
    private boolean cpu;

    public void init(boolean cpu) {
        this.cpu = cpu;
        this.player = 1;
        this.icon = "O";
    }

    public void swap() {
        if (this.player == 1) {
            this.player = 2;
        } else {
            this.player = 1;
        }

        if (this.icon == "X") {
            this.icon = "O";
        } else {
            this.icon = "X";
        }
    }

    public int getPlayer() {
        return player;
    }

    public String getIcon() {
        return icon;
    }

    public boolean getCpu() {
        return cpu;
    }
}
