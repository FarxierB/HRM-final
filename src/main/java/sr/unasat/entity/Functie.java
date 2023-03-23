package sr.unasat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Functie")
public class Functie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "functieId")
    private int functieId;

    @Column(name = "functieType")
    private String functieType;


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="afdelingId")
    private Afdeling afdeling;

    @ManyToMany (mappedBy = "functieSet")
    private Set<Werknemer> werknemerSet =  new HashSet<>();



    public int getFunctieId() {
        return functieId;
    }

    public void setFunctieId(int functieId) {
        this.functieId = functieId;
    }

    public String getFunctieType() {
        return functieType;
    }

    public void setFunctieType(String functieType) {
        this.functieType = functieType;
    }

    public Afdeling getAfdeling() {
        return afdeling;
    }

    public void setAfdeling(Afdeling afdeling) {
        this.afdeling = afdeling;
    }

    public Set<Werknemer> getWerknemerSet() {
        return werknemerSet;
    }

    public void setWerknemerSet(Werknemer werknemer) {
        this.werknemerSet.add(werknemer);
    }
}
