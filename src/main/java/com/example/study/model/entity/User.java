package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor // 모든 멤버변수의 파라미터를 가지는 생성자를 생성
@NoArgsConstructor // 멤버변수의 파라미터를 가지지않는 생성자를 생성
@Entity
@ToString(exclude = {"orderGroup"}) // join을 걸어둔 테이블사이에 ToString이 겹쳐서 에러나는것을 방지하는것
@Builder// 예시: User u = User.builder().account(account).password(password).status(status).email(email).build(); 이런식으로 필요한 생성자의 파라미터만 사용할수있다.
@Accessors(chain = true) // 예시 : User u = new User().setAccount("").setEmail("").setPassword("");
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // @GenneratdeValue 자동생성하는 어노테이션, (strategy = GenerationType.IDENTITY) -> MYSQL에서의 auto_increment기능
    private Long id;

    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // one to many 이기때문에 many는 list 타입으로 받아와야된다.
    private List<OrderGroup> orderGroupList;

    // 1 : N 현재 테이블이 1 상대테이블이 N
   // @OneToMany(fetch = FetchType.LAZY, mappedBy = "user") // mappdeBy에는 매핑할 변수의 이름을 적어준다. 여기서는 User클래스의 user를 매핑해준것이다.
   // private List<OrderDetail> orderDetailList;

}
