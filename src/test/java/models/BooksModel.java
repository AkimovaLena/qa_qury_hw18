package models;

import lombok.Data;

import java.util.Date;

@Data
public class BooksModel {
    String isbn, title, subTitle, author, publisher, description, website;
    Date publish_date;
    int pages;
}
