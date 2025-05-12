package res.layout;

import res.Components.PrimaryBtn;
import res.Components.TablePanel;
import res.Components.TopBar;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LeaderboardPanel extends JPanel {
    JPanel bottomBar;
    JPanel contentContainer;
    JPanel containterPanel;
    TablePanel table;

    PrimaryBtn backBtn;
    PrimaryBtn homeBtn;
    PrimaryBtn playBtn;

    LeaderboardPanel(){
        setLayout(new BorderLayout());

        //panel part
        containterPanel = new JPanel(new BorderLayout());
        contentContainer = new JPanel();
        bottomBar = new JPanel();

        //topBar
        TopBar topBar = new TopBar();

        //contentContainer
        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(Color.WHITE);

        JLabel title = new JLabel("Leaderboader");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        title.setBorder(new EmptyBorder(10, 0, 10, 0));
        titlePanel.add(title);

        containterPanel.add(titlePanel, BorderLayout.NORTH);

        contentContainer.setBackground(Color.white);
        contentContainer.setLayout(new BorderLayout());
        contentContainer.setBorder(new EmptyBorder(0, 10, 0, 10));
        containterPanel.add(contentContainer, BorderLayout.CENTER);
        //end of contentContainer

        //bottomBar
        bottomBar.setBackground(Color.white);
        backBtn = new PrimaryBtn("BACK");
        homeBtn = new PrimaryBtn("HOME");
        playBtn = new PrimaryBtn("PLAY AGAIN");
        bottomBar.add(backBtn);
        bottomBar.add(homeBtn);
        bottomBar.add(playBtn);
        //end of bottomBar

        //component adding part
        add(topBar, BorderLayout.NORTH);
        add(containterPanel, BorderLayout.CENTER);
        add(bottomBar, BorderLayout.SOUTH);
    }

    public PrimaryBtn getPlayBtn() {
        return playBtn;
    }

    public TablePanel getTable() {
        return table;
    }

    public PrimaryBtn getHomeBtn() {
        return homeBtn;
    }

    public PrimaryBtn getBackBtn() {
        return backBtn;
    }

    public JPanel getContentContainer() {
        return contentContainer;
    }
}
