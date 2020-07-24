package com.estate.real.document;

import com.estate.real.config.CollectionName;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = CollectionName.LAND)
@Data
public class Land {
    @Indexed(unique = true)
    private int landId;
    private String addressHolder;
    private String district;
    private String ward;
    private String description;
    private String pathImage;
    private String street;
    private String price;
    private int status;

    // 0
    // 1
    // 2
//    active,
//    pending,
//    deleted
    public Land() {
    }
}

