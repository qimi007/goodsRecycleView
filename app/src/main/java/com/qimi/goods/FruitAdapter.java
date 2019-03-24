package com.qimi.goods;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

import static com.qimi.goods.R.id.tv_price;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitHodler> {

    //定义一个数据集合
    private List<Fruit> mlistdata;

//    @NonNull
//    @Override
//    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
//
//    }


    public FruitAdapter(List<Fruit> mlistdata) {
        this.mlistdata = mlistdata;
    }

    @NonNull
    @Override
    public FruitHodler onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item , parent , false);
        final FruitHodler fruitHodler = new FruitHodler(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int postion = fruitHodler.getAdapterPosition();
                Fruit fruit = mlistdata.get(postion);
                Toast.makeText(parent.getContext() , "you click name :"+fruit.getName() , Toast.LENGTH_LONG).show();
            }
        });

        fruitHodler.fruitShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int postion = fruitHodler.getAdapterPosition();
                Fruit fruit = mlistdata.get(postion);
                Toast.makeText(parent.getContext() , "you click name :"+fruit.getName()+" show" , Toast.LENGTH_LONG).show();
            }
        });


        return fruitHodler;
    }

    @Override
    public void onBindViewHolder(@NonNull FruitHodler holder, int position) {
        Fruit fruit = mlistdata.get(position);
        holder.fruitName.setText(fruit.getName());
        holder.fruitProduct.setText(fruit.getProduct());
        holder.fruitPrice.setText(fruit.getPrice());
    }

    @Override
    public int getItemCount() {
        return mlistdata.size();
    }



    static class FruitHodler extends RecyclerView.ViewHolder{

        TextView fruitName;
        TextView fruitPrice;
        TextView fruitProduct;
        Button fruitShow;

        public FruitHodler(View itemview){
            super(itemview);
            fruitName = (TextView) itemview.findViewById(R.id.tv_name);
            fruitPrice = (TextView) itemview.findViewById(R.id.tv_price);
            fruitProduct = (TextView) itemview.findViewById(R.id.tv_product);
            fruitShow = (Button) itemview.findViewById(R.id.btn_show);
        }

    }


}
