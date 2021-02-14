package CompanyRoster;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Department {
    private List<Employee> departmentList;
    private String bestDepartment;
    private double departmentSalaray;
    int departmentSize;
    private double avarage;
    String departmentName;

    Department(Employee employee){
        this.departmentList = new ArrayList<>();
        this.departmentList.add(employee);
        this.bestDepartment = employee.getDepartment();
        this.departmentName = employee.getDepartment();
    }
    public String getBestDepartment() {
        return bestDepartment;
    }

    public double getAvarage() {
        return avarage;
    }
    public void setDepartmentSalaray(double departmentSalaray) {
        this.departmentSalaray += departmentSalaray;
    }
    public double getDepartmentSize(){
        return departmentSize = departmentList.size();
    }
    public void addEmployee(Employee employee){
        this.departmentList.add(employee);
    }
    public void setAvarage(){
       this.avarage = departmentSalaray/getDepartmentSize();
    }
    public List<Employee> getDepartmentList() {
        return Collections.unmodifiableList(this.departmentList);
    }

}
