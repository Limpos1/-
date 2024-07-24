package calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();
        int a,b,result,flag;
        int index=0;
        double diameter;
        char operator;
        while(true){
            System.out.print("사칙 연산 1번, 원의 넓이 구하기 2번: ");
            flag = sc.nextInt();
            if(flag == 1){
                try{
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    a = sc.nextInt();
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    b = sc.nextInt();
                }catch(InputMismatchException e){ // 두 정수 입력
                    System.out.println("올바른 숫자를 입력하세요.");
                    sc.next(); // sc.nextInt()는 버퍼에 입력된 값을 소비시키지 않으므로 sc.next()가 다 처리 후 소비시켜 버퍼를 비워주는 역할을 한다.
                    continue;
                }

                System.out.print("사칙연산 기호를 입력하세요: ");
                operator = sc.next().charAt(0);

                try{
                    result = cal.calculate(a,b,operator);
                }catch (Exception e){ // calculate 함수에서 에러 발생 시 여기서 받아 처리한다.
                    System.out.println(e.getMessage()); // calculate 함수에서 작성한 에러 메시지를 출력한다.
                    continue;
                }

                System.out.println("결과: "+result);
                index++; // 결과 리스트에 얼마나 저장됐는지 확인하기 위함


                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
                if(sc.next().equals("remove")){
                    cal.removeResult(); // 삭제 메서드 활용
                    index--; // 삭제했으므로 인덱스가 하나 줄어든다.
                }

                System.out.println("인덱스와 값을 넣고 수정하려면 y를 누르세요: ");
                if(sc.next().charAt(0)=='y'){
                    System.out.println("(첫 번째 인덱스는 1입니다!!!!!)수정 할 인덱스: ");
                    int temp = sc.nextInt();
                    System.out.println("수정 할 값");
                    int temp2 = sc.nextInt();
                    try{
                        cal.Setter(temp, temp2);
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }


                System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
                if(sc.next().equals("inquiry")){
                    cal.inquiryResults();
                }
            } // 1번 선택 시 사칙연산 개시
            else if(flag==2){
                System.out.print("원의 반지름을 입력하시오: ");
                diameter = cal.calculateCircleArea(sc.nextDouble());
                System.out.println("원의 넓이: "+ diameter);
                cal.Csetter(diameter); // 원의 넓이를 저장
                
                cal.CinquiryResults(); // 원의 넓이 목록 바로 출력
            }
            flag = 0;
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(sc.next().equals("exit")){
                break;
            }
        }



    }
}
