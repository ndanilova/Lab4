package ecxeptions;

public class EmptyNameException extends RuntimeException{
    EmptyNameException (String name){
        super((name == null || name.length() == 0)? "Unknown" : name);
    }
}
