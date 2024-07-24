package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        int a,b;
        int[] arrays = new int[10];
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
            if(index<10) {
                arrays[index] = result;
                index++;
            }
            else{
                for(int i=0;i<9;i++){ // 배열의 크기 - 1번만큼 반복
                    arrays[i]=arrays[i+1];
                }
                arrays[9] = result;
            }
            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            if(sc.next().equals("exit")){
                break;
            }
        }

    }
}
