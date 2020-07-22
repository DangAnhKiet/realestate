package com.estate.real.document;

import com.estate.real.config.CollectionName;
import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = CollectionName.HISTORY)
@Data
public class History {
    private long timestamp;
    @Indexed
    private String seller;
    @Indexed
    private String buyer;
    private int landID;
}
