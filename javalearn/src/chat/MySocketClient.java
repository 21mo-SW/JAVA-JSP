package chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocketClient {
	
	Socket socket;
	
	public MySocketClient() throws Exception {
		socket = new Socket("192.168.0.85", 3000);
		
		ReadThread rt = new ReadThread();
		Thread newWorker = new Thread(rt);
		newWorker.start();
		
		BufferedWriter bw = 
		new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		
		BufferedReader keyboardIn =
		new BufferedReader(new InputStreamReader(System.in));
		
		String outputMsg = "";
		
		//메인쓰레드는 여기서 무한 루프
		while((outputMsg = keyboardIn.readLine()) != null) {
			bw.write(outputMsg + "\n");
			bw.flush();
		}
	}

	class ReadThread implements Runnable {
		@Override
		public void run() {
			try {
				BufferedReader br = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
				String inputMsg = "";
				while((inputMsg = br.readLine()) != null) {
					System.out.println("상대방:" + inputMsg);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		try {
			new MySocketClient();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
