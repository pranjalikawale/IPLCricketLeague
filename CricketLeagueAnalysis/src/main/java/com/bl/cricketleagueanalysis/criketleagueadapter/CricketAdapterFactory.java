package com.bl.cricketleagueanalysis.criketleagueadapter;

import com.bl.cricketleagueanalysis.cricketenum.Cricket;
import com.bl.cricketleagueanalysis.exception.CricketLeagueAnalysisException;
import com.bl.cricketleagueanalysis.model.BallerCSV;
import com.bl.cricketleagueanalysis.model.BatsManCSV;
import com.bl.cricketleagueanalysis.playerdao.PlayerDAO;

import java.util.Map;

public class CricketAdapterFactory {

    public static Map<String, PlayerDAO> getCricketLeagueAnalysisData(Cricket.CricketLeague cricketLeague,
                                                                      String filePath) throws CricketLeagueAnalysisException {
        if(cricketLeague.equals(Cricket.CricketLeague.BATSMAN))
            return new CricketAdapter().loadedCricketAnalysisData(filePath, BatsManCSV.class);
        else if(cricketLeague.equals(Cricket.CricketLeague.BALLER))
            return new CricketAdapter().loadedCricketAnalysisData(filePath, BallerCSV.class);
        else
            throw new CricketLeagueAnalysisException("Incorrect type of file", CricketLeagueAnalysisException.ExceptionType.INVALID_FILE_TYPE);
    }
}
