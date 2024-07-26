package calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Number result;
        String input = "";
        Number a,b;
        ArithmeticCalculator calculator = new ArithmeticCalculator(); // 사칙연산을 담당하는 객체
        CircleCalculator circleCalculator = new CircleCalculator(); // 원의 넓이를 담당하는 객체
        int flag;
        int index=0;
        double diameter;
        char operator;

        while(true){
            System.out.print("사칙 연산 1번, 원의 넓이 구하기 2번: ");
            flag = sc.nextInt();
            if(flag == 1){

                //--------------------------------------------------------------------------------------------------------------------------

                // 현재 블럭은 각각
                try {
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    input = sc.next(); // .nextLine()하면 개행문자까지 버퍼에 입력되어서 밑에서 숫자로 변환하는데에 문제가 발생한다. 그러므로 개행문자를 받지 않는 next를 사용한 것이다.
                    a = Integer.parseInt(input);
                }catch (NumberFormatException e){ // NumberFormatException == 정수형으로 변환 실패 시 발생하는 오류, 곧바로 실수로 변환을 시도한다.
                    try {
                        a = Double.parseDouble(input);
                    }catch (NumberFormatException e2){ // 실수로도 변환 실패하면 허용되지 않은 값이니 예외처리
                        System.out.println("올바른 숫자를 입력하세요.");
                        continue;
                    }
                }

                try {
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    input = sc.next(); // .nextLine()하면 개행문자까지 버퍼에 입력되어서 밑에서 숫자로 변환하는데에 문제가 발생한다. 그러므로 개행문자를 받지 않는 next를 사용한 것이다.
                    b = Integer.parseInt(input);
                }catch (NumberFormatException e){ // NumberFormatException == 정수형으로 변환 실패 시 발생하는 오류, 곧바로 실수로 변환을 시도한다.
                    try {
                        b = Double.parseDouble(input);
                    }catch (NumberFormatException e2){ // 실수로도 변환 실패하면 허용되지 않은 값이니 예외처리
                        System.out.println("올바른 숫자를 입력하세요.");
                        continue;
                    }
                }
                //----------------------------------------------------------------------------------------------------------
                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = sc.next().charAt(0);

                try{
                    result = calculator.calculate(a,b,operator);
                }catch (Exception e){ // calculate 함수에서 에러 발생 시 여기서 받아 처리한다.
                    System.out.println(e.getMessage()); // calculate 함수에서 작성한 에러 메시지를 출력한다.
                    continue;
                }

                System.out.println("결과: "+result);
                calculator.Setter(result);
                index++; // 결과 리스트에 얼마나 저장됐는지 확인하기 위함

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                if(sc.next().equals("remove")){
                    calculator.removeResult(); // 삭제 메서드 활용
                    index--; // 삭제했으므로 인덱스가 하나 줄어든다.
                }

                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                if(sc.next().equals("inquiry")){
                    calculator.inquiryResults();
                }
            } // 1번 선택 시 사칙연산 개시
            else if(flag==2){
                System.out.print("원의 반지름을 입력하시오: ");
                diameter = circleCalculator.calculateCircleArea(sc.nextDouble());
                System.out.println("원의 넓이: "+ diameter);
                circleCalculator.Setter(diameter); // 원의 넓이를 저장

                circleCalculator.CinquiryResults(); // 원의 넓이 목록 바로 출력
            }
            flag = 0;
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(sc.next().equals("exit")){
                break;
            }
        }



    }
}
