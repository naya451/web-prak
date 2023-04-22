package ru.msu.cmc.webprak.models;

import lombok.*;

import jakarta.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sellers other = (Sellers) o;
        return Objects.equals(id, other.id)
                && name.equals(other.name)
                && Objects.equals(phone, other.phone)
                && Objects.equals(email, other.email)
                && Objects.equals(address, other.address)
                && Objects.equals(description, other.description);
    }
}