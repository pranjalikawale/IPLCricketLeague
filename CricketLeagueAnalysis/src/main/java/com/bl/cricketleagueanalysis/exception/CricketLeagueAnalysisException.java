package com.bl.cricketleagueanalysis.exception;

public class CricketLeagueAnalysisException extends Exception {
    public enum ExceptionType { NO_DATA,INVALID_FILE_TYPE,FILE_PROBLEM;
    }

    public ExceptionType type;

    public CricketLeagueAnalysisException(String message, ExceptionType type) {
        super(message);
        this.type = type;
    }
    public CricketLeagueAnalysisException(String message, String name) {
        super(message);
        this.type = CricketLeagueAnalysisException.ExceptionType.valueOf(name);
    }
}
