package restart.com.cardviewdemo;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
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
//        mRcycleView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mRcycleView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        //
        mRcycleView.addItemDecoration(new ItemDecoration(20));
        //j将适配器设置给控件
        mRcycleView.setAdapter(new Adapter());

    }

    /*
    * 分割线
    * */
    class ItemDecoration extends RecyclerView.ItemDecoration {
        int space;

        public ItemDecoration(int space) {
            this.space = space;
        }

        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            if (parent.getChildAdapterPosition(view)%2==0){
                outRect.top = 30;

            }else {
                outRect.top = space;
            }
            outRect.bottom = space;
            outRect.top = space;
            outRect.left = space;
            outRect.right = space;

        }
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

