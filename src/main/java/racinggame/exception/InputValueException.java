package racinggame.exception;

public class InputValueException extends RuntimeException{
    public InputValueException(String msg){
        super(msg);
    }

    @Override
    public String getMessage(){
        return String.format("%s %s", "[ERROR]", super.getMessage());
    }
}
