package javaidplevel5.javaidplevel5.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class KaryawanDTO {
    
    private Long id;
    private String nama;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;

    @JsonProperty("dob")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dob;
    private String status;
    private String alamat;
    private DetailKaryawanDTO detailKaryawan;
}
