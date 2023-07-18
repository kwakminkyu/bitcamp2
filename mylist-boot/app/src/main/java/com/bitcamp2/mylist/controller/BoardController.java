package com.bitcamp2.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bitcamp2.mylist.domain.Board;
import com.bitcamp2.util.ArrayList;

@RestController
public class BoardController {

  ArrayList boardList = new ArrayList();

  public BoardController() throws Exception {
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("boards.ser")));

      //    while(true) {
      //      try {
      //        Board board = (Board)in.readObject();
      //        boardList.add(board);
      //      } catch (Exception e) {
      //        break;
      //      }
      //    }

      boardList = (ArrayList)in.readObject();
      in.close();
    } catch (Exception e) {
      System.out.println("데이턴 로딩 중 오류 발생");
    }
  }

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

  @GetMapping("/board/save")
  public Object save() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("boards.ser")));

    //    for (Object obj : boardList.toArray()) {
    //      out.writeObject(obj);
    //    }

    out.writeObject(boardList);
    out.close();
    return boardList.toArray().length;
  }
}
