package sampleProgramm.salaryDistribution;

import java.util.Arrays;
import java.util.List;

public class CalculateSalary {

    public static void main(String [] args){
        // Total amount of money to distribute
        double totalAmountToDistribute = 555223;

        List<Employee> employees = Arrays.asList(
                new Employee("emp1", 5000),
                new Employee("emp2", 3000),
                new Employee("emp3", 2000)
        );
        SalaryDistribution.SalaryCalculation(employees, totalAmountToDistribute);
    }
}
