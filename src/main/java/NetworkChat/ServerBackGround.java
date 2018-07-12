package NetworkChat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class ServerBackGround {
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream in;
    private DataOutputStream out;
    private ServerChatPanel gui;

    public final void setGui(ServerChatPanel gui) {
    	this.gui = gui;
    	
    }

    public void setting(){
        try {
            ServerSocket server = new ServerSocket();
            System.out.println("서버 대기중...");
            
            InetSocketAddress ipep = new InetSocketAddress(9999);
            server.bind(ipep);

            socket = serverSocket.accept();
            System.out.println(socket.getInetAddress()+"에서 접속했습니다.");
            out = new DataOutputStream(socket.getOutputStream());
            in = new DataInputStream(socket.getInputStream());

            while(true){
                String msg = in.readUTF();          //읽어옵니당
                gui.appendMsg("Player1: " + msg);
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
