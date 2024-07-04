package dys.sys;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import javax.swing.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Path;
import java.sql.*;

public class HelloController {
    class a extends Exception {
        public a(String message) {
            super(message);
        }
    }
    private String d_file="depo.txt";
    @FXML
    private Label tarih;
    @FXML
    private Button seç_1;
    @FXML
    private Button seç_2;
    @FXML
    private Button yedek;
    @FXML
    private Button kur;
    @FXML
    protected void setSeç_1() throws a {
        File a=select();
        File f=new File(d_file);

    }
    private File select(){
        JFileChooser jf=new JFileChooser();
        jf.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        jf.showOpenDialog(null);
        return jf.getSelectedFile();
    }
    public void initialize() throws a {
        File f=new File(d_file);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                throw new a("dosya oluşturulamadı");
            }
        }
        try {
            Connection con=DriverManager.getConnection("jdbc:ucanaccess://src\\main\\resources\\dys\\sys\\depo.accdb");
            Statement st= con.createStatement();
            st.execute("INSERT INTO a ([as dosya],[yed yeri],[işlem],[işlem tariği]) VALUES ('Jane Doe', 'janedoe@e',1,'2222-07-04 23:59:59')");
            ResultSet rs=st.executeQuery("Select * from a");
            while (rs.next()) {
                System.out.println(rs.getString(1));
                System.out.println(rs.getString(2));
                System.out.println(rs.getString(3));
                System.out.println(rs.getString(4));
                System.out.println(rs.getString(5));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}