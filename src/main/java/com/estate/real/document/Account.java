package com.estate.real.document;

import com.estate.real.config.CollectionName;
import com.estate.real.model.enums.AccountStatus;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = CollectionName.ACCOUNT)
@Data
public class Account {
    @Indexed(unique = true)
    private String nameLogin; // chung minh nhan dan
    private String password;
    private String fullName;
    private String role;
    private String email;
    private String gender;
    private String phoneNumber;
    @Indexed
    private AccountStatus status;
    private String privateKey;
    @Indexed(unique = true)
    private String address;

    public Account() {
    }
}
