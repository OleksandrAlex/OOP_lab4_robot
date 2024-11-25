package classes;

public class Robot {
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        if (course % 90 == 0){
            this.course = course;
        }
        else {
            System.out.println("course must be a dividable by 90");
        }
    }



    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    protected int x = 0;
    protected int y = 0;
    protected int course = 0;
    public Robot() {
        this.x = this.y = this.course = 0;
    }
    public Robot (int x, int y, int course) {
        this.x = x;
        this.y = y;
        setCourse(course);
    }
    public void doSomething(){
        System.out.println("function doSomething in class robot was completed");
    };
}
