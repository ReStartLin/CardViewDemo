package restart.com.cardviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import restart.com.cardviewdemo.entity.City;
import restart.com.cardviewdemo.util.DataUtil;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRcycleView;
    private List<City> cities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mRcycleView = findViewById(R.id.recycle);
        cities = DataUtil.getData();
        //设置布局LinearLayoutManager:列表  GridLayoutManager：网格 StaggeredGridLayoutManager:瀑布流
        mRcycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        //j将适配器设置给控件
        mRcycleView.setAdapter(new Adapter());

    }

    /*适配器*/
    class Adapter extends RecyclerView.Adapter<ViewHolder> {


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(MainActivity.this).inflate(R.layout.item, null);

            return new ViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            City city = cities.get(position);
            holder.imageView.setImageResource(city.getIconId());
            holder.textView.setText(city.getName());

        }

        @Override
        public int getItemCount() {
            return cities.size();
        }
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img_icon);
            textView = itemView.findViewById(R.id.tv_name);
        }
    }
}

