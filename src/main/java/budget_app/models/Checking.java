package budget_app.models;

import lombok.Data;

@Data
public class Checking {
    int id;
    String customerName;
    String venderName;
    int amount = 0;

}
