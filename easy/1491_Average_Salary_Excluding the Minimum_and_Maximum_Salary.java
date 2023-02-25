/**
*
* Problem: https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
* Name: 1491. Average Salary Excluding the Minimum and Maximum Salary
*
* Diffuclty: Easy
*
* Time complexity: O(n)
* Space complexity: O(n)
*
* @author Namra A. Saheba
*
*/
class Solution {
    public double average(int[] salary) {

        // Variable to hold minimum salary
        int minSalary = salary[0];

        // Variable to hold maximum salary
        int maxSalary = salary[0];

        // Variable for total salary
        int totalSalary = 0;

        // We will iterate through the array,
        // keep updating the min and max salary.
        // We will also keep adding the total salary.
        for (int i = 0; i < salary.length; i++) {
            // if current salary is less than min salary
            if (salary[i] < minSalary) {
                minSalary = salary[i];
            }

            // if current salary is more than max salary
            if (salary[i] > maxSalary) {
                maxSalary = salary[i];
            }

            totalSalary += salary[i];
        }

        // exclude the min and max salaries and calculate avg.
        return (double)(totalSalary - maxSalary - minSalary) / (salary.length - 2);
    }
}
