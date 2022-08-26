import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        // dashboard
        JPanel dashboard = new JPanel();
        dashboard.setLayout(null);
        dashboard.setVisible(true);

        JButton logout = new JButton("Logout");
        logout.setBounds(10, 20, 80, 25);
        dashboard.add(logout);
        dashboard.setBackground(Color.blue);

    //Frame
        frame.setTitle("Spotify");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 450);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.add(panel);

        panel.setLayout(null);

    //Panel
        JLabel username = new JLabel("E-mail");
        username.setBounds(10, 20, 80, 25);
        panel.add(username);

        JTextField userVal = new JTextField();
        userVal.setBounds(80, 20, 150, 25);
        panel.add(userVal);

        JButton btn = new JButton("Sign In");
        btn.setBounds(8, 50, 120, 25);
        panel.add(btn);

        JLabel error = new JLabel();
        error.setBounds(10, 90, 180, 25);
        error.setForeground(Color.RED);
        panel.add(error);

        //Action

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getVal = userVal.getText();

                if(getVal.isEmpty()) {
                    error.setText("Empty field");
                } else if(getVal.equals("tatjana@rcs.lv")) {
                    error.setText("OK");
                    frame.remove(panel);
                    frame.add(dashboard);
                    frame.setTitle("Welcome " + getVal);
                    frame.repaint();

                } else {
                    error.setText("Error");
                }

            }
        });
        logout.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.remove(dashboard);
                frame.add(panel);
                frame.repaint();
                error.setText("See you later...");

            }
        });

    }
}