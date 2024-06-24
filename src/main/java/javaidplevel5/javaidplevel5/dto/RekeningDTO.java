package javaidplevel5.javaidplevel5.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RekeningDTO {

    private Long id;
    private LocalDateTime createdDate;
    private LocalDateTime deletedDate;
    private LocalDateTime updatedDate;
    private String jenis;
    private String nama;
    private String rekening;
    private KaryawanDTO karyawan;
    
}
