package com.san.interview;


import java.util.*;


public class TransactionParser {

    private static final String COMMA=",";
    private static final int HASHCODE_PART=0;
    private static final int TIMESTAMP_PART=1;
    private static final int PRICE_PART=2;

    private static final String TIMESTAMP_SEPERATOR="T";
    private static final int DATE_PART=0;

    /**
     * Returns transactions over given threshold on the given day
     * @param transactions list of transactions in format hashcode,yyyy-MM-ddTHH:mm:ss,price
     * @param targetDate date on which transactions need to be considered. has to be in format yyyy-MM-dd
     * @param threshold threshold that any creditcard hashcode cannot exceed altogether on a given day. if they do they will be part of fraudulent txn list.
     * @return
     */
    public List<String> getListOfFraudulentTransactions(List<String> transactions, String targetDate, double threshold) {

        if(transactions==null)
            throw new IllegalArgumentException("Input transactions null");
        if( ! targetDate.matches("^\\d{4}-\\d{2}-\\d{2}$"))
            throw new IllegalArgumentException("Incorrect format for input date please use yyyy-MM-dd format");


        Set<String> setOfFraudulentTransactions = new HashSet<>();
        HashMap<String,Double> mapOfTransactionsWithAmount = new HashMap<>();


        for(String txn : transactions) {
            String[] txnSplit = splitAndValidateTxn(txn);
            String txndate = txnSplit[TIMESTAMP_PART];

            if(txndate.equals(targetDate)) {
                String txnhashcode = txnSplit[HASHCODE_PART];
                Double txnprice = Double.parseDouble(txnSplit[PRICE_PART]);

                Double totalTxnPrice = mapOfTransactionsWithAmount.getOrDefault(txnhashcode, 0.0);
                totalTxnPrice+=txnprice;
                mapOfTransactionsWithAmount.put(txnhashcode, totalTxnPrice);

                if(totalTxnPrice>threshold) {
                    setOfFraudulentTransactions.add(txnhashcode);
                }
            }

        }

        return new ArrayList<>(setOfFraudulentTransactions);
    }


    public String[] splitAndValidateTxn(String txn) {

        if(isStringNullOrEmpty(txn))
            throw new IllegalArgumentException("null or empty txn in input");

        String[] txnSplit = txn.split(COMMA);

        if(txnSplit.length != 3)
            throw new IllegalArgumentException("Invalid txn input : "+txn+" . please input in format hashcode,timestamp,price");

        //prune
        txnSplit[HASHCODE_PART]=txnSplit[HASHCODE_PART].trim();
        txnSplit[TIMESTAMP_PART]=txnSplit[TIMESTAMP_PART].trim();
        txnSplit[PRICE_PART]=txnSplit[PRICE_PART].trim();

        //validate
        if((txnSplit[HASHCODE_PART] ==null) || (txnSplit[HASHCODE_PART].isEmpty()))
            throw new IllegalArgumentException("Invalid hashcode in txn:"+txn);

        if((txnSplit[TIMESTAMP_PART] ==null) || (txnSplit[TIMESTAMP_PART].isEmpty()))
            throw new IllegalArgumentException("Invalid timestamp in input :"+txn);

        if( ! txnSplit[TIMESTAMP_PART].matches("^\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}$"))
            throw new IllegalArgumentException("Invalid timestamp format in input :"+txn+" please use yyy-MM-ddTHH:mm:ss format");

        if((txnSplit[PRICE_PART] ==null) || (txnSplit[PRICE_PART].isEmpty()))
            throw new IllegalArgumentException("Invalid price in input :"+txn);

        if( ! isDouble(txnSplit[PRICE_PART]))
            throw new IllegalArgumentException("Invalid price(not double) in input :"+txn);

        txnSplit[TIMESTAMP_PART] = txnSplit[TIMESTAMP_PART].split(TIMESTAMP_SEPERATOR)[DATE_PART];

        return txnSplit;
    }

    //NOTE: Would probably use a util like NumberUtils.isNumber(aString) from apache commons
    private boolean isDouble(String val) {
        try {
            Double.parseDouble(val);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    //NOTE: would use util like StringUtils.isEmptyOrWhitespace()
    private boolean isStringNullOrEmpty(String val) {
        if((val ==null) || (val.isEmpty()))
            return true;

        return false;
    }
}
