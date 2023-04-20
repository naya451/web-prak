package ru.msu.cmc.webprak.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "warehouse_condition")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Warehouse_condition implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "place_id")
    private Long id;
    @Column(nullable = false, name = "room_id")
    @NonNull
    private Long room;
    @Column(nullable = false, name = "shelf_id")
    @NonNull
    private Long shelf;
    @Column(name = "good_type")
    private String type;
    @Column(name = "shelf_availability")
    private boolean availability;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "good_id")
    @ToString.Exclude
    private Goods good;

    public Warehouse_condition() {
    }
}