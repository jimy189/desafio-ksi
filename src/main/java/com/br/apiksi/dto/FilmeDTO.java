package com.br.apiksi.dto;

import jakarta.persistence.Column;

public class FilmeDTO {


    private String Title;
    private Integer Year;
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
