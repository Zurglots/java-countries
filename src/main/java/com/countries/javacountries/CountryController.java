package com.countries.javacountries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/names")
//@RequestMapping("/population")
public class CountryController // defines which endpoints handle specific actions
{
    @GetMapping(value= "/all",
                produces = {"application/json"})
    public ResponseEntity<?> getAllCountries()
    {

        JavacountriesApplication.ourCountryList.countryList.sort((c1, c2) -> c1.getName().compareToIgnoreCase(c2.getName()));
        return new ResponseEntity<>(JavacountriesApplication.ourCountryList.countryList, HttpStatus.OK);
    }

//    @GetMapping(value ="/start/{letter}",
//                produces = {"application/json"})
//
//    public ResponseEntity<?> getCountryByLetter(@PathVariable String )
//    {
//
//    }
}


