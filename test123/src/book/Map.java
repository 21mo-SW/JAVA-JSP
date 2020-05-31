package book;

import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Map extends JFrame {

	public Map() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 800);
		getContentPane().setLayout(null);
		JFXPanel fxPanel = new JFXPanel();
		fxPanel.setBounds(0, 0, 800, 561);
		getContentPane().add(fxPanel);
		
		JButton searchbtn = new JButton("\uAC80\uC0C9");
		
		searchbtn.setBounds(848, 85, 97, 23);
		getContentPane().add(searchbtn);
		
		JButton basketbtn = new JButton("\uC7A5\uBC14\uAD6C\uB2C8");
		
		basketbtn.setBounds(848, 139, 97, 23);
		getContentPane().add(basketbtn);
		
		JButton mapbtn = new JButton("\uC9C0\uB3C4");
		mapbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Map();
			}
		});
		mapbtn.setBounds(848, 203, 97, 23);
		getContentPane().add(mapbtn);
		Platform.runLater(new Runnable() {

			public void run() {
				initAndLoadWebView(fxPanel);
			}
		});
		setVisible(true);
	}

	private static void initAndLoadWebView(final JFXPanel fxPanel) {
		Group group = new Group();
		Scene scene = new Scene(group);
		fxPanel.setScene(scene);
		WebView webView = new WebView();
		group.getChildren().add(webView);
		webView.setMinSize(500, 500);
		webView.setMaxSize(1000, 600);
		WebEngine webEngine = webView.getEngine();
		webEngine.load("http://cokj1610.dothome.co.kr/kakao_mapsearch.html");
	}

	public static void main(String[] args) {
		new Map();
	}
}