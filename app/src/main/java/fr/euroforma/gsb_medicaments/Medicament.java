package fr.euroforma.gsb_medicaments;

public class Medicament {
    private int codeCIS;
    private String denomination;
    private String formePharmaceutique;
    private String voiesAdmin;
    private String titulaires;
    private String statutAdmnistratif;
    private String NbMolecule;

    // Constructeur

    // Getter et Setter pour codeCIS
    public int getCodeCIS() {
        return codeCIS;
    }

    public void setCodeCIS(int codeCIS) {
        this.codeCIS = codeCIS;
    }

    // Getter et Setter pour denomination
    public String getDenomination() {
        return denomination;
    }

    public void setDenomination(String denomination) {
        this.denomination = denomination;
    }

    // Getter et Setter pour formePharmaceutique
    public String getFormePharmaceutique() {
        return formePharmaceutique;
    }

    public void setFormePharmaceutique(String formePharmaceutique) {
        this.formePharmaceutique = formePharmaceutique;
    }

    // Getter et Setter pour voiesAdmin
    public String getVoiesAdmin() {
        return voiesAdmin;
    }

    public void setVoiesAdmin(String voiesAdmin) {
        this.voiesAdmin = voiesAdmin;
    }

    // Getter et Setter pour titulaires
    public String getTitulaires() {
        return titulaires;
    }

    public void setTitulaires(String titulaires) {
        this.titulaires = titulaires;
    }

    // Getter et Setter pour StatutAdmnistratif
    public String getStatutAdmnistratif(){return statutAdmnistratif; }

    public void setStatutAdministratif(String statutAdmnistratif) { this.statutAdmnistratif= statutAdmnistratif;}
    // Getter et Setter pour nbmolecule
    public String getNbMolecule(){return NbMolecule; }

    public void setNbMolecule(String NbMolecule) { this.NbMolecule= NbMolecule;}
}

