
public class Manager extends Staff implements ICalculator {
    private String title;
    // constructor
    public Manager(String name, String title) {
        super(name);
        this.title = title;
    }
    //getter/setter
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    // tính lương quản lí
    public double calculateSalary() {
        int rw = 0;
        switch (title) {
            case "Business Leader" -> rw = 8000000;
            case "Project Leader" -> rw = 5000000;
            case "Technical Leader" -> rw = 6000000;
        }
        return this.getCoSalary() * 5000000 + rw;
    }
    // hiển thị thông tin của quản lí
    public void displayInformation() {
        System.out.println("Mã nhân viên: " + this.getId());
        System.out.println("Tên nhân viên: " + this.getName());
        System.out.println("Chức vụ: " + title);
        System.out.println("Bộ phận làm việc: " + this.getNameOfDepartment());
        System.out.println("Tuổi nhân viên: " + this.getAge());
        System.out.println("Ngày vào làm: " + this.getDate());
        System.out.println("Hệ số lương: " + this.getCoSalary());
        System.out.println("Số ngày nghỉ phép: " + this.getDayOff());
        System.out.println("Số tiền lương: " + this.calculateSalary());
    }
}
