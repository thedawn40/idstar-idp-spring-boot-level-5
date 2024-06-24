package javaidplevel5.javaidplevel5.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * TrainingDTO
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingDTO {

    private Long id;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
    private LocalDateTime deletedDate;

    private String pengajar;
    private String tema;

    
}