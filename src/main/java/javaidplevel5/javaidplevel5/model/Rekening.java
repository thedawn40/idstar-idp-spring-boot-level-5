package javaidplevel5.javaidplevel5.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "rekening")
public class Rekening {
 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "created_date")
    private LocalDateTime createdDate;
    @Column( name = "deleted_date")
    private LocalDateTime deletedDate;
    @Column( name = "updated_date")
    private LocalDateTime updatedDate;

    private String jenis;

    private String nama;
    private String rekening;
    
    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "karyawan", referencedColumnName = "id")
    private Karyawan karyawan;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
        updatedDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }
}
