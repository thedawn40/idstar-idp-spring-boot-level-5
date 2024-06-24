package javaidplevel5.javaidplevel5.model;

import java.time.LocalDate;
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
import lombok.Data;

@Entity
@Data
public class Karyawan {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "created_date")
    private LocalDateTime createdDate;
    @Column( name = "deleted_date")
    private LocalDateTime deletedDate;
    @Column( name = "updated_date")
    private LocalDateTime updatedDate;

    private String alamat;

    private LocalDate dob;
    

    private String nama;
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_karyawan", referencedColumnName = "id")
    private DetailKaryawan detailKaryawan;

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

