package com.example.JwtAuthentication.Models;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name="`user`")
public class User
{
    @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
     Integer userId;
     String uname;
     String password;
     String email;

}
