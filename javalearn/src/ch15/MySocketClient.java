package ch15;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class MySocketClient {

	Socket socket;
	BufferedWriter bw;
	BufferedReader br;

	public MySocketClient() throws UnknownHostException, IOException {
		socket = new Socket("59.20.79.42", 15000); // ���������� accept()�Լ��� ȣ��
		bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String msg = "";
while (true) {
			
			msg = br.readLine();
			
			if(msg.equals("����")) {
				break;
			}
			
			bw.write(msg + "\n");
			System.out.println("�� �޽��� : " + msg);
			bw.flush();
		}
		bw.close();
		br.close();
		socket.close();
	}

	public static void main(String[] args) {
		try {
			new MySocketClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
