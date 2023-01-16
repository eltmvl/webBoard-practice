package webBoard.JianBoard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import webBoard.JianBoard.domain.Board;
import webBoard.JianBoard.domain.Member;
import webBoard.JianBoard.mapper.MemberMapper;

import java.util.List;

@Service // 서비스 역할을 하는 것임을 명시
@RequiredArgsConstructor // Mapper 생성자를 사용할 수 있게 함
@Transactional(readOnly = true)
public class MemberService {
    private final MemberMapper memberMapper;
    @Transactional
    public void signUpBoard(Member member) { memberMapper.signUpBoard(member);}
    @Transactional
    public Member getMember(String id) { return memberMapper.getMember(id); }
    public List<Member> MemberList() {
        return memberMapper.getMemberList(); // 게시글 리스트 반환
    }

}
