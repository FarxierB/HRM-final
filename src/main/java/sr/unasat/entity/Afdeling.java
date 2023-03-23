package sr.unasat.entity;

import lombok.*;

import jakarta.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Table(name = "Afdeling")
public class Afdeling {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "afdelingId")
    private int afdelingId;

    @Column(name = "afdelingNaam")
    private String afdelingNaam;


    public int getAfdelingId() {
        return afdelingId;
    }

    public void setAfdelingId(int afdelingId) {
        this.afdelingId = afdelingId;
    }

    public String getAfdelingNaam() {
        return afdelingNaam;
    }

    public void setAfdelingNaam(String afdelingNaam) {
        this.afdelingNaam = afdelingNaam;
    }
}
