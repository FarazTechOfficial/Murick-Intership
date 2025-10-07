package com.murick.e_commerce.payload;

import lombok.*;
import org.springframework.http.HttpStatus;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {
   private String message;
   private HttpStatus status;
   private boolean success;
    private Object data;


}
