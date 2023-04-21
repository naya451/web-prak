package ru.msu.cmc.webprak.models;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "goods")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
public class Goods implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "good_id")
    private Long id;
    @Column(nullable = false, name = "good_name")
    @NonNull
    private String name;
    @Column(name = "good_type")
    private String type;
    @Column(name = "good_size1")
    private Long size1;
    @Column(name = "good_size2")
    private Long size2;
    @Column(name = "good_size3")
    private Long address;
    @Column(name = "time_of_keeping")
    private Long time_of_keeping;
    @Column(name = "good_description")
    private String description;
    @Column(nullable = false, name = "measurement")
    @NonNull
    private String measurement;

    public Goods() {
    }
}