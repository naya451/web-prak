package ru.msu.cmc.webprak.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Goods_in_delivery")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Goods_in_delivery implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Position_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "Delivery_ID")
    @ToString.Exclude
    @NonNull
    private Deliveries delivery;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "Good_ID")
    @ToString.Exclude
    @NonNull
    private Goods good;

    @Column(nullable = false, name = "Good_amount")
    @NonNull
    private java.sql.Time time;
}