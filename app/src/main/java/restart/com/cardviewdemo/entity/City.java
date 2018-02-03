package restart.com.cardviewdemo.entity;

/**
 * Created by Administrator on 2018/2/3.
 */

public class City {
    int iconId;
    String name;

    public City(int iconId, String name) {
        this.iconId = iconId;
        this.name = name;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
