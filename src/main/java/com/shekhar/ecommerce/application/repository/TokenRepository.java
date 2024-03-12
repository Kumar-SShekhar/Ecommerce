package com.shekhar.ecommerce.application.repository;

import com.shekhar.ecommerce.application.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {

//    @Query("SELECT t FROM Token t INNER JOIN t.user u WHERE u.id = :id AND (t.expired = false OR t.revoked = false)")
//    List<Token> findAllValidTokensByUser(Long id);

    List<Token> findAllByUserIdAndIsExpiredFalseAndIsRevokedFalse(Long userId);


    Optional<Token> findByToken(String token);
}
