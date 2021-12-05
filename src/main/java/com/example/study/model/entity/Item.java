package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder// 예시: User u = User.builder().account(account).password(password).status(status).email(email).build(); 이런식으로 필요한 생성자의 파라미터만 사용할수있다.
@Accessors(chain = true) // 예시 : User u = new User().setAccount("").setEmail("").setPassword("");
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    private String name;

    private String title;

    private String content;

    private Integer price;

    private String brandName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    // Item N : 1 Partner
    @ManyToOne
    private Partner partnerId;

    // Item N : 1 OrderDetail
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "item")
    private List<OrderDetail> orderDetailList;




    // LAZY = 지연로딩, EAGER = 즉시로딩
    // LAZY = select * from item where id = ?
    // EAGER = 테이블들을 조인하여 쿼리문이 매우길어진다. 주로 1:1 관계에서만 사용한다.
    //@OneToMany(fetch = FetchType.LAZY, mappedBy = "item") // 1:N  1은 현재 클래스, N은 매핑되는 객체
    //private List<OrderDetail> orderDetailList;
}
