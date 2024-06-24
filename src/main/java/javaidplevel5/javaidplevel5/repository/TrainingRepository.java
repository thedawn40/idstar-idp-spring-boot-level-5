package javaidplevel5.javaidplevel5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javaidplevel5.javaidplevel5.model.Training;


public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Query("SELECT k FROM Training k")
    Page<Training> findAllTraining(Pageable pageable);

    
}
