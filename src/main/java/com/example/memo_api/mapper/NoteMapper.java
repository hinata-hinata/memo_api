package com.example.memo_api.mapper;

import com.example.memo_api.dto.Note;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NoteMapper {

  @Select("select id, title, content, created_at from notes order by created_at desc")
  List<Note> selectAll();

  @Insert("insert into notes (title, content) values(#{title}, #{content})")
  @Options(useGeneratedKeys = true, keyProperty = "id,createdAt", keyColumn = "id,created_at")
  int insert(Note note);

  @Select("select id, title, content, created_at from notes where id = #{id}")
  Note findById(long id);

  @Delete("delete from notes where id = #{id}")
  int delete(long id);

  @Update("update notes set title = #{title}, content = #{content} where id = #{id}")
  int update(Note note);
}
