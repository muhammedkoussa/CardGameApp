package tr.edu.duzce.mf.bm.cardgame;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
//room databasaden miras alıyor abstracut oldugu için nesne üretemiyor.
//entities databasein içindeki tablolar ScoreTable olarak alınacak.
@Database(entities = {ScoreTable.class}, version = 1, exportSchema = true)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDatabase;
    public abstract IScoreDAO getScoreDAO();

    private static final String databaseName = "bm443.CardGame";
//database boşsa bir tane room sınıfından database oluşturuyor bu isismle

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase =
                    Room.databaseBuilder(context, AppDatabase.class, databaseName)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return appDatabase;
    }
// database boşaltıyor.

    public static void destroyInstance() {appDatabase = null;}

}
