package com.bitcamp2.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.domain.Board;
import com.bitcamp2.util.ArrayList;

@RestController
public class BoardController {

  ArrayList boardList = new ArrayList();

  @GetMapping("/board/list")
  public Object list() {
    return boardList.toArray(); 
  }

  @GetMapping("/board/add")
  public int add(Board board) {
    board.setCreateDate(new Date(System.currentTimeMillis()));
    boardList.add(board);
    return boardList.size();
  }

  @GetMapping("/board/get")
  public Object get(int index) {
    if (index == -1) {
      return "";
    }
    Board board = (Board)boardList.get(index);
    board.setViewCount(board.getViewCount() + 1);
    return board;
  }

  @GetMapping("/board/update")
  public int update(int index, Board board) {
    if (index == -1) {
      return 0;
    }
    Board old = (Board)boardList.get(index);
    board.setViewCount(old.getViewCount());
    board.setCreateDate(old.getCreateDate());
    return boardList.set(index,board) == null ? 0 : 1;
  }

  @GetMapping("/board/delete")
  public Object delete(int index) {
    return boardList.remove(index) == null ? 0 : 1;
  }
}
