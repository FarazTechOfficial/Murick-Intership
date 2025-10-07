package com.murick.e_commerce.transformer;

import java.util.List;

public interface Transformer<E,D> {

    D toDto(E entity);
    E toEntity(D dto);
    E toUpdate(E entity, D dto);
    List<D> toDtoList(List<E> entity);
}
