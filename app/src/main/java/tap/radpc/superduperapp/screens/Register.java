package tap.radpc.superduperapp.screens;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import tap.radpc.superduperapp.R;
import tap.radpc.superduperapp.database.AppDatabase;
import tap.radpc.superduperapp.database.daos.UsuarioDAO;
import tap.radpc.superduperapp.database.entities.Usuario;

public class Register extends AppCompatActivity {


    //Init of references:
    Button buttonFinishRegister;
    TextView editRegisterUser;
    TextView editRegisterPassword;

    //Init of Database
    AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-fallout")
            .allowMainThreadQueries()   //Allows room to do operation on main thread
            .build();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


//      Referencing of references:
        buttonFinishRegister = (Button) findViewById(R.id.buttonFinishRegister);
        editRegisterUser = (EditText) findViewById(R.id.editRegisterUser);
        editRegisterPassword     = (EditText) findViewById(R.id.editRegisterPassword);


//      Init of the DatabaseChecker
        final UsuarioDAO usuarioCheck = database.getUsuarioDAO();



//      [ACTION] - BUTTON REGISTER
        buttonFinishRegister.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        String rUser     = editRegisterUser.getText().toString();
                        String rPassword = editRegisterPassword.getText().toString();

                        //If the informations are not valid
                        if(rUser.length() == 0 || rPassword.length() == 0){
                            Toast.makeText(getApplicationContext(), "Esqueceu suas informacoes, sobrevivente?", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if(usuarioCheck.getUsuario(rUser) != null){
                            Toast.makeText(getApplicationContext(), "Parece que já existe um sobrevivente com esse nome...", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        Usuario user = new Usuario(rUser,rPassword);
                        usuarioCheck.insert(user);
                        finish();
                    }
                }
        );


    }
}
