package com.example.memo_api.exception;

public class NoteNotFoundException extends RuntimeException {
  public NoteNotFoundException(long id) {
    super("指定されたidのノートが見つかりません" + id);
  }
}
