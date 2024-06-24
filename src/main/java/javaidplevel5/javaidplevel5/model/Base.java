package javaidplevel5.javaidplevel5.model;

import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Base {

    @Column( name = "created_date")
    private LocalDateTime createdDate;
    @Column( name = "deleted_date")
    private LocalDateTime deletedDate;
    @Column( name = "updated_date")
    private LocalDateTime updatedDate;

    
}
