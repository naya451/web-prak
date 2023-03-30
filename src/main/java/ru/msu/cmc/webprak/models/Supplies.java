package ru.msu.cmc.webprak.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Supplies")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Supplies implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Supply_ID")
    private Long id;

    @Column(nullable = false, name = "Supply_date")
    @NonNull
    private java.sql.Date date;

    @Column(nullable = false, name = "Supply_time")
    @NonNull
    private java.sql.Time time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "Seller_ID")
    @ToString.Exclude
    @NonNull
    private Sellers seller;

    @Column(name = "Supply_comment")
    private String comment;

    @Column(nullable = false, name = "Sum_amount")
    @NonNull
    private Long amount;

    @Column(nullable = false, name = "Seller_name")
    @NonNull
    private String name;
}