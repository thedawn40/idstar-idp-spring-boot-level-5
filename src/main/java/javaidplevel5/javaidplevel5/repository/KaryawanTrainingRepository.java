package javaidplevel5.javaidplevel5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javaidplevel5.javaidplevel5.model.KaryawanTraining;


public interface KaryawanTrainingRepository extends JpaRepository<KaryawanTraining, Long> {
    
    @Query("SELECT k FROM KaryawanTraining k")
    Page<KaryawanTraining> findAllTraining(Pageable pageable);

}
