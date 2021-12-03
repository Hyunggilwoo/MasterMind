package packt.java189Fundamentals.example.mastermind;

import java.util.LinkedList;
import java.util.List;

public class Table {

    final ColorManager manager;
    final int nrColumns;
    final List<Row> rows;

    /**
     * Constructs the Table
     * @param nrColumns
     * @param manager
     */
    public Table(int nrColumns, ColorManager manager) {
        this.nrColumns = nrColumns;
        this.rows = new LinkedList<>();
        this.manager = manager;
    }

    /**
     * Adding a new list of node
     * @param row a new row.
     */
    public void addRow(Row row) {
        rows.add(row);
    }



}
