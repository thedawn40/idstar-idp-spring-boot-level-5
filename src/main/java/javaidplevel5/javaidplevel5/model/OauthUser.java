package javaidplevel5.javaidplevel5.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * OauthUser
 */
@Entity
@Data
@Table(name = "oauth_user")
public class OauthUser {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "not_expired")
    private Boolean notExpired;

    @Column( name = "not_locked")
    private Boolean notLocked;

    @Column( name = "credential_not_expired")
    private Boolean credentialNotExpired;

    private Boolean enabled;

    @Column( name = "expired_verify_token")
    private LocalDateTime expiredVerifyToken;

    private String fullname;

    private String otp;
    @Column( name = "otp_expired_date")
    private LocalDateTime otpExpiredDate;

    private String password;
    private String username;

    private String verify_token;
}