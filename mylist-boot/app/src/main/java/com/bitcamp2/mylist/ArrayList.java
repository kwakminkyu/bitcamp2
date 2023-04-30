package com.bitcamp2.mylist;

public class ArrayList {
  Object[] list = new Object[5];
  int size = 0;

  Object[] toArray() {
    Object[] arr = new Object[size];
    for (int i = 0; i < size; i++) {
      arr[i] = list[i];
    }
    return arr;
  }

  void add(Object obj) {
    if(list.length == size) {
      list = grow();
    }
    list[size++] = obj;
  }

  Object set(int index, Object obj) {
    if (index < 0 || index >= size) {
      return null;
    }
    Object old = list[index];
    list[index] = obj;
    return old;
  }

  Object remove(int index) {
    Object old = list[index];
    for (int i = index + 1; i < size; i++) {
      list[i - 1] = list[i];
    }
    size--;
    return old;
  }

  Object[] grow() {
    Object[] arr = new Object[newlength()];
    copy(arr);
    return arr;
  }

  int newlength() {
    return list.length + (list.length >> 1);
  }

  void copy(Object[] target) {
    int length = list.length;
    if (target.length < list.length) {
      length = target.length;
    }
    for (int i = 0; i < length; i++) {
      target[i] = list[i];
    }
  }
}
