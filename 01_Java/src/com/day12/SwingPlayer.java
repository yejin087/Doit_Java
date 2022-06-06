package com.day12;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SwingPlayer extends JFrame {
  public SwingPlayer() {

    setLayout(new GridLayout(2, 2));
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    // (1,1)
    add(new PlayerPanel());

    // (1,2)
    JTextArea ta = new JTextArea();
    JScrollPane jsp = new JScrollPane(ta);
    add(ta);

    JButton insertbtn = new JButton("insert");
    JButton viewBtn = new JButton("view");
    JButton updateBtn = new JButton("update");
    JButton deleteBtn = new JButton("delete");
    JPanel p1 = new JPanel();
    p1.add(insertbtn);
    p1.add(viewBtn);
    p1.add(updateBtn);
    p1.add(deleteBtn);
    add(p1);

    JPanel p2 = new JPanel();
    JComboBox<String> jcb = new JComboBox<>();
    jcb.addItem("name");
    jcb.addItem("kind");
    JTextField tfSearch = new JTextField(10);
    p2.add(tfSearch);
    JButton searchBtn = new JButton("search");
    p2.add(searchBtn);

    setSize(500, 400);
    setVisible(true);
  }

  class PlayerPanel extends JPanel {
    private String[] text = { "name", "height", "weight", "kind" };
    private JTextField[] tf = new JTextField[4];

    public PlayerPanel() {
      setLayout(null);
      for (int i = 0; i < text.length; i++) {
        JLabel la = new JLabel(text[i]);
        la.setSize(50, 20);
        la.setLocation(30, 50 + i * 20);
        add(la);

        tf[i] = new JTextField();
        tf[i].setSize(150, 20);
        tf[i].setLocation(120, 50 + i * 20);
        add(tf[i]);

      }
    }

    private void dbCon() {
      Connection con;
      try {
        Class.forName("oracle.jdbc.driver.oracle.Driver");
        String url = "jdbc:oracle:thin:@localhost:1521:xe";
        String user = "hr";
        String pwd = "1234";
        con = DriverManager.getConnection(url, user, pwd);
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public static void main(String[] args) {
    new SwingPlayer();
  }
}
