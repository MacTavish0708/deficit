package testgroup.deficit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "table_type_overflow_volume")
public class TOV {
    @Id
    @Column(name = "TypeOfRailwayTank", nullable = false)
    private String TypeOfRailwayTank;

    @Id
    @Column(name = "Overflow", nullable = false)
    private Short Overflow;

    @Column(name = "VolumeOfTheRailwayTank")
    private Float VolumeOfTheRailwayTank;

    public String getTypeOfRailwayTank() {
        return TypeOfRailwayTank;
    }

    public Short getOverflow() {
        return Overflow;
    }

    public Float getVolumeOfTheRailwayTank() {
        return VolumeOfTheRailwayTank;
    }
}
