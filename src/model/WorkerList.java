
package model;

import java.util.ArrayList;
import java.util.Date;

public class WorkerList {
    private ArrayList<Worker> workerList= new ArrayList<>();
    private ArrayList<SalaryHistory> salaryHistory= new ArrayList<>();

    public WorkerList() {
        addWorker(new Worker("W1","Giang",18,1000));
        addWorker(new Worker("W3","Thang",18,20000));
        addWorker(new Worker("W5","Kiet",18,8000));
        addWorker(new Worker("W7","Minh",18,5000));
        addWorker(new Worker("W9","Dat",20,10000));
    }
    public boolean addWorker(Worker newWorker) {
        for(Worker test:workerList) {
            if(test.equals(newWorker)) return false;
        }
        workerList.add(newWorker);
        return true;
    }
    public boolean changeSalary(String id,boolean flag,int money,Date date) {
        for(Worker test:workerList) {
            if(test.getId().matches(id)) {
                if(flag) {
                    test.setSalary(test.getSalary()+money);
                    salaryHistory.add(new SalaryHistory(test,"UP",date));
                }
                else {
                    test.setSalary(test.getSalary()-money);
                    salaryHistory.add(new SalaryHistory(test,"DOWN",date));
                }
                return true;
            }
        }
        return false;
    }

    public ArrayList<Worker> getWorkerList() {
        return workerList;
    }

    public ArrayList<SalaryHistory> getSalaryHistory() {
        return salaryHistory;
    }
    
}
