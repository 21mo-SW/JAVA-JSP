package chatv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import chatv4.SocketServer.SocketThread;

public class SocketClient {

	Socket socket;
	BufferedReader reader;
	PrintWriter writer;
	Scanner sc;

	public SocketClient() {
		try {
			socket = new Socket("59.20.79.42", 15000);
			SocketThread st = new SocketThread();
			st.start();
			
			writer = new PrintWriter(socket.getOutputStream(), true);
			sc = new Scanner(System.in);
			while(true) {
				String line = sc.next();
				System.out.println(line);
				if(line.equals("종료")) {
					break;
				}
				//ALL:안녕
				//MSG:아이디:안녕
				writer.println(line);
			}
//			reader.close();  //이거 주면 작동이 잘 안됌.
			writer.close();
			sc.close();
			socket.close();
			System.out.println("클라이언트종료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	class SocketThread extends Thread {
		@Override
		public void run() {
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String line = null;
				while((line = reader.readLine()) != null) {
					System.out.println("from server : " + line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new SocketClient();
	}

}
