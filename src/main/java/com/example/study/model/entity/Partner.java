package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = {"itemList","category"}) //  private List<Item> itemList; 이 변수명과 맞춰준것이다.
@Builder// 예시: User u = User.builder().account(account).password(password).status(status).email(email).build(); 이런식으로 필요한 생성자의 파라미터만 사용할수있다.
@Accessors(chain = true) // 예시 : User u = new User().setAccount("").setEmail("").setPassword("");
public class Partner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String status;

    private String address;

    private String callCenter;

    private String partenrNumber;

    private String businessNumber;

    private String ceoName;

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    @ManyToOne
    private Category category;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partner")
    private List<Item> itemList;

}
