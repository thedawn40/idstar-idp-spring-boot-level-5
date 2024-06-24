package javaidplevel5.javaidplevel5.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import javaidplevel5.javaidplevel5.dto.KaryawanTrainingDTO;
import javaidplevel5.javaidplevel5.model.KaryawanTraining;



@Mapper(componentModel = "spring")
public interface KaryawanTrainingMapper {

    KaryawanTraining toEntity(KaryawanTrainingDTO karyawanTrainingDTO);

    KaryawanTrainingDTO toDTO(KaryawanTraining karyawanTraining);

    List<KaryawanTrainingDTO> toListDTO(Page<KaryawanTraining> karyawanTraining);
    
}
