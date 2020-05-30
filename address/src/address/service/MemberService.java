package address.service;

import java.util.List;

import address.dao.MemberDao;
import address.model.GroupType;
import address.model.Member;

public class MemberService {
	
	private MemberService() {}
	private static MemberService instance = new MemberService();
	public static MemberService getInstance() {
		return instance;
	}
	
	private MemberDao memberDao = MemberDao.getInstance();
	
	public int 주소록추가(Member member) {
		// 3. DAO에 접근해서 추가함수 호출(Member)
		int result = memberDao.추가(member);
		return result;
	}
	
	public List<Member> 전체목록() {
		return memberDao.전체목록();
	}
	
	public int 삭제(int memberId) {
		return memberDao.삭제(memberId);
	}
	
	public int 수정(Member member) {
		return memberDao.수정(member);
	}
	
	public Member 상세보기(int memberId) {
		return memberDao.상세보기(memberId);
	}
	
	public List<Member> 그룹목록(GroupType groupType){
		return memberDao.그룹목록(groupType);
	}
	
}
