package com.bl.cricketleagueanalysis.criketleagueadapter;

import com.bl.censusanalyser.exception.CSVBuilderException;
import com.bl.censusanalyser.opencsv.CSVBuilderFactory;
import com.bl.censusanalyser.opencsv.ICSVBuilder;
import com.bl.cricketleagueanalysis.exception.*;
import com.bl.cricketleagueanalysis.model.BallerCSV;
import com.bl.cricketleagueanalysis.model.BatsManCSV;

import com.bl.cricketleagueanalysis.playerdao.PlayerDAO;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.StreamSupport;

public class CricketAdapterAbstract {

    public <T> Map<String, PlayerDAO> cricketAnalysisData(String filePath, Class classType)
                                                    throws CricketLeagueAnalysisException {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));){
            ICSVBuilder csvBuilder = CSVBuilderFactory.createCSVBuilder();
            Iterator<T> csvIterator = csvBuilder.getCSVIterator(reader,classType);
            Iterable<T> csvIterable=()->csvIterator;
            return getMap(classType ,csvIterable);
        } catch (IOException e) {
           throw new CricketLeagueAnalysisException(e.getMessage(),
                                                    CricketLeagueAnalysisException.ExceptionType.FILE_PROBLEM);
        }
        catch (CSVBuilderException e){
            throw new CricketLeagueAnalysisException(e.getMessage(),
                    e.type.name());
        }

    }

    public <T> Map<String,PlayerDAO>  getMap(Class<T> classType , Iterable<T> csvIterable){
        Map<String, PlayerDAO> playerCSVMap=new HashMap<>();
        if(classType.getName().equals("com.bl.cricketleagueanalysis.model.BatsManCSV")) {
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .map(BatsManCSV.class::cast)
                    .forEach(playerCSV -> playerCSVMap.put(playerCSV.player, new PlayerDAO(playerCSV)));
        }else if(classType.getName().equals("com.bl.cricketleagueanalysis.model.BallerCSV")) {
            StreamSupport.stream(csvIterable.spliterator(), false)
                    .map(BallerCSV.class::cast)
                    .forEach(playerCSV -> playerCSVMap.put(playerCSV.player, new PlayerDAO(playerCSV)));
        }
        return playerCSVMap;
    }
}
