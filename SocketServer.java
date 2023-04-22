import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.StringTokenizer;

public class SocketServer {
	
	public static final int PORT = 8084;
	
	public static void callServer() {
		(new Thread() {
		@Override
		public void run() {
		// Step 1: Establish the socket connection.
		try {
        ServerSocket ss = new ServerSocket(PORT);
        System.out.println("LE SERVEUR EST LANC� ET TOURNE SUR LE PORT : " + PORT);
        Socket s = ss.accept(); // FAIT TOURNER LE SERVEUR
        
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        
        
        int resultat;

        while (true)
        {
        	Packet packetRecu = (Packet) ois.readObject(); // D�S�RIALISE
        	
        	 //condition d'arr�t
        	if((packetRecu.message).equals("fin")) {
        		break;
        	}
        	else {
        		
            // attente de l'input
                
            System.out.println("Equation re�ue : " + packetRecu.message);
         
            // On utilise StringTokenizer pour s�parer l'�quation en op�randes et op�ration
            
            // operation
            
            StringTokenizer st = new StringTokenizer(packetRecu.message);

            int oprnd1 = Integer.parseInt(st.nextToken());
            String operation = st.nextToken();
            int oprnd2 = Integer.parseInt(st.nextToken());

            // Calcul
            
            resultat =(int) Factory.initOperation(operation).Calculer(oprnd1, oprnd2);

            System.out.println("Envoi du r�sultat...");

            // R�sultat envoy� au client 
            
            Packet packet = new Packet(String.valueOf(resultat));
            oos.writeObject(packet); // S�RIALISE
            oos.flush();
        	}
        }
    	s.close();
    	ss.close();
		}
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
		}
		}).start();
	}
}

