package model;

public class DataEntity {
    private int id;
    private String login;
    private String pwd;
    private String prenom;

    // Constructeur par défaut
    public DataEntity() {
    }

    // Constructeur avec tous les champs
    public DataEntity(int id, String login, String pwd, String prenom) {
        this.id = id;
        this.login = login;
        this.pwd = pwd;
        this.prenom = prenom;
    }


    // Getter et Setter pour id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter et Setter pour login
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    // Getter et Setter pour pwd
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    // Getter et Setter pour prenom
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Méthode toString pour afficher l'objet en chaîne de caractères
    @Override
    public String toString() {
        return id + " " + login + " " + pwd + " " + prenom ;
    }

}
