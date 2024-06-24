package javaidplevel5.javaidplevel5.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javaidplevel5.javaidplevel5.model.Karyawan;


@Repository
public interface KaryawanRepository extends JpaRepository<Karyawan, Long> {

    @Query("SELECT k FROM Karyawan k")
    Page<Karyawan> findAllKaryawan(Pageable pageable);

    
}
