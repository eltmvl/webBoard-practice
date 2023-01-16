package webBoard.JianBoard.mapper;

import org.springframework.stereotype.Repository;
import webBoard.JianBoard.domain.Member;

import java.util.List;

@Repository
public interface MemberMapper {
    void signUpBoard(Member member);
    Member getMember(String id);
    List<Member> getMemberList();
}
