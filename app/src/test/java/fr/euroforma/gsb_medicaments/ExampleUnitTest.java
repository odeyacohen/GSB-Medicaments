package fr.euroforma.gsb_medicaments;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

        public void checkMedicament() {
            // Context of the app under test.
            Medicament medicament = new Medicament();
            medicament.setCodeCIS(1234);
            medicament.setDenomination("Dolipran");
            medicament.setFormePharmaceutique("Fake formePharmaceutiqueMedicament");
            medicament.setVoiesAdmin("Fake voiesAdminMedicament");
            medicament.setTitulaires("Fake titulairesMedicament");
            medicament.setStatutAdministratif("Fake statutAdministratif");
            medicament.setNbMolecule("Fake NbMolecule");
            assertEquals("Dolipran", medicament.getDenomination());

        }

}