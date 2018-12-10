package tap.radpc.superduperapp.screens;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import tap.radpc.superduperapp.R;
import tap.radpc.superduperapp.database.AppDatabase;
import tap.radpc.superduperapp.database.daos.UsuarioDAO;
import tap.radpc.superduperapp.database.entities.Usuario;

public class Login extends AppCompatActivity {

    //Init of references:
    Button buttonLogin;
    Button buttonRegister;
    TextView textViewTeste;
    int i = 0;

    //Init of Database
    AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-fallout")
            .allowMainThreadQueries()   //Allows room to do operation on main thread
            .build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



//      Referencing of references:
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        textViewTeste = (TextView) findViewById(R.id.textViewTeste);
        buttonRegister = (Button) findViewById(R.id.buttonRegister);


        //Init of the DatabaseChecker
        final UsuarioDAO usuarioCheck = database.getUsuarioDAO();

        //[ACTION] - BUTTON LOGIN
        buttonLogin.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        //TODO create a LOGIN onClick
                    }
                }
        );

        //[ACTION] - BUTTON REGISTER
        buttonRegister.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        startActivity(new Intent(getApplicationContext(),Register.class));
                    }
                }
        );

    }
}
