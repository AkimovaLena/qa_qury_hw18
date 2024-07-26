package models;

import lombok.Data;

@Data
public class AuthResponseBody {
    String username, userId, password, token, expires, created_date, isActive;
}
