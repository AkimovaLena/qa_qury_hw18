package models;

import lombok.Data;

import java.util.List;

@Data
public class AddBookStoreRequestBody {
    private String userId;
    private List<CollectionOfIsbns> collectionOfIsbns;
}
