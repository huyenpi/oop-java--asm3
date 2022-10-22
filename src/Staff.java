import java.util.Calendar;
abstract public class Staff {
     private final String id;
     private String name;
     private int yearOfBirth;
     private double coSalary = 4.0;
     private String date = "01/12/2019";
     private Department department;
     private int dayOff = 0;
     private static int count = 0;
     // constructor
     public Staff(String name) {
          count++;
          id = String.format("%05d",count); // định dạng mã nhân viên thêm số 0 vào trước nếu ít hơn 5 chữ số.
          this.name = name;
     }
     //getter/setter
     public String getId() {
          return id;
     }

     public String getName() {
          return name;
     }
     public void setName(String name) {
          this.name = name;
     }

     public int getYearOfBirth() {
          return yearOfBirth;
     }
     public void setYearOfBirth(int yearOfBirth) {
          this.yearOfBirth = yearOfBirth;
     }
     public int getAge() {
          Calendar now = Calendar.getInstance();
          int y = now.get(Calendar.YEAR);
          return y - yearOfBirth;
     }

     public double getCoSalary() {
          return coSalary;
     }
     public void setCoSalary(double coSalary) {
          this.coSalary = coSalary;
     }

     public String getDate() {
          return date;
     }
     public void setDate(String date) {
          this.date = date;
     }

     public Department getDepartment() {
          return department;
     } // trả về đối trượng bộ phận(toString() return tất cả thông tin)
     public String getNameOfDepartment() {return department.getNameOfDpm();} // trả về tên bộ phận
     public void setDepartment(Department department) {
          this.department = department;
     }
     public int getDayOff() {
          return dayOff;
     }
     public void setDayOff(int dayOff) {
          this.dayOff = dayOff;
     }
     public static int getCount() {
          return count;
     }
     // hiển thị thông tin
     abstract void displayInformation();
}
