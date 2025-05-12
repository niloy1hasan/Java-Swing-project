package res.Components;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuizTimer {
    private final int totalSeconds;
    private final JLabel time;
    private Timer timer;
    String timeMessage;

    public QuizTimer(String timeMessage, JLabel timeLabel, int totalSeconds) {
        this.time = timeLabel;
        this.totalSeconds = totalSeconds;
        this.timeMessage = timeMessage;
    }

    public void startTimer(Runnable onTimeUp) {
        final int[] remaining = {totalSeconds};

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int minutes = remaining[0] / 60;
                int seconds = remaining[0] % 60;
                time.setText(timeMessage + String.format("%02d:%02d", minutes, seconds));
                remaining[0]--;

                if (remaining[0] < 0) {
                    timer.stop();
                    onTimeUp.run();
                }
            }
        });

        timer.setInitialDelay(0);
        timer.start();
    }

    public void stopTimer() {
        if (timer != null && timer.isRunning()) {
            timer.stop();
        }
    }
}