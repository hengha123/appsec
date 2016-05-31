package provider.konka.com.contentprovider_sqlite_sample;

import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by mac on 16/5/19.
 */
public class Employees {

    public static final String AUTHORITY = "com.konka.provider.Employees";

    private  Employees(){}

    //内部类
    public static final class Employee implements BaseColumns{

        //构造方法
        private Employee(){}

        //访问uri
        public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/employee");

        //内容类型
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.amaker.employees";
        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.amaker.employees";

        //默认排序常量
        public static final String DEFAULT_SORT_ORDER = "name DESC";

        //表字段常量
        public static final String _ID = "_ID";
        public static final String NAME = "name";
        public static final String GENDER = "gender";
        public static final String AGE = "age";
    }


}

