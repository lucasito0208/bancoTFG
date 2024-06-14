package com.lucasDev.imagin_banco.mapper;

import com.lucasDev.imagin_banco.entity.OpB;
import com.lucasDev.imagin_banco.model.dtos.OpBDto;

public interface OpBMapper {

    OpBDto toOpBDto(OpB opB);

    OpB toOpBEntity(OpBDto opB);
}
