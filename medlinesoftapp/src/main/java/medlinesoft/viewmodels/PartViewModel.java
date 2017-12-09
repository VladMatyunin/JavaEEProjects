package medlinesoft.viewmodels;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import static medlinesoft.utils.Constants.getDateFormatter;

/**
 * View model object. Used to work with filters.
 * Main idea is to convert data from passed form and to send back to jsp.
 */
public class PartViewModel {

    /**
     * The limit in date, if used didn't set it.
     * This feature makes query simple and helps Postgres easily
     * build plans based on preparedStatement object
     */
    private final Date FAR_FUTURE = new Date(999_999_999_999_999L);
    private final Date EARLY_PAST = new Date(0L);
    private final SimpleDateFormat DATE_FORMATTER = getDateFormatter();

    public PartViewModel(){
        qty = 0;
        shippedAfter = EARLY_PAST;
        shippedBefore = FAR_FUTURE;
        receivedBefore = FAR_FUTURE;
        receivedAfter = EARLY_PAST;
        orderByParameter = "number";
        asc = true;
        name = "";
        number = "";
        vendor = "";
        qty = Integer.MAX_VALUE;
    }

    private String name;

    private String number;

    private String vendor;

    private Integer qty;

    private Date shippedAfter;

    private Date shippedBefore;

    private Date receivedAfter;

    private Date receivedBefore;

    private String orderByParameter;

    private boolean asc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Date getShippedAfter() {
        return getNotNullDateAfter(shippedAfter);
    }

    public void setShippedAfter(Date shippedAfter) {
        this.shippedAfter = shippedAfter;
    }

    public Date getShippedBefore() {
        return getNotNullDateBefore(shippedBefore);
    }

    public void setShippedBefore(Date shippedBefore) {
        this.shippedBefore = shippedBefore;
    }

    public Date getReceivedAfter() {
        return getNotNullDateAfter(receivedAfter);
    }

    public void setReceivedAfter(Date receivedAfter) {
        this.receivedAfter = receivedAfter;
    }

    public Date getReceivedBefore() {
        return getNotNullDateBefore(receivedBefore);
    }

    public void setReceivedBefore(Date receivedBefore) {
        this.receivedBefore = receivedBefore;
    }

    public String getReceivedBeforeString() {
        return getDateToString(receivedBefore);
    }
    public String getReceivedAfterString() {
        return getDateToString(receivedAfter);
    }
    public String getShippedBeforeString() {
        return getDateToString(shippedBefore);
    }
    public String getShippedAfterString() {
        return getDateToString(shippedAfter);
    }
    public String getQtyString(){
        return qty.equals(Integer.MAX_VALUE)?"":qty.toString();
    }

    private String getDateToString(Date date){
        if (date==null) return "";
        else if (date.equals(EARLY_PAST)||date.equals(FAR_FUTURE))
            return "";
        else
            return DATE_FORMATTER.format(date);
    }
    private Date getNotNullDateAfter(Date date) {
        return  date!=null? date : new Date(1);
    }
    private Date getNotNullDateBefore(Date date) {
        return  date!=null? date : FAR_FUTURE;
    }

    public String getOrderByParameter() {
        return orderByParameter;
    }

    public void setOrderByParameter(String orderByParameter) {
        this.orderByParameter = orderByParameter;
    }

    public boolean isAsc() {
        return asc;
    }

    public void setAsc(boolean asc) {
        this.asc = asc;
    }
}
