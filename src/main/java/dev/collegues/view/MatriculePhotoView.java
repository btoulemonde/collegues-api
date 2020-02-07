package dev.collegues.view;

public class MatriculePhotoView {

	private String matricule;
	private String photUrl;

	/**
	 * @param matricule
	 * @param photUrl
	 */
	public MatriculePhotoView(String matricule, String photUrl) {
		super();
		this.matricule = matricule;
		this.photUrl = photUrl;
	}

	/**
	 * 
	 */
	public MatriculePhotoView() {
		super();
	}

	/**
	 * Getter
	 * 
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Setter
	 * 
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**
	 * Getter
	 * 
	 * @return the photUrl
	 */
	public String getPhotUrl() {
		return photUrl;
	}

	/**
	 * Setter
	 * 
	 * @param photUrl
	 *            the photUrl to set
	 */
	public void setPhotUrl(String photUrl) {
		this.photUrl = photUrl;
	}

}
