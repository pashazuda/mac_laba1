package my_package;
/** Класс ошибки когда используются одновременно разные системы счисления*/
class CalcException extends Exception{
    CalcException(String description){
        super(description);
    }
}

