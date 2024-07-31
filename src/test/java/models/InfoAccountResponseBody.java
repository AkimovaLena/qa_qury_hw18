package models;

import lombok.Data;

import java.util.List;

@Data
public class InfoAccountResponseBody {
    private String username, userId;
    private List<BooksModel> books;
}
