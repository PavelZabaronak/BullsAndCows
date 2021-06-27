package com.zabaronak.bullsandcows.service.impl;

import com.zabaronak.bullsandcows.service.MessageService;

public class MessageServiceImp implements MessageService {

    @Override
    public String generationMessage(int cows, int bulls) {
        StringBuilder message = new StringBuilder("Не угадал! ");
        message.append(cows);
        message.append("К, ");
        message.append(bulls);
        message.append("Б!");
        message.append("\n");
        return message.toString();
    }
}
