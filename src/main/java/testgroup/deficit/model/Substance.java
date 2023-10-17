package testgroup.deficit.model;

import jakarta.persistence.*;

@Entity
@Table(name = "table_substance")
public class Substance {
    @Id
    @Column(name = "Id", nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "Substance", nullable = false, unique = true)
    String Substance;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getSubstance() {
        return Substance;
    }

    public void setSubstance(String substance) {
        Substance = substance;
    }
}
