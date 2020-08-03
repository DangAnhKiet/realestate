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
    @Indexed
    private String addressHolder;
    private String nameOwner;
    private String district;
    private String ward;
    private String description;
    private String pathImage;
    private String street;
    private String price;
    private String status;
    private String createdDate;
    private String updatedDate;
    private String createdBy;
    private String updatedBy;
    public Land() {
    }
}

