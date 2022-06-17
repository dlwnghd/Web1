package com.example.board.mapper;

import com.example.board.domain.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;    // 빨간줄은 버그임(무시)

//    @Test
//    public void getListTest(){
//        boardMapper.getList().stream().map(BoardVO::toString).forEach(log::info);
//    }

    @Test
    public void insertTest(){
        BoardVO boardVO = new BoardVO();
        boardVO.setBoardTitle("새롭게 추가된 게시글 제목1");
        boardVO.setBoardContent("새롭게 추가된 게시글 내용1");
        boardVO.setBoardWriter("new1");

        boardMapper.insert(boardVO);
    }
}
