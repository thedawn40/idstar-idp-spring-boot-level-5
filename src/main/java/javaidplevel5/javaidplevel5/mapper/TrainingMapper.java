package javaidplevel5.javaidplevel5.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import javaidplevel5.javaidplevel5.dto.TrainingDTO;
import javaidplevel5.javaidplevel5.model.Training;


@Mapper(componentModel = "spring")
public interface TrainingMapper {
    
    Training toEntity(TrainingDTO trainingDTO);

    TrainingDTO toDTO(Training training);

    List<TrainingDTO> toListDTO(Page<Training> training);

}
