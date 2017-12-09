package medlinesoft.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static medlinesoft.utils.Constants.getDateFormatter;

/**
 * Pojo object stored in database in queried from UI
 */
public class Part {

    public Part(){}
    public Part(String name, String number, String vendor, Integer qty, Date shipped, Date received) {
        this.name = name;
        this.number = number;
        this.vendor = vendor;
        this.qty = qty;
        this.shipped = shipped;
        this.received = received;
    }

    private String name;

    private String number;

    private String vendor;

    private Integer qty;

    private Date shipped;

    private Date received;

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

    public Date getShipped() {
        return shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    // for jsp
    public String getReceivedString(){
        return getDateFormatter().format(received);
    }
    // for jsp
    public String getShippedString(){
        return getDateFormatter().format(shipped);
    }
}

