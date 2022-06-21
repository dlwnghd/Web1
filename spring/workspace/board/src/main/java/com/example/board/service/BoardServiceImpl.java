package com.example.board.service;

import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

//    Service
//    여러 개의 DML을 하나의 서비스로 묶어준다.
@Service
@RequiredArgsConstructor
@Qualifier("board") @Primary
public class BoardServiceImpl implements BoardService{
    private final BoardDAO boardDAO;

    @Override
    public List<BoardVO> getList(Criteria criteria) {return boardDAO.getList(criteria);}

    @Override
    public void register(BoardVO boardVO) {boardDAO.register(boardVO);}

    @Override
    public BoardVO get(Long boardNumber) {
        return boardDAO.findByBoardNumber(boardNumber);
    }

    @Override
    public boolean modify(BoardVO boardVO) {
        return boardDAO.modify(boardVO);
    }

    @Override
    public boolean remove(Long boardNumber) {
        return boardDAO.remove(boardNumber);
    }

    @Override
    public int getTotal() {
        return boardDAO.getTotal();
    }
}
