package src;

import java.util.*;

public class BaseballGame {

    public static void main(String[] args) {
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        int count = 1;

        Random random = new Random();
        int uniqueNumber = uniqueThree(random);
        int[] listNumber = listNumber(uniqueNumber);
        System.out.println(uniqueNumber);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print(count + "번째 시도 : ");
            int number = scanner.nextInt();
            int[] userNumber = listNumber(number);;

            if(number == uniqueNumber){
                System.out.println("3S");
                System.out.println(count + "번만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");

                break;
            }else {
                int strike = 0;
                int ball = 0;
                for(int i = 0; i < listNumber.length; i++){
                    if(listNumber[i] == userNumber[i]){
                        strike++;
                    }else if(contains(listNumber, userNumber[i])){
                        ball++;
                    }
                }
                if (ball == 3) {
                    System.out.println(ball+"B");
                } else {
                    System.out.println(ball+"B"+strike+"S");
                }
                count++;
            }
        }

    }

    private static int uniqueThree(Random random) {
        while (true) {
            int number = 100 + random.nextInt(900); // 100에서 999 사이의 숫자 생성
            if (areYouUnique(number)) {
                return number;
            }
        }
    }
    private static boolean areYouUnique(int number){
        int hundreds = number / 100;
        int tens = (number/10) % 10;
        int units = (number % 10);
        return hundreds != tens && hundreds != units && tens != units;
    }

    private static int[] listNumber(int number){
        int hundreds = number / 100;
        int tens = (number/10) % 10;
        int units = (number % 10);
        return new int[]{hundreds, tens, units};
    }

    private static boolean contains(int[] arr, int value){
        for(int i : arr){
            if(i == value) {
                return true;
            }
        }
        return false;
    }




}

