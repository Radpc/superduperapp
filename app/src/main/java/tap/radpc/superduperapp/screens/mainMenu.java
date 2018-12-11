package tap.radpc.superduperapp.screens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import tap.radpc.superduperapp.R;
import tap.radpc.superduperapp.database.entities.Produto;

public class mainMenu extends AppCompatActivity {

    Button buttonProdutos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        buttonProdutos = (Button) findViewById(R.id.buttonProdutos);
        //[ACTION] - BUTTON REGISTER
        buttonProdutos.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        startActivity(new Intent(getApplicationContext(),Produtos.class));
                    }
                }
        );




    }
}