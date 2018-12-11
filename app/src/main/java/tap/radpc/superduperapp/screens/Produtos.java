package tap.radpc.superduperapp.screens;

import android.arch.persistence.room.Room;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import tap.radpc.superduperapp.R;
import tap.radpc.superduperapp.auxiliar.ProdutosAdapter;
import tap.radpc.superduperapp.database.AppDatabase;
import tap.radpc.superduperapp.database.daos.ProdutoDAO;
import tap.radpc.superduperapp.database.entities.Produto;

public class Produtos extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProdutosAdapter lAdapter;
    private FloatingActionButton buttonFab;
    public List<Produto> produtoList = new ArrayList<Produto>();

    //Init of Database
    AppDatabase database = Room.databaseBuilder(this, AppDatabase.class, "db-fallout")
            .allowMainThreadQueries()   //Allows room to do operation on main thread
            .build();
    //Init of the DatabaseChecker
    final ProdutoDAO produtoCheck = database.getProdutoDAO();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produtos);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerViewProdutos);

        lAdapter = new ProdutosAdapter(produtoList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());



        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(lAdapter);

        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),
                DividerItemDecoration.VERTICAL));

        prepareProdutosData();


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                produtoCheck.insert(new Produto(0,"Pokebola","Uma pokebola qualquer",50,60,40,"Bola(s)","Equipamento"));
                prepareProdutosData();
            }

        });

    }





    private void prepareProdutosData(){
        lAdapter.setOnItemClickListener(new ProdutosAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getApplicationContext(),"" + lAdapter.getProdutoList().get(position).getCategoria(), Toast.LENGTH_SHORT).show(); //TODO Adicionar o intent + o intentExtra para esse listener

            }
        });
        lAdapter.updateData(produtoCheck.getProdutos());
        lAdapter.notifyDataSetChanged();

    }
}
