package javaidplevel5.javaidplevel5.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import javaidplevel5.javaidplevel5.dto.KaryawanDTO;
import javaidplevel5.javaidplevel5.model.Karyawan;


/**
 * KaryawanMapper
 */
@Mapper(componentModel = "spring")
public interface KaryawanMapper {
    
    KaryawanMapper INSTANCE = Mappers.getMapper(KaryawanMapper.class);

    KaryawanDTO karyawanToKaryawanDTO(Karyawan karyawan);
    Karyawan karyawanDTOToKaryawan(KaryawanDTO karyawanDTO);
}