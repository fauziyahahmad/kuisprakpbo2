package film;

public class FilmModel {
    private String id_film, judul, tipe, episode, genre, status, rating, search;
    //constructor
    public void setFilmModel(String xjudul, String xtipe, String xepisode, String xgenre, String xstatus, String xrating){
        this.judul = xjudul;
        this.tipe= xtipe;
        this.episode= xepisode;
        this.genre= xgenre;
        this.status= xstatus;
        this.rating= xrating;
    }
    
    //id_film menggunakan auto increment
    public String getId_film(){
        return id_film;
    }
    
    public void setId_film(String id_film){
        this.id_film = id_film;
    }
    
    public String getJudul(){
        return judul;
    }
    
    public void setJudul(String judul){
        this.judul = judul;
    }
    
    public String getTipe(){
        return tipe;
    }
    
    public void setTipe(String tipe){
        this.tipe = tipe;
    }
    
    public String getEpisode(){
        return episode;
    }
    
    public void setEpisode(String episode){
        this.episode = episode;
    }
    
    public String getGenre(){
        return genre;
    }
    
    public void setGenre(String genre){
        this.genre = genre;
    }
    
    public String getStatus(){
        return status;
    }
    
    public void setStatus(String status){
        this.status = status;
    }
    
    public String getRating(){
        return rating;
    }
    
    public void setRating(String rating){
        this.rating = rating;
    }
    
    public String getSearch(){
        return search;
    }
    
     public void setSearch(String search){
        this.search = search;
    }
}