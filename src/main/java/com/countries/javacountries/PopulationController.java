package com.countries.javacountries;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import static com.countries.javacountries.JavacountriesApplication.ourCountryList;

@RestController
@RequestMapping("/population")
public class PopulationController
{

    @GetMapping(value ="/size/{people}",
                produces = {"application/json"})
    public ResponseEntity<?> comparePop(@PathVariable int people)
    {
       ArrayList<Country> comparePop = JavacountriesApplication.ourCountryList.findCountries(c -> c.getPopulation() >= people);
       return new ResponseEntity<>(comparePop, HttpStatus.OK);
    }


    @GetMapping(value = "/min",
            produces = {"application/json"})
    public ResponseEntity<?> populationMin()
    {
//        int maxPop = 0;
//        int pop =
        ourCountryList.countryList.sort((c1, c2) -> Math.min(c1.getPopulation(), c2.getPopulation()));
        return new ResponseEntity<>(ourCountryList.countryList, HttpStatus.OK);
    }


    // localhost:8080/population
    @GetMapping(value = "/max",
                produces = {"application/json"})
    public ResponseEntity<?> populationMax()
    {
//        int maxPop = 0;
//        int pop =
        ourCountryList.countryList.sort((c1, c2) -> Math.max(c1.getPopulation(), c2.getPopulation()));
        return new ResponseEntity<>(ourCountryList.countryList, HttpStatus.OK);
    }
}
