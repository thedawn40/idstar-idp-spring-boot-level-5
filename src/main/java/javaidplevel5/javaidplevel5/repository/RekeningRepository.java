package javaidplevel5.javaidplevel5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javaidplevel5.javaidplevel5.model.Rekening;


public interface RekeningRepository extends JpaRepository<Rekening, Long> {

    @Query("SELECT k FROM Rekening k")
    Page<Rekening> findAllRekening(Pageable pageable);

    
}
