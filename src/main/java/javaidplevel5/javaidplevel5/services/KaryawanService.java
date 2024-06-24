package javaidplevel5.javaidplevel5.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javaidplevel5.javaidplevel5.dto.KaryawanDTO;
import javaidplevel5.javaidplevel5.mapper.KaryawanMapper;
import javaidplevel5.javaidplevel5.model.Karyawan;
import javaidplevel5.javaidplevel5.repository.KaryawanRepository;


@Service
public class KaryawanService {

    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    KaryawanMapper karyawanMapper;

    public List<KaryawanDTO> getAllKaryawan(String page, String size) {
        Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));
        return karyawanRepository.findAllKaryawan(pageable)
            .stream()
            .map(KaryawanMapper.INSTANCE::karyawanToKaryawanDTO)
            .collect(Collectors.toList());
    }

    public KaryawanDTO getKaryawanById(Long id) {
        Karyawan karyawan = karyawanRepository.findById(id).orElse(null);
        return karyawanMapper.karyawanToKaryawanDTO(karyawan);
    }

    public KaryawanDTO createKaryawan(KaryawanDTO karyawanDTO) {
        Karyawan karyawan = KaryawanMapper.INSTANCE.karyawanDTOToKaryawan(karyawanDTO);
        Karyawan savedKaryawan = karyawanRepository.save(karyawan);
        return KaryawanMapper.INSTANCE.karyawanToKaryawanDTO(savedKaryawan);
    }

    public KaryawanDTO updateKaryawan(KaryawanDTO karyawanDTO) {
        KaryawanDTO dto = getKaryawanById(karyawanDTO.getId());
        Karyawan karyawan = karyawanMapper.karyawanDTOToKaryawan(dto);
        karyawan.setId(karyawanDTO.getId());
        Karyawan updatedKaryawan = karyawanRepository.save(karyawan);
        return KaryawanMapper.INSTANCE.karyawanToKaryawanDTO(updatedKaryawan);
    }

    public KaryawanDTO deleteKaryawan(KaryawanDTO karyawanDTO) {
        KaryawanDTO dto = getKaryawanById(karyawanDTO.getId());
        Karyawan karyawan = karyawanMapper.karyawanDTOToKaryawan(dto);
        karyawan.setId(karyawanDTO.getId());
        karyawan.setStatus("inactive");
        karyawan.setDeletedDate(LocalDateTime.now());
        Karyawan updatedKaryawan = karyawanRepository.save(karyawan);
        return KaryawanMapper.INSTANCE.karyawanToKaryawanDTO(updatedKaryawan);
    }
    
}
