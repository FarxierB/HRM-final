package sr.unasat.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "WerkUren")
public class WerkUren {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "werkUrenId")
    private int werkurenId;

    @Column(name = "maand")
    private String maand;

    @Column(name = "gewerkteUren")
    private double gewerkteUren;

    @Column(name = "uurLoon")
    private double uurLoon;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "werknemer_id")
    private Werknemer werknemer;

    public int getWerkurenId() {
        return werkurenId;
    }

    public void setWerkurenId(int werkurenId) {
        this.werkurenId = werkurenId;
    }

    public String getMaand() {
        return maand;
    }

    public void setMaand(String maand) {
        this.maand = maand;
    }

    public double getGewerkteUren() {
        return gewerkteUren;
    }

    public void setGewerkteUren(double gewerkteUren) {
        this.gewerkteUren = gewerkteUren;
    }

    public double getUurLoon() {
        return uurLoon;
    }

    public void setUurLoon(double uurLoon) {
        this.uurLoon = uurLoon;
    }

    public Werknemer getWerknemer() {
        return werknemer;
    }

    public void setWerknemer(Werknemer werknemer) {
        this.werknemer = werknemer;
    }


    @Override
    public String toString() {
        return "WerkUren{" +
                "WerkurenId = " + werkurenId +
                ", Maand = " + maand +
                ", GewerkteUren = " + gewerkteUren +
                ", UurLoon = " + uurLoon +
                ", Werknemer = " + werknemer +
                "}";
    }
}
