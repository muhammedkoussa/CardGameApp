package tr.edu.duzce.mf.bm.cardgame;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IScoreDAO {

    @Insert//insertScoreTable interfacete tanımlı bir fonksiyon tabloya veri kaydeder.
    void insertScoreTable(ScoreTable scoreTable);

    @Update
    void updateScoreTable(ScoreTable scoreTable);

    @Delete
    void deleteScoreTable(ScoreTable scoreTable);

    @Query("SELECT * FROM Scores ORDER BY score DESC")// harici sql Query leri için
    List<ScoreTable> loadAllScoreTables();//tüm skoru çeker

    @Query("DELETE FROM Scores")
    void deleteAllScoreTables();

}
