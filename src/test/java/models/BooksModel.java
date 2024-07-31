package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class BooksModel {
    private String isbn, title, subTitle, author, publisher, description, website;
    @JsonProperty("publish_date")
    private Date publishDate;
    private int pages;
}
