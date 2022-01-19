package ecxeptions;

public class EmptyDataException extends RuntimeException{
    public EmptyDataException(String name){
        super((name == null || name.length() == 0)? "Unknown" : name);
    }
}
