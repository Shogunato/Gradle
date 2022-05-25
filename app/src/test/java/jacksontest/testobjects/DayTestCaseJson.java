package jacksontest.testobjects;

import java.time.LocalDate;

public class DayTestCaseJson {
    
    private String name;
    private LocalDate date;

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



}
