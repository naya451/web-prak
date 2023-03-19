package ru.msu.cmc.webprak.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Goods_in_supplies")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Goods_in_supplies implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Position_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "Supply_ID")
    @ToString.Exclude
    @NonNull
    private Supplies supply;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "Good_ID")
    @ToString.Exclude
    @NonNull
    private Goods good;

    @Column(nullable = false, name = "Good_amount")
    @NonNull
    private Long time;
}