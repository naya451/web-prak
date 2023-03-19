package ru.msu.cmc.webprak.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Warehouse_condition")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Warehouse_condition implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Place_ID")
    private Long id;

    @Column(nullable = false, name = "Room_ID")
    @NonNull
    private Long room;

    @Column(nullable = false, name = "Shelf_ID")
    @NonNull
    private Long shelf;

    @Column(name = "Goods_type")
    private String type;

    @Column(name = "Shelf_availability")
    private Boolean availability;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Good_ID")
    @ToString.Exclude
    private Goods good_id;
}