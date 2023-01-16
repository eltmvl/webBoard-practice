package webBoard.JianBoard.mapper;

import lombok.extern.java.Log;
import org.springframework.stereotype.Repository;
import webBoard.JianBoard.domain.Board;

import java.util.List;

@Repository
public interface BoardMapper {
    int boardCount();
    List<Board> getList();
    Board getBoard(Long boardID);
    void uploadBoard(Board board);
    void updateBoard(Board board);
    void deleteBoard(Long boardID);

}
