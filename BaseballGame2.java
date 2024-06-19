package src;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BaseballGame2 {
    public static void main(String[] args) {

        int count = 1;
        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");

        Random random = new Random();
        int[] uniqueNumber = uniqueThree(random); //랜덤 숫자 생성
        Scanner sc = new Scanner(System.in);



        while(true) {
            int strike = 0;
            int ball = 0;
            int inputNum = sc.nextInt();
            int[] baseInputNum = baseNum(inputNum); //내가 입력한 숫자 [] 넣기
            System.out.println(Arrays.toString(uniqueNumber));
            System.out.println(Arrays.toString(baseInputNum));
            //값 확인 후 B/S
            for (int i = 0; i < uniqueNumber.length; i++) {
                for (int j = 0; j < baseInputNum.length; j++) {

                    if (uniqueNumber[i] == baseInputNum[j] && i == j) { //strike
                        strike++; //strike 일 경우 + 1
                    } else if (uniqueNumber[i] == baseInputNum[j] && i != j) { //ball
                        ball++; //ball 일 경우 + 1
                    }

                }
            }
            System.out.println(count + "번째 시도 : " + inputNum);

            if ( strike == 0 && ball == 0 ){
                System.out.println(strike + "S" + ball + "B");
            }
            else if(ball == 0 ){
                System.out.println(strike + "S");
            }
            else if (strike == 0){
                System.out.println(ball + "B");
            }
            else {
                System.out.println(strike + "S" + ball + "B");
            }
            if(strike == 3){
                System.out.println(count + "번만에 맞히셨습니다.");
                System.out.println(strike + "S");
                System.out.println("게임을 종료합니다.");
                break;
            }
            count++; // 횟수 + 1


        }



    }

    //랜덤 숫자 생성 후 배열에 넣기
    private static int[] uniqueThree(Random random) {
        int[] listNum;
        int number = 100 + random.nextInt(900); // 899까지만 나와서 + 100
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = (number % 10);
        listNum = new int[3];
        if (hundreds != tens && hundreds != units && tens != units) {
            listNum[0] = hundreds;
            listNum[1] = tens;
            listNum[2] = units;
        }

        return listNum;
    }

    //입력받은 숫자 배열에 넣기
    private static int[] baseNum(int number) {
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = (number % 10);
        int[] listNumInput = new int[3];
            if (hundreds != tens && hundreds != units && tens != units) {
                listNumInput[0] = hundreds;
                listNumInput[1] = tens;
                listNumInput[2] = units;
            }
        return listNumInput;
    }

}