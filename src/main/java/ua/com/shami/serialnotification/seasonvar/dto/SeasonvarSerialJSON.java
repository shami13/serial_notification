package ua.com.shami.serialnotification.seasonvar.dto;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SeasonvarSerialJSON {
    private String id;
    private String poster;
    @SerializedName("poster_small")
    private String posterSmall;
    private String name;
    @SerializedName("name_original")
    private String nameOriginal;
    private String year;
    private String description;
    private List<String> genre;
    private List<String> country;
    private List<String> season;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPosterSmall() {
        return posterSmall;
    }

    public void setPosterSmall(String posterSmall) {
        this.posterSmall = posterSmall;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameOriginal() {
        return nameOriginal;
    }

    public void setNameOriginal(String nameOriginal) {
        this.nameOriginal = nameOriginal;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }

    public List<String> getCountry() {
        return country;
    }

    public void setCountry(List<String> country) {
        this.country = country;
    }

    public List<String> getSeason() {
        return season;
    }

    public void setSeason(List<String> season) {
        this.season = season;
    }
}
