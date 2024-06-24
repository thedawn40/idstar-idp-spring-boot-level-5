package javaidplevel5.javaidplevel5.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OauthUserDTO {
    

    private Long id;
    private Boolean notExpired;
    private Boolean notLocked;
    private Boolean credentialNotExpired;
    private Boolean enabled;
    private LocalDateTime expiredVerifyToken;
    private String fullname;
    private String otp;
    private LocalDateTime otpExpiredDate;
    private String password;
    private String username;
    private String verify_token;

}
