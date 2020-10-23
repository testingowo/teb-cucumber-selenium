package Model;

public class StudySubjectCard {

    private String cardImageUrl;
    private String cardTitle;
    private String cities;

    public void setCardImageUrl(String cardImageUrl) {
        this.cardImageUrl = cardImageUrl;
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

    public String getCardImageUrl() {
        return cardImageUrl;
    }

    public String getCardTitle() {
        return cardTitle;
    }
}
