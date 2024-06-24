package javaidplevel5.javaidplevel5.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javaidplevel5.javaidplevel5.dto.TrainingDTO;
import javaidplevel5.javaidplevel5.mapper.TrainingMapper;
import javaidplevel5.javaidplevel5.model.Training;
import javaidplevel5.javaidplevel5.repository.TrainingRepository;


@Service
public class TrainingService {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    TrainingMapper trainingMapper;

    public List<TrainingDTO> getAllTraining(String page, String size) {
        Pageable pageable = PageRequest.of(Integer.valueOf(page), Integer.valueOf(size));
        Page<Training> findAll = trainingRepository.findAllTraining(pageable);
        return trainingMapper.toListDTO(findAll);
    }

    public TrainingDTO getTrainingById(long id) {
        Training training = trainingRepository.findById(id).orElse(null);
        return trainingMapper.toDTO(training);
    }

    public TrainingDTO createTraining(TrainingDTO dto){
        Training training = trainingMapper.toEntity(dto);
        Training savedTraining = trainingRepository.save(training);
        return trainingMapper.toDTO(savedTraining);
    }

    public TrainingDTO updateTraining(TrainingDTO trainingDTO) {
        TrainingDTO dto = getTrainingById(trainingDTO.getId());
        Training training = trainingMapper.toEntity(dto);
        training.setId(trainingDTO.getId());
        training.setPengajar(trainingDTO.getPengajar());
        training.setTema(trainingDTO.getTema());
        Training updatedRekening = trainingRepository.save(training);
        return trainingMapper.toDTO(updatedRekening);
    }

    public String deleteTraining(TrainingDTO trainingDTO) {
        String result = "success";
        try {
            TrainingDTO dto = getTrainingById(trainingDTO.getId());
            Training training = trainingMapper.toEntity(dto);
            training.setId(trainingDTO.getId());
            training.setDeletedDate(LocalDateTime.now());
            trainingRepository.save(training);                
        } catch (Exception e) {
            result = e.getMessage();
        }
        return result;
    }
    
}
