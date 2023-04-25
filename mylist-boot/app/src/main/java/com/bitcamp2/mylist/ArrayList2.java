package com.bitcamp2.mylist;

public class ArrayList2 {
  static Todo[] list = new Todo[5];
  static int size = 0;

  static Todo[] toArray() {
    Todo[] arr = new Todo[size];
    for (int i = 0; i < size; i++) {
      arr[i] = list[i];
    }
    return arr;
  }

  static void add(Todo Todo) {
    if(list.length == size) {
      list = grow();
    }
    list[size++] = Todo;
  }

  static Todo set(int index, Todo Todo) {
    if (index < 0 || index >= size) {
      return null;
    }
    Todo old = list[index];
    list[index] = Todo;
    return old;
  }

  static Todo[] grow() {
    Todo[] arr = new Todo[newlength()];
    copy(list, arr);
    return arr;
  }

  static int newlength() {
    return list.length + (list.length >> 1);
  }

  static void copy(Todo[] source, Todo[] target) {
    int length = source.length;
    if (target.length < source.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = source[i];
    }
  }

  static Todo remove(int index) {
    Todo old = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i - 1] = list[i];
    }
    size--;
    return old;
  }
}
