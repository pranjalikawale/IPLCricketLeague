package com.bl.cricketleagueanalysis;

import com.bl.cricketleagueanalysis.cricketenum.Cricket;
import com.bl.cricketleagueanalysis.filepath.CSVFilesPathDetails;
import com.bl.cricketleagueanalysis.exception.CricketLeagueAnalysisException;
import com.bl.cricketleagueanalysis.cricketleague.CricketLeagueAnalysis;
import com.bl.cricketleagueanalysis.model.BallerCSV;
import com.bl.cricketleagueanalysis.model.BatsManCSV;
import com.bl.cricketleagueanalysis.playerdao.PlayerDAO;
import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

public class CricketLeagueAnalysisTest {
    @Test
    public void givenWrongCSVFile_ShouldHandleException(){
        try {
            CricketLeagueAnalysis cricketLeagueAnalysis=new CricketLeagueAnalysis(Cricket.CricketLeague.BATSMAN);
            cricketLeagueAnalysis.cricketLeagueAnalysisData(CSVFilesPathDetails.WRONG_FILE_PATH);
            String sortedCensusData=cricketLeagueAnalysis.getSortedData("average");
            BatsManCSV batsManCSV[] = new Gson().fromJson(sortedCensusData, BatsManCSV[].class);
            Assert.assertEquals("MS Dhoni", batsManCSV[0].player);
        } catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.FILE_PROBLEM,e.type);
        }
    }
    @Test
    public void callSortMethod_WithoutLoadData_ShouldHandleException(){
        try {
            Comparator<PlayerDAO> comparatorByTopBattingAverage= Comparator.comparing(PlayerDAO::getAverage);
            String sortedCensusData=new CricketLeagueAnalysis().getSortedData("average");
            BatsManCSV batsManCSV[] = new Gson().fromJson(sortedCensusData, BatsManCSV[].class);
            Assert.assertEquals("MS Dhoni", batsManCSV[0].player);
        } catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.NO_DATA,e.type);
        }
    }
    @Test
    public void givenRightFile_ButUsedDefaultConstructor_ShouldHandleException(){
        try {
            CricketLeagueAnalysis cricketLeagueAnalysis=new CricketLeagueAnalysis();
            cricketLeagueAnalysis.cricketLeagueAnalysisData(CSVFilesPathDetails.MOST_RUNS_CSV_FILE_PATH);
            String sortedCensusData=cricketLeagueAnalysis.getSortedData("average");
            BatsManCSV batsManCSV[] = new Gson().fromJson(sortedCensusData, BatsManCSV[].class);
            Assert.assertEquals("MS Dhoni", batsManCSV[0].player);
        } catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.NO_DATA,e.type);
        }
    }

    @Test
    public void givenMostRunsCSVFile_ReturnsTopBattingAverage(){
        try {
            CricketLeagueAnalysis cricketLeagueAnalysis=new CricketLeagueAnalysis(Cricket.CricketLeague.BATSMAN);
            cricketLeagueAnalysis.cricketLeagueAnalysisData(CSVFilesPathDetails.MOST_RUNS_CSV_FILE_PATH);
            String sortedCensusData=cricketLeagueAnalysis.getSortedData("average");
            BatsManCSV batsManCSV[] = new Gson().fromJson(sortedCensusData, BatsManCSV[].class);
            Assert.assertEquals("MS Dhoni", batsManCSV[0].player);
        } catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.NO_DATA,e.type);
        }

    }

    @Test
    public void givenMostRunsCSVFile_ReturnsTopStrickRate(){
        try {
            CricketLeagueAnalysis cricketLeagueAnalysis=new CricketLeagueAnalysis(Cricket.CricketLeague.BATSMAN);
            cricketLeagueAnalysis.cricketLeagueAnalysisData(CSVFilesPathDetails.MOST_RUNS_CSV_FILE_PATH);
            String sortedCensusData=cricketLeagueAnalysis.getSortedData("strickrate");
            BatsManCSV batsManCSV[] = new Gson().fromJson(sortedCensusData, BatsManCSV[].class);
            Assert.assertEquals("Ishant Sharma", batsManCSV[0].player);
        } catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.NO_DATA,e.type);
        }
    }

    @Test
    public void givenMostRunsCSVFile_ReturnsMaxSixAndFour(){
        try {
            CricketLeagueAnalysis cricketLeagueAnalysis=new CricketLeagueAnalysis(Cricket.CricketLeague.BATSMAN);
            cricketLeagueAnalysis.cricketLeagueAnalysisData(CSVFilesPathDetails.MOST_RUNS_CSV_FILE_PATH);
            String sortedCensusData=cricketLeagueAnalysis.getSortedData("six","four");
            BatsManCSV batsManCSV[] = new Gson().fromJson(sortedCensusData, BatsManCSV[].class);
            Assert.assertEquals("Andre Russell", batsManCSV[0].player);
        } catch (CricketLeagueAnalysisException e) {
            Assert.assertEquals(CricketLeagueAnalysisException.ExceptionType.NO_DATA,e.type);
        }
    }


}
