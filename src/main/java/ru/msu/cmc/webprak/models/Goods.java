package ru.msu.cmc.webprak.models;

import lombok.*;

import javax.persistence.*;

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
    @Column(nullable = false, name = "availability")
    @NonNull
    private String availability;
    @Column(name = "good_size1")
    private String size1;
    @Column(name = "good_size2")
    private String size2;
    @Column(name = "good_size3")
    private String address;
    @Column(name = "time_of_keeping")
    private String time_of_keeping;
    @Column(name = "good_description")
    private String description;
    @Column(nullable = false, name = "measurement")
    @NonNull
    private String measurement;

    public Goods() {
    }
}