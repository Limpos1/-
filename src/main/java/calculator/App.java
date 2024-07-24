package calculator;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int a,b;
        List<Integer> list = new ArrayList<>();
        int index=0;
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

            int result = 0;
            switch (operator){
                case '+':
                {
                    result = a + b;
                    break;
                }
                case '-':
                {
                    result = a - b;
                    break;
                }
                case '*':
                {
                    result = a * b;
                    break;
                }
                case '/':
                {
                    if(b==0){
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        continue;
                    }
                    else
                        result = a / b;
                    break;
                }
                default:{
                    System.out.println("사칙 연산 기호가 아닙니다 (+, -, *, /) 중 하나를 입력하세요");
                    continue;
                }
            }
            
            System.out.println("결과: "+result);
            list.add(result);

            System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제)");
            if(sc.next().equals("remove")){
                for(int i=0; i<list.size()-1; i++){
                    list.set(i,list.get(i+1));
                }
                list.remove(list.size()-1);
            }

            System.out.println("저장된 연산결과를 조회하시겠습니까? (inquiry 입력 시 조회)");
            if(sc.next().equals("inquiry")){
                for(int i : list){
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
