package sample.Employee;

public class Person {
    private String position;
    private String fio;
    private String sex;
    private String resume;
    private String dob;  //дата рождения Date of Birth
    private String uploadData;


    public Person(String position, String fio, String sex, String resume, String dob, String uploadData) {
        this.position = position;
        this.fio = fio;
        this.resume = resume;
        this.dob = dob;
        this.uploadData = uploadData;
        this.sex = sex;
    }
    public Person(){}



    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUploadData() {
        return uploadData;
    }

    public void setUploadData(String uploadData) {
        this.uploadData = uploadData;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }



}
