package models;

import lombok.Data;

import java.util.List;

@Data
public class AddBookStoreRequestBody {
    String userId;
    List<CollectionOfIsbns> collectionOfIsbns;
}
