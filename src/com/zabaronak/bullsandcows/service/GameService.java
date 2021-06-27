package com.zabaronak.bullsandcows.service;

public interface GameService {

    void generationNumber();

    boolean checkNumber(String number);

    int counterBulls(String numbers);

    int counterCows(String numbers);
}
