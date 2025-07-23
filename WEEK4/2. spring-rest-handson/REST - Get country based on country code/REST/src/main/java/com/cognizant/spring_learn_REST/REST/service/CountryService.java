package com.cognizant.spring_learn_REST.REST.service;


import java.util.List;

import javax.xml.stream.XMLEventFactory;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.cognizant.spring_learn_REST.REST.model.Country;

@SuppressWarnings("deprecation")
@Service
public class CountryService {
    public Country getCountry(String code) {
        XMLEventFactory factory = new XMLEventFactory(new ClassPathResource("country.xml"));
        
        List<Country> countryList = (List<Country>) factory.getBean("countryList");

        // Case-insensitive match using lambda
        return countryList.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElse(null);
    }
}
