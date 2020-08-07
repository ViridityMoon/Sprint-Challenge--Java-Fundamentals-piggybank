package com.example.javapiggybank.controllers;

import com.example.javapiggybank.models.Coin;
import com.example.javapiggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController
{
    @Autowired
    CoinRepository coinrepos;

    //https://localhost:2020/total
    @GetMapping(value = "/total", produces = {"application/json"})
    public ResponseEntity<?> printCoins()
    {
            List<Coin> myList = new ArrayList<>();
            coinrepos.findAll().iterator().forEachRemaining(myList::add);
            double totalValue = 0;
            for (Coin e : myList)
        {
            if (e.getQuantity() <= 1)
            {
                System.out.println(e.getQuantity() + " " + e.getName());
            }
            if (e.getQuantity() >= 2)
            {
                System.out.println(e.getQuantity() + " " + e.getNamePlural());
            }
            totalValue = totalValue + (e.getQuantity() * e.getValue());
            System.out.println(totalValue);
        }
            System.out.println("The piggy bank holds" + " " + totalValue);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
