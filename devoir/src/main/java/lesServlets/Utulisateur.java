package lesServlets;






public class Utulisateur  {
	

    private String id;
    private String nom;
    private String prenom;
    private String login;
    private String motDePasse;
    private String numeroTelephone;
    private String role;
    
    public String getId() {
		return id;
	}


	
    public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login.toLowerCase();
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Utulisateur(String id,String nom, String prenom, String login, String motDePasse, String numeroTelephone,String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.motDePasse = motDePasse;
        this.numeroTelephone = numeroTelephone;
        this.role = role;
    }

}
