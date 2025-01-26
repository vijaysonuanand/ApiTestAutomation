package sampleProgramm.salaryDistribution;

import java.util.List;

public class SalaryDistribution {

    public static void SalaryCalculation(List<Employee> employeeList, double totalAmountToDistribute) {
    // Calculate the total salary (sum of all salaries)
    double totalSalary = employeeList.stream()
            .mapToDouble(employee -> employee.salary)
            .sum();

    // Distribute the money among employees based on their salary ratio
        employeeList.forEach(employee -> {
        double share = (employee.salary / totalSalary) * totalAmountToDistribute;
        System.out.printf("Employee: %s, Share: %.2f%n", employee.name, share);
    });
}
}
