package javaidplevel5.javaidplevel5.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import javaidplevel5.javaidplevel5.dto.RekeningDTO;
import javaidplevel5.javaidplevel5.model.Rekening;



@Mapper(componentModel = "spring")
public interface RekeningMapper {

    Rekening toEntity(RekeningDTO rekeningDTO);
    RekeningDTO toDTO(Rekening rekening);

    List<RekeningDTO> toListDTO(Page<Rekening> list);
} 
