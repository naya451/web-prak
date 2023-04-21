package ru.msu.cmc.webprak.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "sellers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Sellers implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "seller_id")
    private Long id;
    @Column(nullable = false, name = "seller_name")
    @NonNull
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "seller_description")
    private String description;

    public Sellers() {
    }
}