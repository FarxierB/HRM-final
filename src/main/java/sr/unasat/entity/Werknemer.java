package sr.unasat.entity;

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
@Table(name = "Werknemer")
public class Werknemer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "werknemerId")
    private int werknemerId;

    @Column(name = "voorNaam")
    private String voorNaam;

    @Column(name = "achterNaam")
    private String achterNaam;

    @Column(name = "email")
    private String email;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Werknemer_Functie",
            joinColumns = @JoinColumn(name = "werknemer_id"),
            inverseJoinColumns = @JoinColumn(name = "functie_id"))
    private Set<Functie> functieSet = new HashSet<>();

    public int getWerknemerId() {
        return werknemerId;
    }

    public void setWerknemerId(int werknemerId) {
        this.werknemerId = werknemerId;
    }

    public String getVoorNaam() {
        return voorNaam;
    }

    public void setVoorNaam(String voorNaam) {
        this.voorNaam = voorNaam;
    }

    public String getAchterNaam() {
        return achterNaam;
    }

    public void setAchterNaam(String achterNaam) {
        this.achterNaam = achterNaam;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Functie> getFunctieSet() {
        return functieSet;
    }

    public void setFunctieSet(Functie functie) {
        this.functieSet.add(functie);
    }
}
