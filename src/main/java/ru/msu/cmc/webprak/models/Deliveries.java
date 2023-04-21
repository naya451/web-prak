package ru.msu.cmc.webprak.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "deliveries")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Deliveries implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "delivery_id")
    private Long id;
    @Column(nullable = false, name = "delivery_date_time")
    @NonNull
    private java.sql.Date date_time;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "buyer_id")
    @ToString.Exclude
    private Buyers buyer;
    @Column(name = "delivery_comment")
    private String comment;
    @Column(name = "buyer_name")
    @NonNull
    private String buyer_name;

    public Deliveries() {
    }
}