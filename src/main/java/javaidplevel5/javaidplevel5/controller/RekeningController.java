package javaidplevel5.javaidplevel5.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javaidplevel5.javaidplevel5.common.ResponseHandler;
import javaidplevel5.javaidplevel5.dto.RekeningDTO;
import javaidplevel5.javaidplevel5.services.RekeningService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class RekeningController {

    @Autowired
    private RekeningService rekeningService;

    @GetMapping(value = "/v1/idstar/rekening/list", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> getAllRekening(@RequestParam(value = "page") String page, @RequestParam(value = "size") String size) {
        return ResponseHandler.successResponse(rekeningService.getAllRekening(page, size));
    }

    @GetMapping("/v1/idstar/rekening/{id}")
    public ResponseEntity<?> getRekeningById(@PathVariable Long id) {
        return ResponseHandler.successResponse(rekeningService.getRekeningById(id));
    }
    

    @PostMapping("/v1/idstar/rekening/save")
    public ResponseEntity<?> createKaryawan(@RequestBody RekeningDTO rekeningDTO) {
        return ResponseHandler.successResponse(rekeningService.createRekening(rekeningDTO));
    }

    @PutMapping("/v1/idstar/rekening/update")
    public ResponseEntity<?> updateRekening(@RequestBody RekeningDTO rekeningDTO) {
        return ResponseHandler.successResponse(rekeningService.updateRekening(rekeningDTO));
    }

    @DeleteMapping("/v1/idstar/rekening/delete")
    public ResponseEntity<?> deleteRekening(@RequestBody RekeningDTO rekeningDTO) {
        return ResponseHandler.successResponse(rekeningService.deleteRekening(rekeningDTO));
    }
}
