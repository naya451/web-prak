package ru.msu.cmc.webprak.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Deliveries implements CommonEntity<Long> {
    public Deliveries() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "delivery_id")
    private Long id;

    @Column(nullable = false, name = "delivery_date_time")
    @NonNull
    private Long date_time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    @ToString.Exclude
    private Buyers buyer;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @Column(name = "buyer_description")
    private String description;
}