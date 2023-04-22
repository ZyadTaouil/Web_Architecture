import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class IHM_Setter extends IHM{
	
	public IHM_Setter(int operandeGauche, String operation, int operandeDroite) {
		super(operandeGauche, operation, operandeDroite);
	}

	public static void init() throws Exception {
		(new Thread() {
		@Override
		public void run() {
		try {	
		Socket s = new Socket("localhost",8084);  
		ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());  
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
    	  
    	String output="";  

        while (true)
        {
        	// Il faut obligatoirement un espace entre l'opérande, l'opération et la deuxième opérande
            System.out.print("Entrez votre calcul sous la forme : ");
            System.out.println("Opérande Opération Opérande");

            output = br.readLine();
            
            // send the equation to server
            Packet packet = new Packet(output);
            oos.writeObject(packet);
            
            oos.flush(); 
            
            //condition d'arrêt
        	if(output.equals("fin")) {
        		System.out.println("Merci d'avoir utilisé la calculatrice");
        		break;
        	}
        	else {

            // On attend le traitement de la requête et récupère le résultat du traitement
        	Packet packetRecu = (Packet) ois.readObject();
        	System.out.println(packetRecu.message);
        	
        	}
        }
        oos.close();
    	s.close();
		}
		catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } 
		}
		}).start();
        	

}
}

