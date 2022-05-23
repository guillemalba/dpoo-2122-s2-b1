package presentation.views;

import business.entities.Game;
import business.entities.User;
import presentation.controllers.RankingController;
import presentation.controllers.RecordedGameMenuController;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseMotionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.LinkedList;

public class RankingView extends JPanel {
    private JButton jbSettings;
    private JButton jbBack;
    private JPanel[] jPlayerButton = new JPanel[100];
    private LinkedList<User> players;

    private JTable table = new JTable();
    private JScrollPane scrollPane = new JScrollPane();
    private JPanel background = new JPanel(new BorderLayout());
    private RankingController rankingController;


    public RankingView() {
        if(players == null){
            players = new LinkedList<User>();
        }
        setLayout(new BorderLayout());
        setSize(550, 720);
        background.setSize(550, 50);
        background.setLayout(new BorderLayout());
        //background.setBackground(Color.GRAY);

        /**************************************** HEADER *********************************************/
        JPanel jpNorth = new JPanel(new BorderLayout());
        jpNorth.setOpaque(false);

        jbSettings = new JButton("Settings");
        jbSettings.setBackground(Color.BLUE);
        jbSettings.setForeground(Color.WHITE);
        jbSettings.setActionCommand("settings");
        jpNorth.add(jbSettings, BorderLayout.WEST);

        background.add(jpNorth, BorderLayout.NORTH);

        /******************************************** BODY *******************************************/

        scrollPane.setBounds(5, 10, 580, 80);


        //BoxLayout layout = new BoxLayout(jpCenter, BoxLayout.PAGE_AXIS);
        //jpCenter.setLayout(layout);
        //jpCenter.add(scrollPane);

        //background.add(scrollPane, BorderLayout.CENTER);

        /******************************************** FOOT *******************************************/
        JPanel jpSouth = new JPanel(new BorderLayout());
        jpSouth.setOpaque(false);

        jbBack = new JButton("Back");
        jbBack.setBackground(Color.GRAY);
        jbBack.setForeground(Color.WHITE);
        jbBack.setActionCommand("back");
        jpSouth.add(jbBack, BorderLayout.WEST);

        background.add(jpSouth, BorderLayout.SOUTH);

        add(background);
    }

    public void registerRankingController(ActionListener actionListener) {
        jbSettings.addActionListener(actionListener);
        jbBack.addActionListener(actionListener);
        rankingController = (RankingController) actionListener;
    }

    public void update(LinkedList<User> players){
        this.players = players;

        if(players.size() != 0) {
            String[] colName = {"Name", "Win Ratio", "Victories", "Total Games", "Recorded Games"};
            Object[][] data = new Object[players.size()][5];
            for(int i = 0; i < players.size(); i++){
                data[i][0] = players.get(i).getName();
                data[i][1] = String.valueOf(players.get(i).getRatio());
                data[i][2] = String.valueOf(players.get(i).getVictories());
                data[i][3] = String.valueOf(players.get(i).getTotalGames());
            }
            table = new JTable(data, colName);


            background.add(new JScrollPane(table), BorderLayout.CENTER);
        }
        //scrollPane.setViewportView(table);

        revalidate();
        repaint();
    }
}
