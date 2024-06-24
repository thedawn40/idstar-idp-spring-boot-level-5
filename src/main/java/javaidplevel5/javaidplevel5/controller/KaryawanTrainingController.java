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
import javaidplevel5.javaidplevel5.dto.KaryawanTrainingDTO;
import javaidplevel5.javaidplevel5.repository.KaryawanTrainingRepository;
import javaidplevel5.javaidplevel5.services.KaryawanTrainingService;


@RestController
public class KaryawanTrainingController {

    @Autowired
    KaryawanTrainingRepository karyawanTrainingRepository;

    @Autowired
    private KaryawanTrainingService karyawanTrainingService;

    @GetMapping(value = "/v1/idstar/karyawan-training/list", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> getAllTraining(@RequestParam(value = "page") String page, @RequestParam(value = "size") String size) {
        return ResponseHandler.successResponse(karyawanTrainingService.getAllKaryawanTraining(page, size));
    }

    @GetMapping("/v1/idstar/karyawan-training/{id}")
    public ResponseEntity<?> getTrainingById(@PathVariable Long id) {
        return ResponseHandler.successResponse(karyawanTrainingService.getKaryawanTrainingById(id));
    }

    @PostMapping("/v1/idstar/karyawan-training/save")
    public ResponseEntity<?> createTraining(@RequestBody KaryawanTrainingDTO dto) {
        return ResponseHandler.successResponse(karyawanTrainingService.createKaryawanTraining(dto));
    }

    @PutMapping("/v1/idstar/karyawan-training/update")
    public ResponseEntity<?> updateTraining(@RequestBody KaryawanTrainingDTO dto) {
        return ResponseHandler.successResponse(karyawanTrainingService.updateKaryawanTraining(dto));
    }

    @DeleteMapping("/v1/idstar/karyawan-training/delete")
    public ResponseEntity<?> deleteTranining(@RequestBody KaryawanTrainingDTO dto) {
        return ResponseHandler.successResponse(karyawanTrainingService.deleteKaryawanTraining(dto));
    }
    
    
}
