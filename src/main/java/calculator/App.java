package calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Calculator cal = new Calculator();
        int a,b,result;
        char operator;
        Scanner sc = new Scanner(System.in);
        while(true){
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

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if(sc.next().equals("remove")){
                for(int i=0; i<cal.list.size()-1; i++){
                    cal.list.set(i,cal.list.get(i+1));
                }
                cal.list.remove(cal.list.size()-1);
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if(sc.next().equals("inquiry")){
                for(int i : cal.list){
                    System.out.print(i+" ");
                }
                System.out.println();
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(sc.next().equals("exit")){
                break;
            }
        }

    }
}
