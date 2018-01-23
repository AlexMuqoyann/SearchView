package com.example.hp.searchview.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.searchview.R;
import com.example.hp.searchview.interfaces.RecyclerViewOnClickListener;
import com.example.hp.searchview.models.Film;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;



public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {
    private Context context;
    private List<Film>list;
    private LayoutInflater inflater;
    private RecyclerViewOnClickListener recyclerViewOnClickListener;
    public FilmAdapter(Context context, ArrayList<Film>list,RecyclerViewOnClickListener recyclerViewOnClickListener){
        this.context = context;
        this.recyclerViewOnClickListener = recyclerViewOnClickListener;
        this.inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film film = list.get(position);
        holder.tv_name.setText(film.getName());
        Picasso.with(context).load(film.getFoto()).into(holder.iv_image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public void setFilter(ArrayList<Film>newList){
        list = new ArrayList<>();
        list.addAll(newList);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView iv_image;
        private TextView tv_name;
        public ViewHolder(View itemView) {
            super(itemView);

            iv_image = itemView.findViewById(R.id.iv_image);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_image.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            recyclerViewOnClickListener.onItemClick(v,getAdapterPosition());
        }
    }
}
