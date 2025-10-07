package com.murick.e_commerce.payload;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageableResponse<D> {

    private List<D> Data;// banks
    private int pageSize;
    private int totalElements;
    private int pageNo;
    private int totalPage;
    private boolean lastPage;


}
