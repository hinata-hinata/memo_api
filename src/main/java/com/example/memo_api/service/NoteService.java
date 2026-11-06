package com.example.memo_api.service;

import com.example.memo_api.dto.Note;
import com.example.memo_api.exception.NoteArgumentNotValidException;
import com.example.memo_api.exception.NoteNotFoundException;
import com.example.memo_api.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
  private final NoteRepository noteRepository;

  public NoteService(NoteRepository noteRepository) {
    this.noteRepository = noteRepository;
  }

  public List<Note> findAll() {

    return noteRepository.findAll();
  }

  public Note saveNote(Note note){
    //titleが殻の場合のバリデーション
    if(note.getTitle() == null || note.getTitle().isEmpty()){
      throw new NoteArgumentNotValidException("Title is required");
    }

    if(note.getContent() == null || note.getContent().isEmpty()){
      throw new NoteArgumentNotValidException("Content is required");
    }

    noteRepository.insertNote(note);
    return note;
  }

  public Note findById(long id) {
    Note note = noteRepository.findById(id);

    if (note == null) {
      throw new NoteNotFoundException(id);
    }

    return note;
  }

  public boolean delete(long id)  {
    if(!noteRepository.delete(id)){
      throw new NoteNotFoundException(id);
    }

    return true;
  }

  public Note update(Note note, long id) {
    //titleが殻の場合のバリデーション
    if(note.getTitle() == null || note.getTitle().isEmpty()){
      throw new NoteArgumentNotValidException("Title is required");
    }

    if(note.getContent() == null || note.getContent().isEmpty()){
      throw new NoteArgumentNotValidException("Content is required");
    }

    //指定されたidが存在しないとき
    Note targetNote = noteRepository.findById(id);
    if(targetNote == null){
      throw new NoteNotFoundException(id);
  }

    note.setId(id);
    note.setCreatedAt(targetNote.getCreatedAt());
    return noteRepository.update(note);
  }
}