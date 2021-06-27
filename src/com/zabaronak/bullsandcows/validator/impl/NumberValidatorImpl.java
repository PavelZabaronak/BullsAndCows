package com.zabaronak.bullsandcows.validator.impl;

import com.zabaronak.bullsandcows.exception.DublicateNumberValidException;
import com.zabaronak.bullsandcows.exception.InncorectCharValidException;
import com.zabaronak.bullsandcows.exception.LenghtValidException;
import com.zabaronak.bullsandcows.exception.ValidException;
import com.zabaronak.bullsandcows.validator.NumberValidator;

public class NumberValidatorImpl implements NumberValidator {

    @Override
    public void numberValid(String number) throws ValidException {
        if (number.length() != 4) {
            throw new LenghtValidException("Число должно быть четырехзначное");
        }

        try {
            for (int i = 0; i < number.length(); i++) {
                char validNumber = number.charAt(i);
                Integer.parseInt(Character.toString(validNumber));
            }
        } catch (NumberFormatException e) {
            throw new InncorectCharValidException("Число должно быть числом, а не другими символами");
        }

        for (int i = 0; i < number.length() - 1; i++) {
            for (int j = i + 1; j < number.length(); j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    throw new DublicateNumberValidException("Цифры не должны повторяться в числе");
                }
            }
        }
    }
}
