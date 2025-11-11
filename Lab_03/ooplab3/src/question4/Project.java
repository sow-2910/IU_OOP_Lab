package question4;

import java.util.*;

public class Project {
    private String projectId;
    private Date startDate;
    private Date endDate;
    private final ArrayList<Employee> listOfEmployee = new ArrayList<>();

    public Project() {

    }

    public Project(String projectId, Date startDate, Date endDate, Employee employee) {
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
        if (employee != null) {
            listOfEmployee.add(employee);
        }
    }


    public Project(String projectId, Date startDate, Date endDate) {
        this.projectId = projectId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void addEmployee(Employee employee) {
        if (employee != null) {
            listOfEmployee.add(employee);
        }
    }

    public void addEmployees(Employee... employees) {
        if (employees == null)
            return;
        for (Employee e : employees) {
            if (e != null)
                listOfEmployee.add(e);
        }
    }

    public int estimateBudget() {
        int sum = 0;
        for (Employee e : listOfEmployee) {
            sum += e.calculateWeeklySalary();
        }
        return sum;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date endDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<Employee> getEmployees() {
        return Collections.unmodifiableList(listOfEmployee);
    }

    public void sortEmployees() {
        Collections.sort(listOfEmployee);
    }

}
