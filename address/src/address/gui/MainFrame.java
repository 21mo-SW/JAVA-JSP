package address.gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import address.model.GroupType;
import address.model.Member;
import address.service.MemberService;
import address.utils.MyStringParser;


public class MainFrame extends JFrame {
	
	private MemberService memberService = MemberService.getInstance();
	private MainFrame mainFrame = this;
	private Container backgroundPanel;
	private JPanel topPanel, menuPanel, listPanel;
	private JButton homeButton, frButton, coButton, scButton, faButton, addButton;
	private JList<Member> userList;
	private DefaultListModel<Member> listModel;
	private JScrollPane jspane;
	
	public MainFrame() {
		initObject();
		initData();
		initDesign();
		initListener();
		setVisible(true);
	}
	
	// 객체 생성
	private void initObject() {
		backgroundPanel = getContentPane();
		topPanel = new JPanel();
		// homePanel = new JPanel();
		menuPanel = new JPanel();
		listPanel = new JPanel();
		
		homeButton = new JButton("주소록 전체");
		frButton = new JButton("친구");
		coButton = new JButton("회사");
		scButton = new JButton("학교");
		faButton = new JButton("가족");
		addButton = new JButton("추가");
		
		listModel = new DefaultListModel<>();
		userList = new JList<>(listModel);
		
		jspane = new JScrollPane(userList);
	}
	
	// 데이터 초기화
	private void initData() {
		List<Member> members = memberService.전체목록();
		System.out.println(members);
		if (members == null) {
			return;
		}
		for (Member member : members) {
			listModel.addElement(member);
		}
	}
	
	// 디자인
	private void initDesign() {
		// 1. 기본 세팅
		setTitle("주소록 메인");
		setSize(400,500);
		setLocationRelativeTo(null); // JFrame을 모니터 중앙에 배치
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// 2. 패널 세팅
		backgroundPanel.setLayout(new BorderLayout());
		topPanel.setLayout(new GridLayout(2, 1));	// 행 2
		menuPanel.setLayout(new GridLayout(1,4));	// 열 4
		listPanel.setLayout(new BorderLayout());
		
		// 3. 디자인
		userList.setFixedCellHeight(50);// 리스트 각각의 높이
		topPanel.setPreferredSize(new Dimension(0,100));	// 가로는 옆으로 꽉 차기 때문에 의미없음
		
		// 4. 패널(컨테이너)에 컴포넌트 추가
		menuPanel.add(frButton);
		menuPanel.add(coButton);
		menuPanel.add(scButton);
		menuPanel.add(faButton);
		topPanel.add(homeButton);
		topPanel.add(menuPanel);
		listPanel.add(jspane);
		backgroundPanel.add(topPanel, BorderLayout.NORTH);
		backgroundPanel.add(listPanel, BorderLayout.CENTER);
		backgroundPanel.add(addButton, BorderLayout.SOUTH);
		
	}
	
	// 리스너 등록
	private void initListener() {
		userList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//				System.out.println(userList.getSelectedIndex());
//				System.out.println(userList.getSelectedValue());
				System.out.println(userList.getSelectedValue().toString());
				int memberId = MyStringParser.getId(userList.getSelectedValue().toString());
				System.out.println(memberId);
				new DetailFrame(mainFrame, memberId);
				mainFrame.setVisible(false);
			}
		});
		
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddFrame(mainFrame);
				// mainFrame.setEnabled(false);
				mainFrame.setVisible(false);
				
			}
		});
		
		
		frButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notifyUserList(GroupType.친구);
			}
		});
		
		coButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notifyUserList(GroupType.회사);
			}
		});
		
		scButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notifyUserList(GroupType.학교);
			}
		});
		
		faButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notifyUserList(GroupType.가족);
			}
		});
	}
	
	
	public void notifyUserList() {
		// 1. listModel을 비우고(clear)
		listModel.clear();
		// 2. select해서 전체 목록 가져와서 List<Member>에 담기
		// 3. listModel 채워주기 (userList는 자동갱신됨)
		initData();	// 2. 3. 단계가 한번에 수행됨
	}
	
	public void notifyUserList(GroupType groupType) {
		// 1. listModel을 비우고(clear)
		listModel.clear();
		// 2. select해서 전체 목록 가져와서 List<Member>에 담기
		// 3. listModel 채워주기 (userList는 자동갱신됨)
		List<Member> members = memberService.그룹목록(groupType);
		for(Member member : members) {
			listModel.addElement(member);
		}
	}
}
