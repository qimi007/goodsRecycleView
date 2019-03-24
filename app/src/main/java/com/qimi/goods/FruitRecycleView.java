package com.qimi.goods;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FruitRecycleView extends Activity {

    //定义数据
    List<Fruit> mlistdata = new ArrayList<>();
    RecyclerView recyclerView;
    FruitAdapter fruitAdapter;

    EditText et_name;
    EditText et_price;
    EditText et_product;
    Button btn_add;
    Button btn_del;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goods_recycle_view);

        initView();
    }

    private void initView() {
        //加载
        et_name = (EditText) findViewById(R.id.et_name);
        et_price = (EditText) findViewById(R.id.et_price);
        et_product = (EditText) findViewById(R.id.et_procuct);
        btn_add = findViewById(R.id.btn_add);
        btn_del = findViewById(R.id.btn_del);

        btn_add.setOnClickListener(onClickListener);
        btn_del.setOnClickListener(onClickListener);

        recyclerView = (RecyclerView) findViewById(R.id.rv_list);
        //设置布局
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //创建一个适配器
        fruitAdapter = new FruitAdapter(mlistdata);

        recyclerView.setAdapter(fruitAdapter);

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_add:
                        if(et_name.getText().toString().equals("")){
                            Toast.makeText(FruitRecycleView.this , "please input fruit name",Toast.LENGTH_LONG).show();
                        }else{
                            if(et_price.getText().toString().equals("")){
                                Toast.makeText(FruitRecycleView.this , "please input fruit price" , Toast.LENGTH_LONG).show();
                            }else{
                                if(et_product.getText().toString().equals("")){
                                    Toast.makeText(FruitRecycleView.this , "please input fruit product" , Toast.LENGTH_LONG).show();
                                }else {

                                    mlistdata.add(new Fruit(et_name.getText().toString() , et_price.getText().toString() , et_product.getText().toString()));
                                    cleanEditText();
                                    fruitAdapter.notifyDataSetChanged();
                                }
                            }
                        }
                    break;

                case R.id.btn_del:

                    break;

                default:
                    break;
            }
        }
    };

    //清空输入框
    private void cleanEditText(){
        et_name.setText("");
        et_price.setText("");
        et_product.setText("");

    }

}
