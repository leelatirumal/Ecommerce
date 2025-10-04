package com.example.ecommerce.service;


import com.example.ecommerce.dto.AuthRequest;
import com.example.ecommerce.dto.AuthResponse;
import com.example.ecommerce.model.Users;
import com.example.ecommerce.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepo userRepo;
    public ResponseEntity<?> register(AuthRequest authRequest) {

        Users users= Users.builder().
                username(authRequest.getUsername()).
                password(authRequest.getPassword()).build();

        userRepo.save(users);
        Users users1=userRepo.findByUsername(authRequest.getUsername());
        return ResponseEntity.ok(new AuthResponse(users1.getId(),users1.getUsername(),"sucess"));
    }

    public ResponseEntity<?> login(AuthRequest authRequest) {
        Users user=userRepo.findByUsername(authRequest.getUsername());
        if(user.getPassword().equals(authRequest.getPassword())){
            return ResponseEntity.ok(new AuthResponse(user.getId(), user.getUsername(), "success"));
        }
        else{
            return ResponseEntity.ok(new AuthResponse(-1L,"no ","failed"));
        }
    }
}
