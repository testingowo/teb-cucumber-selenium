package Model;

public class StudySubjectCard {

//    @FindBy(className = "direction")
//    private WebElement cardLocator;
//
//    @FindBy(className = "direction-img")
//    private WebElement cardImage;
//
//    @FindBy(className = "title")
//    private WebElement cardTitle;
//
//    @FindBy(css = ".cities > span")
//    private List<WebElement> cities;
    private String cardImageUrl;
    private String cardTitle;
    private String cities;

    public String getCardImageUrl() {
        return cardImageUrl;
    }

    public void setCardImageUrl(String cardImageUrl) {
        this.cardImageUrl = cardImageUrl;
    }

    public String getCardTitle() {
        return cardTitle;
    }

    public void setCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
    }

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities;
    }
}
