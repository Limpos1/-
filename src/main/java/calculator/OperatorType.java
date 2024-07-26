package calculator;

public enum OperatorType{
        ADD('+') // ADD는 열거형 상수, ('+')는 생성자의 매개변수라고 한다.
        ,SUB('-')
        ,MUL('*')
        ,DIV('/')
        ,MOD('%');

        private final char symbol;

        OperatorType(char symbol){ // 생성자로서 전달받은 매개변수에 의해 해당 enum의 열거형 상수가 결정된다.(final로 선언된 symbol이기 때문에 다시 변경될 수 없다.)
                this.symbol = symbol;
        }


        public static OperatorType getOperatorType(char symbol){ // enum의 매개변수'+', '-' ...를 전달받아 그 매개변수에 매칭되는 열거형 상수 ADD, SUB...을 반환해준다.
                switch(symbol){
                        case '+': return ADD;
                        case '-': return SUB;
                        case '*': return MUL;
                        case '/': return DIV;
                        case '%': return MOD;
                        default: return null;
                }
        }


}
