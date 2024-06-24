package javaidplevel5.javaidplevel5.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javaidplevel5.javaidplevel5.dto.RekeningDTO;
import javaidplevel5.javaidplevel5.mapper.RekeningMapper;
import javaidplevel5.javaidplevel5.model.Rekening;
import javaidplevel5.javaidplevel5.repository.KaryawanRepository;
import javaidplevel5.javaidplevel5.repository.RekeningRepository;


@Service
public class RekeningService {

    @Autowired
    RekeningRepository rekeningRepository;

    @Autowired
    RekeningMapper rekeningMapper;

    @Autowired
    KaryawanRepository karyawanRepository;


    public List<RekeningDTO> getAllRekening(String page, String size) {
        Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));
        Page<Rekening> findAll = rekeningRepository.findAllRekening(pageable);
        return rekeningMapper.toListDTO(findAll);
    }

    public RekeningDTO getRekeningById(long id) {
        Rekening rekening = rekeningRepository.findById(id).orElse(null);
        return rekeningMapper.toDTO(rekening);
    }

    public RekeningDTO createRekening(RekeningDTO dto){
        Rekening rekening = rekeningMapper.toEntity(dto);
        Rekening savedRekening = rekeningRepository.save(rekening);
        savedRekening.setKaryawan(karyawanRepository.getReferenceById(dto.getKaryawan().getId()));
        return rekeningMapper.toDTO(savedRekening);
    }

    public RekeningDTO updateRekening(RekeningDTO rekeningDTO) {
        RekeningDTO dto = getRekeningById(rekeningDTO.getId());
        Rekening rekening = rekeningMapper.toEntity(dto);
        rekening.setId(rekeningDTO.getId());
        rekening.setJenis(rekeningDTO.getJenis());
        rekening.setNama(rekeningDTO.getNama());
        rekening.setRekening(rekeningDTO.getRekening());
        Rekening updatedRekening = rekeningRepository.save(rekening);
        updatedRekening.setKaryawan(karyawanRepository.getReferenceById(dto.getKaryawan().getId()));
        return rekeningMapper.toDTO(updatedRekening);
    }

    public RekeningDTO deleteRekening(RekeningDTO rekeningDTO) {
        RekeningDTO dto = getRekeningById(rekeningDTO.getId());
        Rekening rekening = rekeningMapper.toEntity(dto);
        rekening.setId(rekeningDTO.getId());
        rekening.setDeletedDate(LocalDateTime.now());
        Rekening updateRekening = rekeningRepository.save(rekening);
        return rekeningMapper.toDTO(updateRekening);
    }
}
