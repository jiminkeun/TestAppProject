package mytest.syscore.daou.mytest.common;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import mytest.syscore.daou.mytest.item.MemberInfo;
import mytest.syscore.daou.mytest.sqlmap.MemberDBSqlData;
/**
 * Created by daou on 2017-11-22.
 */

public class DBManager {
    private final String DB_NAME = "db_test.db";
    private final int DB_VERSION = 1;

    private Context mContext = null;
    private SQLiteOpenHelper mOpener = null;
    private SQLiteDatabase mDbController = null;

    public DBManager(Context mContext) {
        this.mContext = mContext;
        this.mOpener = new OpenHelper(mContext, DB_NAME, null, DB_VERSION);
    }

    private class OpenHelper extends SQLiteOpenHelper {
        public OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(MemberDBSqlData.SQL_DB_CREATE_TABLE);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

    public void dbOpen() {
        this.mDbController = mOpener.getWritableDatabase();
    }

    public void dbClose() {
        this.mDbController.close();
    }

    public void insertData(String sql, MemberInfo info) {
        String[] sqlData = info.getMemberInfoArray();
        this.mDbController.execSQL(sql, sqlData);
    }

    public void deleteData(String sql, MemberInfo info) {
        String[] sqlData = {Integer.toString(info.getNo())};
        this.mDbController.execSQL(sql, sqlData);
    }

    public void selectAll(String sql, ArrayList<MemberInfo> memberList) {
        Cursor results = this.mDbController.rawQuery(sql, null);
        results.moveToFirst();

        while (!results.isAfterLast()) {
            MemberInfo info = new MemberInfo(
                    results.getInt(1),
                    results.getString(2),
                    results.getInt(3),
                    results.getString(4),
                    results.getString(5),
                    results.getString(6),
                    results.getString(7)
            );
            memberList.add(info);
            results.moveToNext();
        }
        results.close();
    }


}
