package models;

import lombok.Data;

import java.util.List;

@Data
public class InfoAccountResponseBody {
    String username, userId;
    List<BooksModel> books;
}
