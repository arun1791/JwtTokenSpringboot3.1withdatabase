package com.jwt.security.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Data
@Builder
@ToString
public class JwtResponse {
    private String jwtToken;
    private String user;
}
