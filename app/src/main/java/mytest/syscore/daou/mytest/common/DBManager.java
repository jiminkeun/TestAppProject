package mytest.syscore.daou.mytest.common;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by daou on 2017-11-22.
 */

public class DBManager {
    private final String DB_NAME = "db_test.db";
    private final int DB_VERSION = 1;

    private Context mContext = null;
    private SQLiteOpenHelper mOpener = null;
    private SQLiteDatabase mDbController = null;

    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(DBSqlData.);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }



        public
    }


}
