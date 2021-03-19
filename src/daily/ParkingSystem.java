package daily;

/**
 * @FileName: ParkingSystem.java
 * @Description: 设计停车系统
 * @Author: admin
 * @Date: 2021/3/19 9:45
 */
public class ParkingSystem {

    int big = 0;
    int medium = 0;
    int small = 0;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
        }
        if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        }
        if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
        }
        return false;
    }


}
