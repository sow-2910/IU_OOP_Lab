package question4;

public class Employee implements Comparable<Employee> {
    private String employeeId;
    private String employeeName;
    private int salaryPerHour;
    private int noOfLeavingDay;
    private int noOfTravelDay;

    public Employee() {

    }

    public Employee(String employeeId, String employeeName, int salaryPerHour, int noOfLeavingDay,
            int noOfTravelDay) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salaryPerHour = salaryPerHour;
        this.noOfLeavingDay = noOfLeavingDay;
        this.noOfTravelDay = noOfTravelDay;
    }

    public int calculateWeeklySalary() {
        return salaryPerHour * 8 * (5 - noOfLeavingDay + noOfTravelDay / 2);
    }

    @Override
    public int compareTo(Employee other) {
        int cmp = Integer.compare(other.noOfTravelDay, this.noOfTravelDay);
        if (cmp != 0) {
            return cmp;
        }
        return Integer.compare(this.noOfLeavingDay, other.noOfLeavingDay);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String name) {
        this.employeeName = name;
    }

    public int getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(int salary) {
        this.salaryPerHour = salary;
    }

    public int getNoOfLeavingDay() {
        return noOfLeavingDay;
    }

    public void setNoOfLeavingDay(int date) {
        this.noOfLeavingDay = date;
    }

    public int getNoOfTravelDay() {
        return noOfTravelDay;
    }

    public void setNoOfTravelDay(int date) {
        this.noOfTravelDay = date;
    }

    @Override
    public String toString() {
        return "[Name: " + employeeName + " - Salary Per Hour: " + salaryPerHour
                + " - Weekly Salary: "
                + calculateWeeklySalary() + "]";
    }

}

