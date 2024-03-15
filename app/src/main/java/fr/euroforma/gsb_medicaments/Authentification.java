package fr.euroforma.gsb_medicaments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;



public class Authentification extends AppCompatActivity {
    private boolean isUserAuthenticated() {
        SharedPreferences preferences = getSharedPreferences(PREF_NAME,MODE_PRIVATE);

        String userStatus = preferences.getString(KEY_USER_STATUS, "authentifié");

        // Vérifiez si la chaîne d'état de l'utilisateur est "Authentifie=OK"
        return "Authentifié".equals(userStatus);
    }

    private static final String PREF_NAME = "UserPrefs";
    private static final String SECURETOKEN = "BethElicheva5";
    private static final String KEY_USER_STATUS = "userStatus";
    private void setUserStatus(String status) {
        SharedPreferences sharedPreferences = getSharedPreferences(PREF_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_USER_STATUS, status);
        editor.apply();
    }


    private EditText codeRandom, CodeVisiteur;
    private EditText codeGenerer;
    private Button buttonValiderCode, OK;
    private Button deconnexion, quitter;
  //  private LinearLayout partieDeux;

    private String generateRandomCode() {
        // Caractères possibles dans le code
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        // Longueur du code souhaitée
        int codeLength = 12;

        // Utilisation de SecureRandom pour une génération sécurisée
        SecureRandom random = new SecureRandom();

        // StringBuilder pour construire le code
        StringBuilder codeBuilder = new StringBuilder(codeLength);

        // Boucle pour construire le code caractère par caractère
        for (int i = 0; i < codeLength; i++) {
            int randomIndex = random.nextInt(characters.length());
            char randomChar = characters.charAt(randomIndex);
            codeBuilder.append(randomChar);
        }

        // Retourne le code généré
        return codeBuilder.toString();
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

        CodeVisiteur = findViewById(R.id.CodeVisiteur);
        codeRandom = findViewById(R.id.codeRandom);
        codeGenerer = findViewById(R.id.codeGenerer);
        OK = findViewById(R.id.OK);
        buttonValiderCode = findViewById(R.id.buttonValiderCode);
       // partieDeux=findViewById(R.id.partieDeux);


        setUserStatus("KO");

    }
    public void valider  (View v){
        findViewById(R.id.partieDeux).setVisibility(View.VISIBLE);

        String CA= generateRandomCode();
        codeGenerer.setText(CA);

        String codeV = CodeVisiteur.getText().toString();

        // Vous pouvez maintenant utiliser la méthode sendKeyByEmail
        // avec le codeV, secureKey, et token comme paramètres
        String secureKey = codeGenerer.getText().toString();
        String token = SECURETOKEN;
        SendKeyTask sendKeyTask = new SendKeyTask(getApplicationContext());
        sendKeyTask.execute(codeV, secureKey, token);

    }


    public void Validercode(View v) {

        // Perform the search and update the ListView
        String codeEcrit = codeRandom.getText().toString();
        String codeRandom= codeGenerer.getText().toString();



        if (codeEcrit.equals(codeRandom)){

            //setContentView(R.layout.activity_main);
            String status1 = "Authentifié";
            setUserStatus(status1);



            Toast toast = Toast.makeText(this, "Authentification réussie", Toast.LENGTH_LONG);
            toast.show();
            // L'utilisateur n'est pas authentifié, redirigez vers l'activité d'authentification
            Intent authIntent = new Intent(this, MainActivity.class);
            startActivity(authIntent);
            finish(); // Terminez l'activité principale pour éviter qu'elle ne soit accessible avec le bouton "Retour"


        }
        else {

            Toast toast = Toast.makeText(this, "identification incorrecte", Toast.LENGTH_LONG);
            toast.show();
        }

    }


    public void Quitter (View v){
        finish();
    }

}


