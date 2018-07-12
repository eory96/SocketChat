package NetworkChat;


public class Runner extends Thread{
	
	public void run() {
		ServerChatPanel board_server = new ServerChatPanel();
	}

	public static void main(String[] args) {
	
		Runner runner = new Runner();
		runner.start();
		
		
		//ClientChatPanel board_client = new ClientChatPanel();
		
		
	}

}
