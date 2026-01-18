package com.minor.Project.dto;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiErrorDto {
  private LocalDateTime timestamp;
  private int status;
  private String error;
  private String message;
  private String path;
}
