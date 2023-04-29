package shutup.patients;

 public class MapFullException extends RuntimeException{
    public MapFullException(String message){
        super(message);
    }
    
    public MapFullException(){
        super();
    }
}