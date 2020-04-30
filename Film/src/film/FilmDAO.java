package film;

import java.sql.*;
import javax.swing.JOptionPane;

public class FilmDAO {
    private int jmlData;
    private Connection koneksi;
    private Statement statement;
    //constructor berfungsi utk melakukan sebuah koneksi saat ada object baru dibuat
    public FilmDAO(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/kuisprakpbo2";
            koneksi = DriverManager.getConnection(url, "root", "");
            statement = koneksi.createStatement();
            JOptionPane.showMessageDialog(null, "Koneksi Berhasil");
        } catch (ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "Class Not Found : " + ex);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "SQL Exception : " + ex);
        }
    }
    
    public void Insert(FilmModel Model){
        try{
            String query = "INSERT INTO film VALUES (NULL,'"+Model.getJudul()+"','"+
                            Model.getTipe()+"','"+Model.getEpisode()+"','"+Model.getGenre()+
                            "','"+Model.getStatus()+"','"+Model.getRating()+"')";
            statement.executeUpdate(query); //execute querynya
            JOptionPane.showMessageDialog(null, "Data disimpan");
        } catch (Exception sql){
            JOptionPane.showMessageDialog(null, sql.getMessage());
        }
    }
    
    public void Update(FilmModel Model) {
        try{
            String query = "UPDATE film SET judul = '"+Model.getJudul()+
                    "', tipe = '"+Model.getTipe()+"', episode = '"+Model.getEpisode()+
                    "', genre = '"+Model.getGenre()+"', status = '"+Model.getStatus()+
                    "', rating = '"+Model.getRating()+
                    "' WHERE id_film = '"+Model.getId_film()+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil di Update");
        } catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    public void Delete(FilmModel Model) {
        try{
            String query = "DELETE FROM film WHERE id_film = '"+Model.getId_film()+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil dihapus");
        } catch (SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
    
    //utk mengambil data dari db dan mengatur ke dalam tabel
    public String[][] readFilm(){
        try{
            int jmlData = 0; //menampung jmlh data
            //baris sejumlah data, kolomnya ada 8
            String data[][] = new String[getJmldata()][8];
            //pengambilan dta dlm java dari db
            String query = "SELECT * FROM film";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = String.valueOf(jmlData+1); //membuat nomor urut data saat ditampilkan di tabel
                data[jmlData][1] = resultSet.getString("id_film");
                data[jmlData][2] = resultSet.getString("judul");
                data[jmlData][3] = resultSet.getString("tipe");
                data[jmlData][4] = resultSet.getString("episode");
                data[jmlData][5] = resultSet.getString("genre");
                data[jmlData][6] = resultSet.getString("status");
                data[jmlData][7] = resultSet.getString("rating");
                jmlData++;
            }
            return data;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getJmldata(){
        int jmlData = 0;
        try{
            //pengambilan data kedlm java dri db
            String query = "SELECT * FROM film";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
    public String[][] readSearchFilm(FilmModel Model){
        try{
            int jmlData = 0; //menampung jmlh data
            String judul = Model.getSearch();
            //baris sejumlah data, kolomnya ada 8
            String data[][] = new String[getJmlSearch(judul)][8];
            //pengambilan data dlm java dari db sesuai yg dicari
            String query = "SELECT * FROM film WHERE judul LIKE '%" + Model.getSearch() + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                data[jmlData][0] = String.valueOf(jmlData+1); //membuat nomor urut data saat ditampilkan di tabel
                data[jmlData][1] = resultSet.getString("id_film");
                data[jmlData][2] = resultSet.getString("judul");
                data[jmlData][3] = resultSet.getString("tipe");
                data[jmlData][4] = resultSet.getString("episode");
                data[jmlData][5] = resultSet.getString("genre");
                data[jmlData][6] = resultSet.getString("status");
                data[jmlData][7] = resultSet.getString("rating");
                jmlData++;
            }
            return data;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }
    }
    
    public int getJmlSearch(String judul){
        int jmlData = 0;
        try{
            //pengambilan data kedlm java dri db sesuai yg dicari
            String query = "SELECT * FROM film WHERE judul LIKE '%" + judul + "%'";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

}