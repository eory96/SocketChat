package NetworkChat;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientBackGround {
    
	private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ClientChatPanel gui;
    private String msg;

    public final void setGui(ClientChatPanel gui) {
        this.gui = gui;
        
    }

    public void connect() {
        try {
            Socket client = new Socket();
            InetSocketAddress ipep = new InetSocketAddress("127.0.0.1", 8888);
            client.connect(ipep);
            System.out.println("서버 연결됨.");
            
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());
            
            while(in !=null) {
            	msg=in.readUTF();
            	gui.appendMsg("Player2: " + msg);
            	}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    	


    public void sendMessage(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    


}
