package com.chrislaforetsoftware.library.domains.rules;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class CatalogRules {

    public boolean isBookEligibleForAdding(String ISBN, String title, Double price) {
        return StringUtils.isNotBlank(ISBN) && StringUtils.isNotBlank(title) && price != null;
    }
}
