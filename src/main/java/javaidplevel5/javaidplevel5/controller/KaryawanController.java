package javaidplevel5.javaidplevel5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javaidplevel5.javaidplevel5.common.ResponseHandler;
import javaidplevel5.javaidplevel5.dto.KaryawanDTO;
import javaidplevel5.javaidplevel5.repository.KaryawanRepository;
import javaidplevel5.javaidplevel5.services.KaryawanService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class KaryawanController {

    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    private KaryawanService karyawanService;

    @GetMapping(value = "/v1/idstar/karyawan/list", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> getAllKaryawan(@RequestParam(value = "page") String page, @RequestParam(value = "size") String size) {
        return ResponseHandler.successResponse(karyawanService.getAllKaryawan(page, size));
    }

    @GetMapping("/v1/idstar/karyawan/{id}")
    public ResponseEntity<?> getKaryawanById(@PathVariable Long id) {
        return ResponseHandler.successResponse(karyawanService.getKaryawanById(id));
    }

    @PostMapping("/v1/idstar/karyawan/save")
    public ResponseEntity<?> createKaryawan(@RequestBody KaryawanDTO karyawanDTO) {
        return ResponseHandler.successResponse(karyawanService.createKaryawan(karyawanDTO));
    }

    @PutMapping("/v1/idstar/karyawan/update")
    public ResponseEntity<?> updateKaryawan(@RequestBody KaryawanDTO karyawanDTO) {
        return ResponseHandler.successResponse(karyawanService.updateKaryawan(karyawanDTO));
    }

    @DeleteMapping("/v1/idstar/karyawan/delete")
    public ResponseEntity<?> deleteKaryawan(@RequestBody KaryawanDTO karyawanDTO) {
        return ResponseHandler.successResponse(karyawanService.deleteKaryawan(karyawanDTO));
    }
    
    
    
}
