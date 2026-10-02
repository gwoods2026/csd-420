//Garrett Woods Module 10

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Main extends JFrame {
    private JTextField displayID, displayFirstName, displayLastName, displayTeam;
    private JButton displayButton, updateButton;

    private static final String DB_URL = "jdbc:mysql://localhost:3306/databasedb";
    private static final String DB_USER = "student1";
    private static final String DB_PASS = "pass";

    public Main() {

        //creates the table with buttons layout
        setTitle("Fans");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 5, 5));

        add(new JLabel("ID:"));
        displayID = new JTextField();
        add(displayID);

        add(new JLabel("FIrst Name:"));
        displayFirstName = new JTextField();
        add(displayFirstName);

        add(new JLabel("Last Name:"));
        displayLastName = new JTextField();
        add(displayLastName);

        add(new JLabel("Favorite Team:"));
        displayTeam = new JTextField();
        add(displayTeam);

        displayButton = new JButton("Show Fan");
        updateButton = new JButton("Update Data");
        add(displayButton);
        add(updateButton);

        displayButton.addActionListener(e -> displayFan());
        updateButton.addActionListener(e -> updateTable());
    }

    public void displayFan() {
        String idString = displayID.getText().trim();

        //checks to makes ure there is somehting in ID
        if (idString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No IDs to display");
            return;
        }

        //connect to the database
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement("SELECT firstname, lastname, favoriteteam FROM fans WHERE ID = ?")) {

            stmt.setInt(1, Integer.parseInt(idString));
            ResultSet rs = stmt.executeQuery();


            //retrieves data from SQL for the fields
            if (rs.next()) {
                displayFirstName.setText(rs.getString("firstname"));
                displayLastName.setText(rs.getString("lastname"));
                displayTeam.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "No record found with ID " + idString);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Something went wrong: " + ex.getMessage());
        }
    }

    public void updateTable() {

        //Updates data
        String idString = displayID.getText().trim();
        String first = displayFirstName.getText().trim();
        String last = displayLastName.getText().trim();
        String team = displayTeam.getText().trim();

        //checks to make sure there is an ID
        if(idString.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter ID to update");
            return;
        }

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement stmt = conn.prepareStatement("UPDATE fans SET firstname = ?, lastname = ?, favoriteteam = ? WHERE ID = ?")) {

            stmt.setString(1, first);
            stmt.setString(2, last);
            stmt.setString(3, team);
            stmt.setInt(4, Integer.parseInt(idString));


            //checks to make sure update happened and errors if not
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Successfully Updated");
            } else {
                JOptionPane.showMessageDialog(this, "Update failed");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}