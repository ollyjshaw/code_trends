package services;

public class CodeTrendItem {
    private final String language;
    private final Double popularity;
    
    public CodeTrendItem(String language, Double popularity) {
        this.language = language;
        this.popularity = popularity; 
    }

    public String getLanguage() {
        return language;
    }
    
    public Double getPopularity(){
    	return popularity;
    }
}
