package ru.msu.cmc.webprak.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Deliveries")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Deliveries implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Delivery_ID")
    private Long id;

    @Column(nullable = false, name = "Delivery_date")
    @NonNull
    private Long date;

    @Column(nullable = false, name = "Delivery_time")
    @NonNull
    private Long time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "Buyer_ID")
    @ToString.Exclude
    @NonNull
    private Buyers buyer;

    @Column(name = "Delivery_comment")
    private String comment;

    @Column(nullable = false, name = "Sum_amount")
    @NonNull
    private Long amount;

    @Column(nullable = false, name = "Buyer_name")
    @NonNull
    private String name;
}