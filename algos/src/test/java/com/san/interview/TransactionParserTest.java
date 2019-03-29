package com.san.interview;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TransactionParserTest {

    private static final TransactionParser transactionParser = new TransactionParser();

    @Test
    public void testGetListOfFraudulentTransactionsHasNoDuplicates() {

        List<String> transactions = new ArrayList<>();

        transactions.add("hashcode1,2018-01-01T01:01:01,10.0");
        transactions.add("hashcode1,2018-01-01T01:01:01,10.0");
        transactions.add("hashcode1,2018-01-01T01:01:01,10.0");
        transactions.add("hashcode2,2018-01-01T01:01:01,10.0");
        transactions.add("hashcode2,2018-01-01T01:01:01,10.0");

        List<String> frauds = transactionParser.getListOfFraudulentTransactions(transactions,"2018-01-01",1.0);

        assertEquals(2, frauds.size());
        assertTrue(frauds.contains("hashcode1"));
        assertTrue(frauds.contains("hashcode2"));
    }

    @Test
    public void testGetListOfFraudulentTransactionsConsidersGivenDate() {

        List<String> transactions = new ArrayList<>();

        transactions.add("hashcode1,2018-01-01T01:01:01,10.0");
        transactions.add("hashcode1,2018-01-02T01:01:01,10.0");
        transactions.add("hashcode1,2018-01-03T01:01:01,10.0");
        transactions.add("hashcode2,2018-01-01T01:01:01,10.0");
        transactions.add("hashcode2,2018-02-01T01:01:01,10.0");

        List<String> frauds = transactionParser.getListOfFraudulentTransactions(transactions,"2018-01-01",1.0);

        assertEquals(2, frauds.size());
        assertTrue(frauds.contains("hashcode1"));
        assertTrue(frauds.contains("hashcode2"));
    }

    @Test
    public void testGetListOfFraudulentTransactionsConsidersThreshold() {

        List<String> transactions = new ArrayList<>();

        transactions.add("hashcode1,2018-01-01T01:01:01,10.0");
        List<String> frauds = transactionParser.getListOfFraudulentTransactions(transactions,"2018-01-01",11.0);
        assertEquals(0, frauds.size());

        transactions.add("hashcode1,2018-01-01T01:01:01,20.0");
        frauds = transactionParser.getListOfFraudulentTransactions(transactions,"2018-01-01",11.0);
        assertEquals(1, frauds.size());
    }


    @Test
    public void checkNegativeInputOnGetListOfFraudulentTransactions() {
        assertIllegalArgumentExceptionIsThrown(
                ()-> transactionParser.getListOfFraudulentTransactions(null, null, 10.0),
                "Input transactions null");

        assertIllegalArgumentExceptionIsThrown(
                ()-> transactionParser.getListOfFraudulentTransactions(new ArrayList(), "abc", 10.0),
                "Incorrect format for input date please use yyyy-MM-dd format");
    }

    @Test
    public void checkSplitAndValidateTxnWithNegativeAndPositiveInput() {
        assertIllegalArgumentExceptionIsThrown(
                ()->transactionParser.splitAndValidateTxn(null),
                "null or empty txn in input");

        assertIllegalArgumentExceptionIsThrown(
                ()->transactionParser.splitAndValidateTxn(""),
                "null or empty txn in input");

        assertIllegalArgumentExceptionIsThrown(
                ()->transactionParser.splitAndValidateTxn("a"),
                "Invalid txn input : a . please input in format hashcode,timestamp,price");

        assertIllegalArgumentExceptionIsThrown(
                ()->transactionParser.splitAndValidateTxn("a,b"),
                "Invalid txn input : a,b . please input in format hashcode,timestamp,price");

        assertIllegalArgumentExceptionIsThrown(
                ()->transactionParser.splitAndValidateTxn("hashcode,b,c"),
                "Invalid timestamp format in input :hashcode,b,c please use yyy-MM-ddTHH:mm:ss format");

        assertIllegalArgumentExceptionIsThrown(
                ()->transactionParser.splitAndValidateTxn("hashcode,2108-01-01T10:10:10,c"),
                "Invalid price(not double) in input :hashcode,2108-01-01T10:10:10,c");


        String[] split = transactionParser.splitAndValidateTxn("hashcode,2108-01-01T10:10:10,10.1");
        assertEquals(3, split.length);
    }


    private void assertIllegalArgumentExceptionIsThrown(Action action, String exceptionString) {
        try {
            action.execute();
            Assert.fail("should have thrown exception");
        } catch (IllegalArgumentException ex) {
            assertEquals(exceptionString, ex.getMessage());
        }
    }

    private void assertIllegalArgumentExceptionIsThrown(Call call, String[] transactions, String date, String exceptionString) {
        try {
            call.execute(transactions, date);
            Assert.fail("should have thrown exception");
        } catch (IllegalArgumentException ex) {
            assertEquals(exceptionString, ex.getMessage());
        }
    }

    @FunctionalInterface
    private interface Action {
        void execute();
    }

    @FunctionalInterface
    private interface Call {
        void execute(String[] transactions, String date);
    }
}