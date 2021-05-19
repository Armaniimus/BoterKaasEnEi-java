package sample;

import java.util.ArrayList;

public class Console {
    private int lineCount = 0;
    ArrayList<String> MessageLines = new ArrayList<String>();

    public String reset(String message) {
        lineCount = 0;
        addMessageLines(message);
        lineCount++;
        return getMessageLines();
    }

    public void addLines(String message) {
        addMessageLines(message);
        lineCount++;
    }

    public String addAndPrintLines(String message) {
        addMessageLines(message);
        lineCount++;
        return getMessageLines();
    }

    public String getMessageLines() {
        String message = "";

        for (int i = lineCount-1; i>=0; i--) {
            message += MessageLines.get(i);
        }

        return message;
    }

    private void addMessageLines(String message) {
        message = "" + lineCount + ". " + message + "\n\n";
        MessageLines.add(lineCount, message);
    }
}
