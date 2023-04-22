package ru.msu.cmc.webprak.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "goods_in_supply")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Goods_in_supply implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "position_id")
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "supply_id")
    @ToString.Exclude
    private Supplies supply;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id")
    @ToString.Exclude
    private Goods good;
    @Column(nullable = false, name = "good_amount")
    @NonNull
    private Long amount;

    public Goods_in_supply() {
    }
}