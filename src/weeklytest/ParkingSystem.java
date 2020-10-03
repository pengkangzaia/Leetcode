package weeklytest;

/**
 * @FileName: ParkingSystem.java
 * @Description: ParkingSystem.java类说明
 * @Author: camille
 * @Date: 2020/10/3 22:31
 */
public class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        if (big >= 0) {
            this.big = big;
        }
        if (medium >= 0) {
            this.medium = medium;
        }
        if (small >= 0) {
            this.small = small;
        }
    }

    public boolean addCar(int carType) {
        if (carType == 1) {
            if (big > 0) {
                big--;
                return true;
            }
        } else if (carType == 2) {
            if (medium > 0) {
                medium--;
                return true;
            }
        } else if (carType == 3) {
            if (small > 0) {
                small--;
                return true;
            }
        }
        return false;
    }

}
