package ru.msu.cmc.webprak.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table(name = "buyers")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Buyers implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "buyer_id")
    private Long id;
    @Column(nullable = false, name = "buyer_name")
    @NonNull
    private String name;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "buyer_description")
    private String description;

    public Buyers() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buyers other = (Buyers) o;
        return Objects.equals(id, other.id)
                && name.equals(other.name)
                && Objects.equals(phone, other.phone)
                && Objects.equals(email, other.email)
                && Objects.equals(address, other.address)
                && Objects.equals(description, other.description);
    }
}