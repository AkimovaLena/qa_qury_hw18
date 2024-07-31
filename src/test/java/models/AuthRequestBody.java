package models;

import lombok.Data;

@Data
public class AuthRequestBody {

    private String userName, password;
}
