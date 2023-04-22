import java.io.Serializable;

public class Packet implements Serializable {

	private static final long serialVersionUID = 8631173373885129191L;
    
    String message;
    
    public Packet (String message) {
        this.message = message;
    }
}
