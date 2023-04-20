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
public class Supplies implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "supply_id")
    private Long id;
    @Column(nullable = false, name = "supply_date_time")
    @NonNull
    private Long date_time;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "seller_id")
    @ToString.Exclude
    private Sellers seller;
    @Column(name = "supply_comment")
    private String comment;
    @Column(name = "seller_name")
    @NonNull
    private String seller_name;

    public Supplies() {
    }
}