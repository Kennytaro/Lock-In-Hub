/*
Alyssa Zulaik, Sumer of 1997
This program models GUI based on OOP
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URL;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.event.*;


public class gui extends JFrame implements ActionListener {
    public static final Color NICE_COLOR = new Color(148, 215, 210);
    public static final Font SUPER_SIZE = new Font("Arial", Font.BOLD | Font.ITALIC, 45);
    public final URL FOREST_PATH = getClass().getResource("forest.jpg");
    private final ImageIcon FOREST_IMG = new ImageIcon(new ImageIcon(
        FOREST_PATH).getImage().getScaledInstance(
      700, 372, Image.SCALE_DEFAULT));

    private JLabel message;
    private JPanel messagePanel;
    private JPanel buttonPanel;
    private JButton spotifyButton;
    private JButton meditationButton;
    private JButton notesButton;
    private JButton calendarButton;
    private JButton toDoButton;
    private JButton exitButton;

    private JLabel forest;

    public gui() {
        super("Session Test");
        this.setBounds(220, 120, 700, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.getContentPane().setBackground(NICE_COLOR);
        this.getContentPane().setBackground(Color.WHITE);
        this.setLayout(new BorderLayout());

        this.forest = new JLabel(FOREST_IMG);

        this.message = new JLabel("Lock-In Hub!");
        message.setFont(SUPER_SIZE);
        message.setForeground(Color.BLACK);

        this.spotifyButton = new JButton("Spotify");
        spotifyButton.addActionListener(this);

        this.meditationButton = new JButton("Meditation");
        meditationButton.addActionListener(this);

        this.notesButton = new JButton("Notes");
        notesButton.addActionListener(this);

        this.calendarButton = new JButton("Calendar");
        calendarButton.addActionListener(this);

        this.toDoButton = new JButton("To-do List");
        toDoButton.addActionListener(this);

        this.exitButton = new JButton("Exit");
        exitButton.addActionListener(this);

        this.add(forest, BorderLayout.CENTER);

        this.buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(spotifyButton);
        buttonPanel.add(meditationButton);
        buttonPanel.add(notesButton);
        buttonPanel.add(calendarButton);
        buttonPanel.add(toDoButton);
        buttonPanel.add(exitButton);

        this.messagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        messagePanel.add(message);

        this.add(messagePanel, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);

        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowLostFocus(WindowEvent e) {
                setAlwaysOnTop(true); // Set the frame to always be on top when focus is lost
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {
                setAlwaysOnTop(false); // Disable always on top when the frame gains focus
            }
        });

        this.setVisible(true);
    }

    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        gui objName = new gui();
    });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("Spotify")) {
            this.getContentPane();
            message.setText("Spotify Time!");
        } else if (command.equals("Meditation")) {
            this.getContentPane();
            message.setText("Meditation Time!");
        } else if (command.equals("Notes")) {
            this.getContentPane();
            message.setText("Take Notes of your work!");
        } else if (command.equals("Calendar")) {
            this.getContentPane();
            message.setText("Check Your Calendar!");
        } else if (command.equals("To-do List")) {
            this.getContentPane();
            message.setText("Manage Your To-do List!");
        } else if (command.equals("Exit")) {
            System.exit(0);
        }
        this.validate();
        this.repaint();
    }
}