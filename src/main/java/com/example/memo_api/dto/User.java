package com.example.memo_api.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class User {
  private long useId;
  private String username;
  private String password;
  private LocalDateTime craatedAt;
}
