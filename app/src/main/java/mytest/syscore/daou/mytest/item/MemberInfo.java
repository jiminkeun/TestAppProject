package mytest.syscore.daou.mytest.item;

/**
 * Created by daou on 2017-11-22.
 */

public class MemberInfo {
    private int no;
    private String name;
    private int age;
    private String sex;
    private String birthday;
    private String job;
    private String addr;

    public MemberInfo(int no, String name, int age, String sex, String birthday, String job, String addr) {
        this.no = no;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.job = job;
        this.addr = addr;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getJob() {
        return job;
    }

    public String getAddr() {
        return addr;
    }

    public String[] getMemberInfoArray(){
        String[] info = {
                Integer.toString(this.no),
                this.name,
                Integer.toString(this.age),
                this.sex,
                this.birthday,
                this.job,
                this.addr
        };

        return info;
    }
}
