package models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthResponseBody {
    private String username, userId, password, token, expires, isActive;
    @JsonProperty("created_date")
    private String createdDate;
}
