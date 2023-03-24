package sr.unasat.dto;

import sr.unasat.entity.Functie;
import sr.unasat.entity.Werknemer;

import java.util.Set;

public class WerknemerDTO {
    private int id;

    private String voorNaam;

    private String achterNaam;

    private String email;

    private Set<Functie> functieSet;


    public WerknemerDTO(Werknemer werknemer){
        this.id = werknemer.getWerknemerId();
        this.voorNaam = werknemer.getVoorNaam();
        this.achterNaam = werknemer.getAchterNaam();
        this.email = werknemer.getEmail();
        this.functieSet = werknemer.getFunctieSet();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setFunctieSet(Set<Functie> functieSet) {
        this.functieSet = functieSet;
    }

    @Override
    public String toString() {
        return "Werknemer{" +
                "WerknemerId = " + id +
                ", VoorNaam = " + voorNaam +
                ", AchterNaam = " + achterNaam +
                ", Email = " + email +
                ", Functie = " + functieSet +
                "}";
    }
}
