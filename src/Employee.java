
public class Employee extends Staff implements ICalculator {
    private int otHours = 5;
    //constructor
    public Employee(String name) {
        super(name);
    }
    //getter/setter
    public int getOtHours() {
        return otHours;
    }
    public void setOtHours(int otHours) {
        this.otHours = otHours;
    }
    //tính lương nhân viên
    @Override
    public double calculateSalary() {
        return this.getCoSalary() * 3000000 + otHours * 200000;
    }
    //hiển thị thông tin của nhân viên
    @Override
    public void displayInformation() {
        System.out.println("Mã nhân viên: " + this.getId());
        System.out.println("Tên nhân viên: " + this.getName());
        System.out.println("Bộ phận làm việc: " + this.getNameOfDepartment());
        System.out.println("Tuổi nhân viên: " + this.getAge());
        System.out.println("Ngày vào làm: " + this.getDate());
        System.out.println("Hệ số lương: " + this.getCoSalary());
        System.out.println("Số ngày nghỉ phép: " + this.getDayOff());
        System.out.println("Số giờ làm thêm: " + otHours);
        System.out.println("Số tiền lương: " + this.calculateSalary());

    }

}
