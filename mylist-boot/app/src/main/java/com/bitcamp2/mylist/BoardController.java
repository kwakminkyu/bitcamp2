package com.bitcamp2.mylist;

import java.sql.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

  @GetMapping("/board/list")
  public Object list() {
    return ArrayList3.toArray(); 
  }

  @GetMapping("/board/add")
  public int add(Board board) {
    board.setCreateDate(new Date(System.currentTimeMillis()));
    ArrayList3.add(board);
    return ArrayList3.size;
  }

  @GetMapping("/board/get")
  public Object get(int index) {
    if (index == -1) {
      return "";
    }
    Board board = (Board)ArrayList3.list[index];
    board.viewCount++;
    return board;
  }

  @GetMapping("/board/update")
  public int update(int index, Board board) {
    if (index == -1) {
      return 0;
    }
    Board old = (Board)ArrayList3.list[index];
    board.viewCount = old.viewCount;
    board.createDate = old.createDate;
    return ArrayList3.set(index,board) == null ? 0 : 1;
  }

  @GetMapping("/board/delete")
  public Object delete(int index) {
    if (index == -1) {
      return 0;
    }
    return ArrayList3.remove(index);
  }
}
