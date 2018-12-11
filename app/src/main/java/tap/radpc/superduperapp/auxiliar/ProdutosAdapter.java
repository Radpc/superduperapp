package tap.radpc.superduperapp.auxiliar;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import tap.radpc.superduperapp.R;
import tap.radpc.superduperapp.database.entities.Produto;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.MyViewHolder> {
    private List<Produto> produtosList;

    private OnItemClickListener mListener;



    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) { mListener = listener;}

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nome,custo,estoque;

        public MyViewHolder(View view, final OnItemClickListener listener){
            super(view);
            nome =   (TextView) view.findViewById(R.id.textViewHolderNome); //TODO Continuar
            custo =  (TextView) view.findViewById(R.id.textViewHolderCusto);
            estoque = (TextView) view.findViewById(R.id.textViewHolderEstoque);

            view.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ProdutosAdapter(List<Produto> produtoList) {this.produtosList = produtoList;}


    public void updateData(List<Produto> produtos){
        this.produtosList = produtos;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.holderlinha,parent,false);
        return new MyViewHolder(itemView, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Produto produto = produtosList.get(position);
        holder.custo.setText(Integer.toString(produto.getPreco()));
        holder.estoque.setText(Integer.toString(produto.getEstoque()));
        holder.nome.setText(produto.getNome());

    }

    @Override
    public int getItemCount() {
        return produtosList.size();
    }

    public List<Produto> getProdutoList() {return produtosList;}



}
