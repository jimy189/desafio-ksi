package com.br.apiksi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;

public class FilmeDTO {

    @JsonProperty("Title")
    private String Title;
    @JsonProperty("Year")
    private Integer Year;
    @JsonProperty("Director")
    private String Director;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }
}
