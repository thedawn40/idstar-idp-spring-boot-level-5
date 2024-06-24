package javaidplevel5.javaidplevel5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javaidplevel5.javaidplevel5.common.ResponseHandler;
import javaidplevel5.javaidplevel5.dto.TrainingDTO;
import javaidplevel5.javaidplevel5.repository.TrainingRepository;
import javaidplevel5.javaidplevel5.services.TrainingService;

@RestController
public class TrainingController {

    @Autowired
    TrainingRepository trainingRepository;

    @Autowired
    private TrainingService trainingService;

    @GetMapping(value = "/v1/idstar/training/list", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> getAllTraining(@RequestParam(value = "page") String page, @RequestParam(value = "size") String size) {
        return ResponseHandler.successResponse(trainingService.getAllTraining(page, size));
    }

    @GetMapping("/v1/idstar/training/{id}")
    public ResponseEntity<?> getTrainingById(@PathVariable Long id) {
        return ResponseHandler.successResponse(trainingService.getTrainingById(id));
    }

    @PostMapping("/v1/idstar/training/save")
    public ResponseEntity<?> createTraining(@RequestBody TrainingDTO trainingDTO) {
        return ResponseHandler.successResponse(trainingService.createTraining(trainingDTO));
    }

    @PutMapping("/v1/idstar/training/update")
    public ResponseEntity<?> updateTraining(@RequestBody TrainingDTO trainingDTO) {
        return ResponseHandler.successResponse(trainingService.updateTraining(trainingDTO));
    }

    @DeleteMapping("/v1/idstar/training/delete")
    public ResponseEntity<?> deleteTranining(@RequestBody TrainingDTO trainingDTO) {
        return ResponseHandler.successResponse(trainingService.deleteTraining(trainingDTO));
    }
    
}
