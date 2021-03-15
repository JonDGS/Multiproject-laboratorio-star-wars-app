package models;

public class GalacticCitizen {
    private String name;
    private int height;
    private String year;

    public GalacticCitizen(String name, int height, String year){
        this.name = name;
        this.height = height;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
