package BeerRecipe;

public class Hops {

	int hopsID;
	String hopName;
	String categoryDisplay;
	String hopDescription;
	
	String countryisoCode;
	String countryName;
	
	
	public String HopsToSqlInsert(Fermentables newFermentables){
		
		String sqlInsertIntoFermTable = "INSERT INTO k_ulm_FP_Fermentables VALUES(" +
				"'" + newFermentables.getFermID() + "', " +
				"'" + newFermentables.getFermName() + "', " +
				"'" + newFermentables.getCatagory() + "', " +
				"'" + newFermentables.getCategoryDisplay()+ "', " + 
				"'" + newFermentables.getDescription() + "', " +
				"'" + newFermentables.getFermCharID() + ", " +
				"'" + newFermentables.getFermCharName() + ", " +
				"'" + newFermentables.getFermCharDescription() + ", " +
				"'" + newFermentables.getCreatedByUSerID() + ", " +
				"'" + "Now() )";
				
//		System.out.println(sqlInsertIntoFermTable);
		
		return sqlInsertIntoFermTable;
	}
	
	
	
	

	/*
	 * Getters and Setters
	 */
	
	public int getHopsID() {
		return hopsID;
	}
	
	public void setHopsID(int hopsID) {
		this.hopsID = hopsID;
	}


	public String getHopName() {
		return hopName;
	}

	public void setHopName(String hopName) {
		this.hopName = hopName;
	}

	public String getCategoryDisplay() {
		return categoryDisplay;
	}

	public void setCategoryDisplay(String categoryDisplay) {
		this.categoryDisplay = categoryDisplay;
	}

	public String getHopDescription() {
		return hopDescription;
	}

	public void setHopDescription(String hopDescription) {
		this.hopDescription = hopDescription;
	}

	public String getCountryisoCode() {
		return countryisoCode;
	}

	public void setCountryisoCode(String countryisoCode) {
		this.countryisoCode = countryisoCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	

}
