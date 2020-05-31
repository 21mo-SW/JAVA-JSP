package ch16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class InsertEx01 {

	public static void main(String[] args) {
		try {
			final String SQL = "insert into USERS(id, name, email, password) values(?,?,?,?)";
			Class.forName("oracle.jdbc.driver.OracleDriver");  //Class.forName�� new�ؼ� �޸𸮿� �ø��°��̶� ����. �� Ŭ���� �ε�
			//����̹��Ŵ����� �ڹٿ����� �ּҸ� ã�� �� �ִ� Ŭ�����̱⿡ ����Ŭ �ּҸ� �Է����ָ�ȴ�. ��Ŀ�ؼ��� conn�� ���� �������ش�.
			//���� ����̹��Ŵ����� DB�� ����� ��� heap���� �����Ѵ�.
			//jdbc: �ڿ��ִ� oracle�� ����ϴ� DBMS�� ���� ��Ī�� �޸����� �ִ�.
			//thin�� �ڹٰ� ����ִ� API�� �����Ѵٴ� ���̰� oci�� ���� �ü���� ����ִ� ���̺귯���� ���ؼ� �����Ѵٴ� ���̴�.
			//XE�� �����ʰ� ��� �ִ� �̸����� ������ ���Ͽ��� ��Ī�� �ٲ��ָ� �ٲ��� ��Ī�� �Է����ָ�ȴ�.
			//��Ʈ������
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "c##ssar", "bitc5600");
			//���� �ޱ� (?�� ����ϰ� ���ش�.)
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			//�ڹٴ� index�� 0���ͽ��������� DB�� index�� 1���ͽ���
			pstmt.setInt(1,4);
			pstmt.setString(2, "������");
			pstmt.setString(3, "dongwon@nate.com");
			pstmt.setString(4, "1234");
			
			//���ۿ� ���� (������Ʈ�� ���������� commit�� �޷��ִ�.)
			//execute�� select�Ҷ��� ����ϰ� insert,delete,update�� executeUpdate�� ���ش�.
			pstmt.executeUpdate();
			System.out.println("insert �Ϸ�");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
