package com.zabaronak.bullsandcows.service.impl;

import com.zabaronak.bullsandcows.service.GameService;
import java.util.Arrays;
import java.util.Random;

public class GameServiceImp implements GameService {

    private String number;

    private Random random;

    public GameServiceImp() {
        random = new Random();

    }

    @Override
    public void generationNumber() {
        int number[] = new int[4];
        Arrays.fill(number,-1);
        for (int i =0; i<4;i++) {
            boolean check=false;
            do {
                number[i] = random.nextInt(10);
                for(int j = 0; j<i;j++){
                    if(number[i]==number[j]){
                        check=true;
                    }
                    else{
                        check=false;
                    }
                }
            }while (check);

        }
        this.number= transformatArrayToString(number);

    }

    @Override
    public boolean checkNumber(String number) {
        return this.number.equals(number);
    }

    @Override
    public int counterBulls(String numbers) {
        int counter=0;
        for (int i = 0; i < numbers.length(); i++) {
            String numberOne = Character.toString(numbers.charAt(i));
            String numberTwo = Character.toString(number.charAt(i));
              if(numberOne.equals(numberTwo)){
                  counter++;

            }
        }
        return counter;
    }

    @Override
    public int counterCows(String numbers) {
        int counter = 0;
        for (int i = 0; i < numbers.length(); i++) {
            String numberOne = Character.toString(numbers.charAt(i));
            if(number.contains(numberOne)){
                String numberTwo = Character.toString(number.charAt(i));
                if(!numberOne.equals(numberTwo)){
                    counter++;
                }
            }
        }
        return counter;
    }

    private String transformatArrayToString(int[] numbers){
        StringBuilder result = new StringBuilder("");
        for (int i : numbers) {
            result.append(i);
        }
        return result.toString();
    }


}
