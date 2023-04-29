
package shutup.patients;

 public class SlotOccupiedException extends RuntimeException{
    public SlotOccupiedException(String message){
        super(message);
    }
    
    public SlotOccupiedException(){
        super();
    }
}