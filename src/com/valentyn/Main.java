package com.valentyn;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int [] userElem;
        Scanner sc = new Scanner(System.in);
        ArrayList simpleResult = new ArrayList();
        String outResult = "";

        //Получаем данные от пользователя

        System.out.println("Введите массив чисел через пробел");
        String userInput = sc.nextLine();

        //Разбиваем данные в массив чисел по пробелу
        String [] elements = userInput.split("\\s");
        userElem = new int [elements.length];
        for (int i=0; i<elements.length; i++) {
            try {
                userElem[i]=Integer.parseInt(elements[i]);
            } catch (NumberFormatException e) {
                System.err.println("Вы не ввели число!");
            }
        }

        //Проверяем простоту числа
        for (int i=0; i<userElem.length; i++){
            while (isSimple(userElem[i])) {
                simpleResult.add(userElem[i]);
                break;
            }
        }

        //Выводим простые числа из коллекции
        for (int i=0; i<simpleResult.size(); i++ ) {
            outResult+= " "+simpleResult.get(i);
        }
        System.out.println(outResult);
    }

    //Метод проверки простого числа
    private static boolean isSimple(int i){
        if(i%2 == 0 && i!=2)
            return false;
        else{
            if(i == 1) return false;
            for(int p=3;p<=i/2;p+=2){
                if(i%p == 0)
                    return false;
            }
            return true;
        }

    }
}
