package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder// 예시: User u = User.builder().account(account).password(password).status(status).email(email).build(); 이런식으로 필요한 생성자의 파라미터만 사용할수있다.
@Accessors(chain = true) // 예시 : User u = new User().setAccount("").setEmail("").setPassword("");
public class OrderGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String orderType; // 주문의 형태 - 일괄인지 개별인지

    private String revName;

    private String paymentType; // 카드인지 현금인지

    private BigDecimal totalPrice;

    private Integer totalQuantity;

    private LocalDateTime orderAt;

    private LocalDateTime arrivalDate;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // OrderGroup N:1
    @ManyToOne
    private User userId;

}
