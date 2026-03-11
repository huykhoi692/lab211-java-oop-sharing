package bo;

import entity.SalaryHistory;
import entity.SalaryHistory.SalaryStatus;
import entity.Worker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkerManager {

    private final List<Worker> workers = new ArrayList<>();
    private final List<SalaryHistory> history = new ArrayList<>();

    /**
     * Adds a new worker to the list.
     *
     * @param worker the Worker object to add
     * @return true if the worker was added successfully
     * @throws Exception if worker is null or the ID already exists
     */
    public boolean addWorker(Worker worker) throws Exception {
        if (worker == null) {
            throw new Exception("Worker data does not exist.");
        }
        for (Worker w : workers) {
            if (w.getId().equalsIgnoreCase(worker.getId())) {
                throw new Exception("Worker code [" + worker.getId() + "] is duplicate.");
            }
        }
        workers.add(worker);
        return true;
    }

    /**
     * Increases or decreases a worker's salary and records the adjustment.
     *
     * @param status the type of adjustment: UP to increase, DOWN to decrease
     * @param code   the unique ID of the worker to adjust
     * @param amount the amount of money to add or subtract (must be > 0)
     * @return true if the salary was changed successfully
     * @throws Exception if code is blank, amount is not positive, or worker is not found
     */
    public boolean changeSalary(SalaryStatus status, String code, double amount) throws Exception {
        if (code == null || code.trim().isEmpty()) {
            throw new Exception("Code must not be blank.");
        }
        if (amount <= 0) {
            throw new Exception("Amount must be greater than 0.");
        }
        Worker found = findById(code);
        if (found == null) {
            throw new Exception("Worker code [" + code + "] does not exist.");
        }
        double newSalary;
        if (status == SalaryStatus.UP) {
            newSalary = found.getSalary() + amount;
        } else {
            newSalary = found.getSalary() - amount;
        }
        found.applySalaryChange(newSalary);
        history.add(new SalaryHistory(found, status, amount));
        return true;
    }

    /**
     * Returns salary-adjustment records sorted ascending by worker ID.
     *
     * @return a sorted List of SalaryHistory records
     */
    public List<SalaryHistory> getInformationSalary() {
        List<SalaryHistory> sorted = new ArrayList<>(history);
        sorted.sort(new Comparator<SalaryHistory>() {
            @Override
            public int compare(SalaryHistory a, SalaryHistory b) {
                return a.getWorker().getId().compareToIgnoreCase(b.getWorker().getId());
            }
        });
        return sorted;
    }

    /**
     * Checks whether a worker with the given ID already exists.
     *
     * @param id the ID to check
     * @return true if a worker with this ID exists, false otherwise
     */
    public boolean existsById(String id) {
        return findById(id) != null;
    }

    /**
     * Finds a worker by their unique ID (case-insensitive).
     *
     * @param id the ID of the worker to find
     * @return the Worker object if found, or null if not found
     */
    public Worker findById(String id) {
        for (Worker w : workers) {
            if (w.getId().equalsIgnoreCase(id.trim())) {
                return w;
            }
        }
        return null;
    }
}
