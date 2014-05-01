package services;

import java.util.List;

import exceptions.ApplicationException;

public interface CodeTrendAnalytics {

    public List<CodeTrendItem> getCodeTrends(String[] input) throws ApplicationException;

}
