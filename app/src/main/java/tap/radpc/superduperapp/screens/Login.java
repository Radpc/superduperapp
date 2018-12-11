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

public class Login extends AppCompatActivity {

    //Init of references:
    Button buttonLogin;
    Button buttonRegister;
    TextView textViewTeste;
    EditText editTextUser;
    EditText editTextPassword;

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
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);


        //Init of the DatabaseChecker
        final UsuarioDAO usuarioCheck = database.getUsuarioDAO();

        //[ACTION] - BUTTON LOGIN
        buttonLogin.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        Usuario user = usuarioCheck.getUsuario(editTextUser.getText().toString());
                        if(user != null){
                            if(user.getSenha().equals(editTextPassword.getText().toString())){
                                entrarTela(user);
                            }else{
                                Toast.makeText(getApplicationContext(), "Ora, sua senha não era outra..?", Toast.LENGTH_SHORT).show();
//                                Toast.makeText(getApplicationContext(), "[" + user.getSenha() + "]" + " diferente da colocada " + "[" + editTextPassword.getText().toString() + "]", Toast.LENGTH_SHORT).show();
                                return;
                            }
                        }else{
                            Toast.makeText(getApplicationContext(), "Não me lembro de nenhum " + editTextUser.getText().toString() + " passando por aqui..", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }
        );

        buttonLogin.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        Toast.makeText(getApplicationContext(), "LONG CLICK", Toast.LENGTH_SHORT).show();
                        return true;
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


    private void entrarTela(Usuario user){
        startActivity(new Intent(getApplicationContext(),mainMenu.class));
    }

}
