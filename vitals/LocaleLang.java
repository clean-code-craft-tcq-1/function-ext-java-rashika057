package vitals;
public enum LocaleLang {
	EN("en","US"),
    DE("de","DE");
	private String language;
	private String country;
	private LocaleLang(String language, String country) {
		this.language = language;
		this.country = country;		
	}
	public String getLanguage() {
		return language;
	}
	public String getCountry() {
		return country;
	}
}
