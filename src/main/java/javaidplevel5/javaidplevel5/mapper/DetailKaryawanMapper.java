package javaidplevel5.javaidplevel5.mapper;

import org.mapstruct.Mapper;

import javaidplevel5.javaidplevel5.dto.DetailKaryawanDTO;
import javaidplevel5.javaidplevel5.model.DetailKaryawan;


@Mapper(componentModel = "spring")
public interface DetailKaryawanMapper {
    
    // DetailKaryawanMapper INSTANCE = Mappers.getMapper(DetailKaryawanMapper.class);

    DetailKaryawanDTO detailKaryawanToDetailKaryawanDTO(DetailKaryawan detailKaryawan);
    DetailKaryawan detailKaryawanDTOToDetailKaryawan(DetailKaryawanDTO detailKaryawanDTO);
}
