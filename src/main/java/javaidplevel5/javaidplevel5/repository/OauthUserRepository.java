package javaidplevel5.javaidplevel5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import javaidplevel5.javaidplevel5.model.OauthUser;

public interface OauthUserRepository extends JpaRepository<OauthUser, Long>{
     
}
