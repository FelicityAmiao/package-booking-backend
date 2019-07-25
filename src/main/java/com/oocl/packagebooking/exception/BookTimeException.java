package com.oocl.packagebooking.exception;

public class BookTimeException extends Exception{
    public static final String SHOULD_BETWEEN_NINE_AM_TO_EIGHT_PM = "The book time should between 9:00 am and 8:00 pm";
    public static final String WAY_BILL_ID_IS_WRONG = "Way bill id is wrong";
    public static final String NOT_ALLOW_BOOK_REPETITION = "Not allow book repetition";
    public static final String BOOK_FAIL = "Book fail";

    public BookTimeException(String wayBillIdIsWrong) {
        super(wayBillIdIsWrong);
    }
}
