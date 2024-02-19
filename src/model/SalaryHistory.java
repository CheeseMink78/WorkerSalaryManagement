
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SalaryHistory implements Comparable<SalaryHistory> {
    private Worker worker;
    private String status;
    private Date date;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public SalaryHistory(Worker worker, String status, Date date) {
        this.worker = worker;
        this.status = status;
        this.date = date;
    }

    public Worker getWorker() {
        return worker;
    }

    public String getStatus() {
        return status;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return worker.toString()+String.format(" | %-10s | %-10s", status,dateFormat.format(date));
    }

    @Override
    public int compareTo(SalaryHistory o) {
        return worker.getId().compareTo(o.getWorker().getId());
    }
    
}
