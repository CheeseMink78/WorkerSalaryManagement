
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.SalaryHistory;
import model.Worker;
import model.WorkerList;
import view.Menu;

public class WorkerManagementProgram extends Menu{
    public static String[] choices = {"Add a worker","Increase Salary","Decrese Salary","Show adjusted salary worker infomation","Exit"};
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private WorkerList management= new WorkerList();
    public WorkerManagementProgram() {
        super("Worker Management Program", choices);
    }
    public void doAddWorker(){
        String id,name;
        int age,salary;
        id=Input.getString("worker id");
        name=Input.getString("worker name");
        do{
            age=Input.getInt("age");
        } while (age<18||age>50);
        do{
            salary=Input.getInt("salary");
        } while (salary<=0);
        if(management.addWorker(new Worker(id, name, age, salary))){
            System.out.println("Sucessful.");
        } else {
            System.out.println("Failed, this id is already exist.");
        }
    }
    public void doIncreseSalary(){
        dateFormat.setLenient(false);
        String id;
        int money;
        Date date;
        id=Input.getString("ID");
        do {
            money=Input.getInt("amount of money to raise");
        } while(money<=0);
        try{
            date=dateFormat.parse(Input.getString("date"));
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in dd/mm/yyyy format.");
            return;
        }
        if(management.changeSalary(id, true, money, date)){
            System.out.println("Sucessful.");
        } else {
            System.out.println("Failed, can't find the worker ID.");
        }
        
    }
    public void doDecreseSalary() {
        dateFormat.setLenient(false);
        String id;
        int money;
        Date date;
        id=Input.getString("ID");
        money=Input.getInt("amount of money to raise");
        try{
            date=dateFormat.parse(Input.getString("date"));
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter date in dd/mm/yyyy format.");
            return;
        }
        if(management.changeSalary(id, false, money, date)){
            System.out.println("Sucessful.");
        } else {
            System.out.println("Failed, can't find the worker ID.");
        }
    }
    public void showSalaryHistory() {
        management.getSalaryHistory().sort( (s1,s2)->s1.compareTo(s2));
        System.out.printf("%-10s | %-20s | %-10s | %-10s | %-10s | %-10s\n","Code","Name","Age","Salary","Status","Date");
        for(SalaryHistory test:management.getSalaryHistory()) {
            System.out.println(test);
        }
    }
    @Override
    public void execute(int ch) {
        switch(ch) {
            case 1:doAddWorker();break;
            case 2:doIncreseSalary();break;
            case 3:doDecreseSalary();break;
            case 4:showSalaryHistory();break;
            case 5:exitMenu();
            default:break;
        }
    }
    
}
