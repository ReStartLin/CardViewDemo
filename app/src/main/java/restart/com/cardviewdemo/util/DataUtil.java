package restart.com.cardviewdemo.util;

import java.util.ArrayList;
import java.util.List;

import restart.com.cardviewdemo.R;
import restart.com.cardviewdemo.entity.City;

/**
 * Created by Administrator on 2018/2/3.
 */

public class DataUtil {
    public static List<City> getData() {
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            City city = new City(R.mipmap.dizhonghai_line, "地中海");
            cities.add(city);

            City city2 = new City(R.mipmap.rihan_line, "日韩线");
            cities.add(city2);

            City city3 = new City(R.mipmap.hotline, "旅游热线");
            cities.add(city3);
        }
        return cities;

    }
}
