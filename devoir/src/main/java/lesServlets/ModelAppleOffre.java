package lesServlets;


import java.util.Date;


public class ModelAppleOffre  {

	private String id;
	private double budgetPrevisionnel;
	private Date dateLimite;
	private String organismeEmetteur;
	private String contactPersonneGereAO;

    public String getTitle() {

        return "Offer_" + id + "_by_" + organismeEmetteur;
    }

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getBudgetPrevisionnel() {
		return budgetPrevisionnel;
	}

	public void setBudgetPrevisionnel(double budgetPrevisionnel) {
		this.budgetPrevisionnel = budgetPrevisionnel;
	}

	


	public String getOrganismeEmetteur() {
		return organismeEmetteur;
	}

	public void setOrganismeEmetteur(String organismeEmetteur) {
		this.organismeEmetteur = organismeEmetteur;
	}

	public String getContactPersonneGereAO() {
		return contactPersonneGereAO;
	}

	public void setContactPersonneGereAO(String contactPersonneGereAO) {
		this.contactPersonneGereAO = contactPersonneGereAO;
	}

	 public void setDateLimite(Date dateLimite) {
	     this.dateLimite = dateLimite;
	 }

	 public Date getDateLimite() {
	     return dateLimite;
	 }
	 
	 public ModelAppleOffre(String id, double budgetPrevisionnel, Date dateLimite, String organismeEmetteur,
	                        String contactPersonneGereAO) {
	     super();
	     this.id = id;
	     this.budgetPrevisionnel = budgetPrevisionnel;
	     this.dateLimite = dateLimite;
	     this.organismeEmetteur = organismeEmetteur;
	     this.contactPersonneGereAO = contactPersonneGereAO;
	 }
	 


}
