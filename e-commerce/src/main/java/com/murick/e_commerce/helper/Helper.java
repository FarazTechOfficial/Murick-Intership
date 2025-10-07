package com.murick.e_commerce.helper;

import com.murick.e_commerce.payload.PageableResponse;
import com.murick.e_commerce.transformer.Transformer;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public class Helper {
    public static <E,D> PageableResponse<D> getPageableResponse(Page<E> page, Transformer<E,D> transformer){
        List<D> collect = page.getContent().stream().map(transformer::toDto).collect(Collectors.toList());
        PageableResponse<D> pageableResponse = new PageableResponse<>();
        pageableResponse.setData(collect);
        pageableResponse.setPageSize(page.getSize());
        pageableResponse.setLastPage(page.isLast());
        pageableResponse.setTotalElements((int) page.getTotalElements());
        pageableResponse.setPageNo(page.getNumber());
        return pageableResponse;
    }

}
