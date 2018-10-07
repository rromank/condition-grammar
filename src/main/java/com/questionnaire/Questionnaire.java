package com.questionnaire;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@Getter
@Setter
public class Questionnaire {
    private Map<String, Supplier<String>> properties = new HashMap<>();
    private String associationName;
    private String borrowerName;

    {
        properties.put("ASSOCIATION_NAME", this::getAssociationName);
        properties.put("BORROWER_NAME", this::getBorrowerName);
    }

    public String getStringProperty(String name) {
        return properties.get(name).get();
    }

}
