package com.lucasDev.imagin_banco.mapper;

import com.lucasDev.imagin_banco.entity.OpA;
import com.lucasDev.imagin_banco.entity.OpB;
import com.lucasDev.imagin_banco.model.dtos.OpADto;

public interface OpAMapper {

    OpADto toOpADto(OpB opA);

    OpA toOpAEntity(OpADto opA);
}
