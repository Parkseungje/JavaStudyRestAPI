package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"orderGroup","item"}) // ToString이 겹쳐서 에러나는것을 방지하는것
@Builder// 예시: User u = User.builder().account(account).password(password).status(status).email(email).build(); 이런식으로 필요한 생성자의 파라미터만 사용할수있다.
@Accessors(chain = true) // 예시 : User u = new User().setAccount("").setEmail("").setPassword("");
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    private String status;

    private LocalDateTime arrivalDate;

    private Integer quantity;

    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    @ManyToOne
    private Item itemId;

    @ManyToOne
    private OrderGroup orderGroup;

    // private Long userId; 원랜 이렇게하지만 어노테이션을 이용하기위해선 아래와같이 객체를 명시해야한다.

    //@ManyToOne // N:1 현재 테이블(클래스)입장에서 생각해야한다. 현재 테이블이 many이고 User테이블이 1인 관계이므로 이렇게 설정한다.
    //private User user; // 이렇게 하면 자동으로 user_id를 찾아간다.

    // private Long itemId;

   // @ManyToOne // N : 1
   // private Item item;
}
