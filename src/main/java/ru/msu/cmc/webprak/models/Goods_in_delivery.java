package ru.msu.cmc.webprak.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "goods_in_delivery")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Goods_in_delivery implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "position_id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "delivery_id")
    @ToString.Exclude
    private Deliveries delivery;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id")
    @ToString.Exclude
    private Goods good;
    @Column(nullable = false, name = "good_amount")
    @NonNull
    private Long amount;

    public Goods_in_delivery() {
    }
}