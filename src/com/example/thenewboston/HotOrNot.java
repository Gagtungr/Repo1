package com.example.thenewboston;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class HotOrNot {
	
	public static final String KEY_ROWID = "_id";
	public static final String KEY_NAME = "person_name";
	public static final String KEY_HOTNESS = "person_hotness";
	
	private static final String DB_NAME = "HotOrNotDB";
	private static final String DB_TABLE = "people_tbl";
	private static final int DB_VER = 1;
	
	private DbHelper m_DbHelper;
	private Context m_Context;
	private SQLiteDatabase m_DB;
	
	
	public HotOrNot(Context c) {
		m_Context = c;
	}
	
	public HotOrNot openForWrite() {
		m_DbHelper = new DbHelper(m_Context);
		m_DB = m_DbHelper.getWritableDatabase();
		
		return this;
	}
	
	public void closeDB() {
		m_DbHelper.close();
	}
	
	
	private static class DbHelper extends SQLiteOpenHelper {

		public DbHelper(Context context) {
			super(context, DB_NAME, null, DB_VER);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL("CREATE TABLE " + DB_TABLE + " (" + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
					KEY_NAME + " TEXT NOT NULL, " + KEY_HOTNESS + " TEXT NOT NULL);");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
			onCreate(db);
			
		}
		
	}


	public long createEntry(String name, String hotness) {
		ContentValues cv = new ContentValues();
		cv.put(KEY_NAME, name);
		cv.put(KEY_HOTNESS, hotness);
		
		return m_DB.insert(DB_TABLE, null, cv);
	}

}
