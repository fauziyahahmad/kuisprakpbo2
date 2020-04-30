package film;

import java.awt.event.*;
import javax.swing.*;

public class FilmController {
    FilmModel filmmodel;
    FilmView filmview;
    FilmDAO filmdao;
    static String dataTerpilih, judul, tipe, status, episode, genre, rating; //dataTerpilih = id_film
     
    public FilmController(FilmModel filmmodel, FilmView filmview, FilmDAO filmdao){
        this.filmmodel = filmmodel;
        this.filmview = filmview;
        this.filmdao = filmdao;
        
        if(filmdao.getJmldata() != 0){
            String dataFilm[][] = filmdao.readFilm();
            filmview.tabel.setModel((new JTable(dataFilm, filmview.namaKolom)).getModel());
        } else {
            JOptionPane.showMessageDialog(null, "Data tidak ada!");
        }
        
        filmview.create.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String judul = filmview.getJudul();
                String tipe = filmview.getTipe();
                String status = filmview.getStatus();
                String episode = filmview.getEps();
                String rating = filmview.getRating();
                String genre = filmview.getGenre();
                
                if(judul.isEmpty() || tipe.isEmpty() || status.isEmpty() || episode.isEmpty() || rating.isEmpty() || genre.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Harap isi semua field");
                } else {
                    filmmodel.setFilmModel(judul, tipe, episode , genre, status, rating);
                    filmdao.Insert(filmmodel); //membuat data baru
                    
                    String dataFilm[][] = filmdao.readFilm();
                    filmview.tabel.setModel((new JTable (dataFilm, filmview.namaKolom)).getModel());
                }
            }
        });
       
        
        filmview.tabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int baris = filmview.tabel.getSelectedRow();
                int kolom = filmview.tabel.getSelectedColumn();

                dataTerpilih = filmview.tabel.getValueAt(baris,1).toString(); //id_film berada di kolom kesatu
                judul = filmview.tabel.getValueAt(baris,2).toString();
                tipe = filmview.tabel.getValueAt(baris,3).toString();
                episode = filmview.tabel.getValueAt(baris,4).toString();
                genre = filmview.tabel.getValueAt(baris,5).toString();
                status = filmview.tabel.getValueAt(baris,6).toString();
                rating = filmview.tabel.getValueAt(baris,7).toString();
                
                filmview.txjudul.setText(judul);
                filmview.txtipe.setText(tipe);
                filmview.cbstatus.setSelectedItem(status);
                filmview.txeps.setText(episode);
                filmview.txrating.setText(rating);
                filmview.txgenre.setText(genre);
                }
        });
        
        filmview.delete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            int input = JOptionPane.showConfirmDialog(null, "Apakah anda ingin menghapus data " + dataTerpilih + "?","Delete",JOptionPane.YES_NO_OPTION);

                if (input == 0){
                    filmmodel.setId_film(dataTerpilih);
                    filmdao.Delete(filmmodel); //menghapus data yg sudah ada
                    String dataFilm[][] = filmdao.readFilm();
                    filmview.tabel.setModel((new JTable (dataFilm, filmview.namaKolom)).getModel());
                }
            }
        });
           
        filmview.update.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String judul = filmview.getJudul();
                String tipe = filmview.getTipe();
                String status = filmview.getStatus();
                String episode = filmview.getEps();
                String rating = filmview.getRating();
                String genre = filmview.getGenre();
                
                if(judul.isEmpty() || tipe.isEmpty() || status.isEmpty() || episode.isEmpty() || rating.isEmpty() || genre.isEmpty()){
                    JOptionPane.showMessageDialog(null, "Harap isi semua field");
                } else {    
                    filmmodel.setId_film(dataTerpilih);
                    filmmodel.setFilmModel(judul, tipe, episode , genre, status, rating);
                    filmdao.Update(filmmodel); //mengedit data yg sudah ada
                    
                    String dataFilm[][] = filmdao.readFilm();
                    filmview.tabel.setModel((new JTable (dataFilm, filmview.namaKolom)).getModel());
                }
            }
        });
        
        filmview.search.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = filmview.getSearch();

                if (search.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Isi kolom dengan judul yang ingin dicari");
                } else {
                    filmmodel.setSearch(search); //judul apa yg dicari

                    String dataFilm[][] = filmdao.readSearchFilm(filmmodel); //menampilkan data yg dicari dalam tabel
                    filmview.tabel.setModel((new JTable(dataFilm, filmview.namaKolom)).getModel());
                }
            }
        });
        
        filmview.exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //keluar dari program
                System.exit(0);
            }
        }); 
        
        filmview.refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dataFilm[][] = filmdao.readFilm();
                filmview.tabel.setModel((new JTable (dataFilm, filmview.namaKolom)).getModel());
                
                //mengosongkan kolom field
                filmview.txjudul.setText(null);
                filmview.txtipe.setText(null);
                filmview.cbstatus.setSelectedItem(null);
                filmview.txeps.setText(null);
                filmview.txrating.setText(null);
                filmview.txgenre.setText(null);
                filmview.txsearch.setText(null);
            }
        });
    }
    
}
