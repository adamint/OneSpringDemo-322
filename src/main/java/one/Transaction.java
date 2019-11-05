package one;

public class Transaction {
  private int id;
  private String value;
  private boolean deleted;

  public Transaction(int id, String value) {
    this.id = id;
    this.value = value;
    this.deleted = false;
  }

  public int getId() {
    return id;
  }

  public String getValue() {
    return value;
  }

  public boolean isDeleted() {
    return deleted;
  }
}
