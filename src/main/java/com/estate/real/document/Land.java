package com.estate.real.document;

import com.estate.real.config.CollectionName;
import com.estate.real.model.enums.LandStatus;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = CollectionName.LAND)
@Data
public class Land {
    private String addressSeller;
    private String district;
    private String street;
    private String price;
    private String image;
    private int status;

    public Land() {
    }
}

