public class Department {
    private  String partCode;
    private String nameOfDpm;
    private int numberOfPeople;
    private static int countDpm = 0;
    public Department(String nameOfDpm) {
        countDpm++;
        partCode = String.format("%02d",countDpm); // định dạng mã bộ phận thêm số 0 vào trước nếu ít hơn 2 chữ số
        this.nameOfDpm = nameOfDpm;
    }
    public String getPartCode() {
        return partCode;
    }
    public void setPartCode(String partCode ) {
        this.partCode = partCode;
    }
    public String getNameOfDpm() {
        return nameOfDpm;
    }
    public void setNameOfDpt(String nameOfDpm) {
        this.nameOfDpm = nameOfDpm;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }
    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }
    public void resetNumberOfPeople() {
        numberOfPeople = 0;
    }
    public void setNumberOfPeople() {
        numberOfPeople++;
    }
    public static int getCountDpm() {
        return countDpm;
    }
    public String toString() {
        return "Mã bộ phận: " + partCode +"\n"
                + "Tên bộ phận: " + nameOfDpm + "\n"
                + "Số lượng nhân viên hiện tại: " + numberOfPeople;
    }
}
