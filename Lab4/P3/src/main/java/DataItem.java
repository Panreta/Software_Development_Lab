// DataItem.java
public class DataItem {
    private final int id;
    private final long timestamp;

    public DataItem(int id) {
        this.id = id;
        this.timestamp = System.currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return String.format("DataItem[id=%d, timestamp=%d]", id, timestamp);
    }
}