package sample;

public class Game {
    private Console Console;
    private Board Board;
    private Players Players;
    private Victory Victory;

    private CpuOpponent CpuOpponent;
    private boolean active;
    private int currentRound;

    public Game(Console Console) {
        this.active = false;
        this.Console = Console;
        this.Board = new Board();
        this.Players = new Players();
        this.Victory = new Victory(Board, Players);
        this.CpuOpponent = new CpuOpponent(Board, Players);
    }

    public void init(boolean cpu) {
        this.active = true;
        this.currentRound = 1;
        this.Players.init(cpu);



        this.CpuOpponent.init();

        this.Board.reset();

        if (cpu) {
            this.Console.reset("Game Started\n      Human player begins");
        } else {
            this.Console.reset("Game Started\n      Player"+this.Players.getPlayer()+" begins");
        }
    }

    public void Handle(int btnNr) {
        Board.getField(btnNr).setValue(Players.getPlayer());

        if (this.Victory.CheckVictory(btnNr) ) {
            int playID1 = this.Players.getPlayer();
            this.Console.addLines("Player" + playID1 + " has won");
            this.active = false;
            return;
        };

        if (this.currentRound++ >= 9) {
            this.active = false;
            this.Console.addLines("Draw gameover");
            return;
        }

        this.Players.swap();
        int playID2 = this.Players.getPlayer();
        this.Console.addLines("It's player" + playID2 + "'s turn");
    }

    public boolean activeCpu() {
        if ( this.CpuOpponent.getActive() && this.active) {
            return true;
        }
        return false;
    }

    public int playCpu() {
        int btnNr = this.CpuOpponent.play();
        BoardField field = this.Board.getField(btnNr);
        field.setValue(Players.getPlayer());

        int x = field.get_xPos();
        int y = field.get_yPos();
        this.Console.addLines( "Cpu played field("+btnNr+") on row("+y+")column("+x+")" );

        if (this.Victory.CheckVictory(btnNr) ) {
            this.Console.addLines("Cpu has won");
            this.active = false;
            this.CpuOpponent.kill();
            return btnNr;
        }

        if (this.currentRound++ >= 9) {
            this.active = false;
            this.CpuOpponent.kill();
            this.Console.addLines("Draw gameover");
            return -1;
        }

        this.Players.swap();
        this.Console.addLines( "It's your turn" );

        return btnNr;
    }

    public boolean ValidAction(int btnNr) {
        if ( !this.active ) {
            this.Console.addLines("Game over\n      Start a new one with the provided buttons at the top");
            return false; // cannot play an inactive game
        }

        BoardField field = Board.getField(btnNr);
        if ( field.getValue() > 0 ) {
            return false; // cannot fill a field twice;
        };
        return true;
    }

    public String getPlayerIcon() {
        return Players.getIcon();
    }
}
