package kr.co.billiejoe.admin.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.billiejoe.admin.model.dao.AdminDAO;
import kr.co.billiejoe.member.model.vo.Member;
import kr.co.billiejoe.common.model.vo.Pagination;
import kr.co.billiejoe.place.model.vo.Place;
import kr.co.billiejoe.place.model.vo.Report;
import kr.co.billiejoe.review.model.vo.Review;

@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO dao;
	
	// 암호화 객체 생성
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	// 로그인 Service
	@Override
	public Member login(Member inputMember) {
		
		// 암호화
		String encPw = bCryptPasswordEncoder.encode(inputMember.getMemberPw());
		
		Member loginMember = dao.login(inputMember.getMemberEmail());
		
		System.out.println(loginMember);
		
		if(loginMember != null) {
			
			if( !bCryptPasswordEncoder.matches(inputMember.getMemberPw(), loginMember.getMemberPw()) ) {
				loginMember = null;
			
			}else {
				loginMember.setMemberPw(null); 
			}
		
		}	
		
		return loginMember;
	}

	// 신고글 수 구하기
	@Override
	public Pagination getReportListCount(Pagination pg) {
		int listCount = dao.getReportListCount();
		pg.setListCount(listCount);
		return pg;
	}

	// 신고글 목록조회
	@Override
	public List<Report> selectReportList(Pagination pg) {
		// TODO Auto-generated method stub
		return dao.selectReportList(pg);
	}

	// 신고처리하기
	@Override
	public int reportCheck(int reviewNo) {
		// TODO Auto-generated method stub
		return dao.reportCheck(reviewNo);
	}


	// 관리자 게시판 총 후기개수
	@Override
	public Pagination getAdminReviewListCount(Pagination pg) {
		int listCount = dao.getAdminReviewListCount();
		pg.setListCount(listCount);
		System.out.println("impl : " + listCount); // 9
		System.out.println("impl : " + pg); // 9
		return pg;
	}

	// 관리자 게시판 총 후기 목록
	@Override
	public List<Review> selectAdminReviewList(Pagination pg) {
		return dao.selectAdminReviewList(pg);
	}
	
	// 관리자 후기 상세조회
	@Override
	public Review selectAdminReview(int reviewNo) {
		
		Review reviewView = dao.selectAdminReview(reviewNo);
		
		return reviewView;
	}
	
	
	// 후기글 삭제 Service
	@Transactional(rollbackFor = Exception.class)
	@Override
	public int deleteReview(int reviewNo) {
		
		int result = dao.deleteReview(reviewNo);
		
		return result;
	}
		


}
