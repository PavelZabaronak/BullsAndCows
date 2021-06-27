package com.zabaronak.bullsandcows.validator;

import com.zabaronak.bullsandcows.exception.LenghtValidException;
import com.zabaronak.bullsandcows.exception.ValidException;

public interface NumberValidator {

    void numberValid(String number) throws ValidException;
}
