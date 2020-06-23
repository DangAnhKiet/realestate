package com.estate.real.document;

import com.estate.real.config.CollectionName;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = CollectionName.ACCOUNT)
@Data
public class Account {
    @Indexed
    private String nameLogin;
    private String password;
    private String fullName;
    private String role;
    private String status;
    private String address;

    public Account() {
    }
}
