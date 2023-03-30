package ru.msu.cmc.webprak.models;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Goods")
@Getter
@Setter
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Goods implements CommonEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, name = "Good_ID")
    private Long id;

    @Column(nullable = false, name = "Good_name")
    @NonNull
    private String name;

    @Column(name = "Good_type")
    private String type;

    @Column(nullable = false, name = "Availability")
    @NonNull
    private Long availability;

    @Column(name = "Good_size1")
    private Long size1;

    @Column(name = "Good_size2")
    private Long size2;

    @Column(name = "Good_size3")
    private Long size3;

    @Column(name = "Time_of_keeping")
    private java.sql.Date time_of_keeping;

    @Column(name = "Good_description")
    private String description;

    @Column(nullable = false, name = "Measurement")
    @NonNull
    private String measurement;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Goods other = (Goods) o;
        return Objects.equals(id, other.id)
                && name.equals(other.name)
                && Objects.equals(type, other.type)
                && Objects.equals(availability, other.availability)
                && Objects.equals(size1, other.size1)
                && Objects.equals(size2, other.size2)
                && Objects.equals(size3, other.size3)
                && Objects.equals(time_of_keeping, other.time_of_keeping)
                && Objects.equals(description, other.description)
                && Objects.equals(measurement, other.measurement);
    }
}