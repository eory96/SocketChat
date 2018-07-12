package NetworkChat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ClientChatPanel extends JFrame implements ActionListener{
	JTextArea jta = new JTextArea(40,25);
	JTextField jtf = new JTextField(25);
	ClientBackGround client =new ClientBackGround();
	
	public ClientChatPanel() {
		jtf.addActionListener(this);
		add(jta, BorderLayout.CENTER);
		add(jtf, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setVisible(true);
		setBounds(800,100,400,600);
		setTitle("messeger for client");
		
		client.setGui(this);
		client.connect();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String msg = jtf.getText()+"\n";
		jta.append("Player1 : "+msg);
		System.out.println(jtf);
		client.sendMessage(msg);
		jtf.setText("");
	}
	
	
	public void appendMsg(String msg) {
		jta.append(msg);
		System.out.print("From Host : "+msg);
		
	}

}