package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryHistory {

    public enum SalaryStatus {
        UP, DOWN
    }

    private final Worker worker;
    private final SalaryStatus status;
    private final double amount;
    private final LocalDate date;

    /**
     * Creates a SalaryHistory record for a salary adjustment event.
     *
     * @param worker the Worker whose salary was adjusted
     * @param status whether the salary was increased (UP) or decreased (DOWN)
     * @param amount the amount of money adjusted
     */
    public SalaryHistory(Worker worker, SalaryStatus status, double amount) {
        this.worker = worker;
        this.status = status;
        this.amount = amount;
        this.date   = LocalDate.now();
    }

    /**
     * @return the Worker associated with this salary record
     */
    public Worker getWorker() {
        return worker;
    }

    /**
     * @return the salary adjustment status (UP or DOWN)
     */
    public SalaryStatus getStatus() {
        return status;
    }

    /**
     * @return the amount of money adjusted
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @return the date the salary adjustment was recorded
     */
    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("%-6s %-10s %-6d %-10.1f %-6s %s",
                worker.getId(), worker.getName(), worker.getAge(),
                worker.getSalary(), status.name(), date.format(fmt));
    }
}
