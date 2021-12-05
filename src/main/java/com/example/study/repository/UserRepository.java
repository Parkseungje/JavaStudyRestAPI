package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Repeatable;
import java.util.Optional;

// JpaRepository<User,Long> 에서 키와 값을 User와 Long으로 한것은 UserRepository이기때문에 User를 불러온것이고, 값은 User엔티티의 아이디값이 Long타입이기때문이다.
@Repository
public interface UserRepository extends JpaRepository<User,Long>{




    // select * from user where account = ?
    //Optional<User> findByAccount(String account); // 여기서 예를 들면 Optional을 주면 User가 있을수도 있고 없을수도 있을때를 가정하는것이다.

    // select * from user where email = ?
    //Optional<User> findByEmail(String email);

    // select * from user where account = ? and email = ?
    // Optional<User> findByAccountAndEmail(String account, String email);
}
