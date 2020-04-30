package film;

import java.sql.Statement;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FilmView extends JFrame{
    JLabel ljudul,ltipe,lstatus,leps,lrating,lgenre;
    JTextField txjudul,txtipe,txeps,txrating,txgenre,txsearch;
    JButton refresh,create,update,delete,exit,search;
    JComboBox cbstatus;
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"#", "ID", "Judul", "Tipe", "Episode", "Genre", "Status", "Rating"};
    Statement statement;
    
    public FilmView(){
        setTitle("KUIS 2 PRAKTIKUM PBO");
        
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        ljudul = new JLabel("Judul");
        ltipe = new JLabel("Tipe");  
        lstatus = new JLabel("Status");
        leps = new JLabel("Episode");
        lrating = new JLabel("Rating");
        lgenre = new JLabel("Genre");
        
        txjudul = new JTextField("");
        txtipe = new JTextField("");
        txeps = new JTextField("");
        txrating = new JTextField("");
        txgenre = new JTextField("");
        txsearch = new JTextField("");
        
        refresh = new JButton("Refresh");
        create = new JButton("Create");
        update = new JButton("Update");
        delete = new JButton("Delete");
        exit = new JButton("Exit");
        search = new JButton("Search");
        
        String s1[] = {"On going", "Selesai"}; 
        cbstatus = new JComboBox(s1); 
        
        setLayout(null);
        add(ljudul);
        add(ltipe);
        add(lstatus);
        add(leps);
        add(lrating);
        add(lgenre);
        
        add(txjudul);
        add(txtipe);
        add(txeps);
        add(txrating);
        add(txgenre);
        add(txsearch);
        
        add(refresh);
        add(create);
        add(update);
        add(delete);
        add(exit);
        add(search);
        
        add(cbstatus);
        add(scrollPane);
        
        ljudul.setBounds(25, 240, 50, 20);
        txjudul.setBounds(25, 265, 300, 20);
        
        ltipe.setBounds(25, 295, 50, 20);
        txtipe.setBounds(25, 320, 120, 20);
        
        lstatus.setBounds(200, 295, 50, 20);
        cbstatus.setBounds(200, 320, 120, 20);
        
        leps.setBounds(25, 350, 50, 20);
        txeps.setBounds(25, 375, 120, 20);
        
        lrating.setBounds(200, 350, 50, 20);
        txrating.setBounds(200, 375, 120, 20);
        
        lgenre.setBounds(25, 405, 50, 20);
        txgenre.setBounds(25, 430, 300, 20);
        
        txsearch.setBounds(425, 265, 200, 20);
        search.setBounds(650, 263, 75, 23);
        
        refresh.setBounds(350, 430, 80, 23);
        create.setBounds(445, 430, 80, 23);
        update.setBounds(540, 430, 80, 23);
        delete.setBounds(635, 430, 80, 23);
        exit.setBounds(730, 430, 80, 23);
        
        scrollPane.setBounds(40, 25, 750, 200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        setSize(850,520); 
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public String getJudul(){
        return txjudul.getText();
    }
    
    public String getTipe(){
        return txtipe.getText();
    }
    
    public String getEps(){
        return txeps.getText();
    }
    
    public String getGenre(){
        return txgenre.getText();
    }
    
    //status menggunakan combo box, jadi pilihan dr combo box kemudian dijadikan string, tidak langsung getText()
    public String getStatus(){
        return cbstatus.getSelectedItem().toString();
    }
    
    public String getRating(){
        return txrating.getText();
    }
    
    public String getSearch(){
        return txsearch.getText();
    }
}
