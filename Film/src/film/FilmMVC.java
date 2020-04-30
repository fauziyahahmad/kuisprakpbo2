package film;

public class FilmMVC {
    FilmView filmview = new FilmView();
    FilmModel filmmodel = new FilmModel();
    FilmDAO filmdao = new FilmDAO();
    FilmController filmcontroller = new FilmController(filmmodel, filmview, filmdao);
}