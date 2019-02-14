package Leetcode.Google.Onsite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Car_Fleet_853 {

    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length <= 1) return position.length;

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            cars.add(new Car(position[i], (double) (target-position[i])/speed[i]));
        }

        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.position - o1.position;
            }
        });

        double maxTime = 0;
        int fleet = 0;
        for (Car c : cars) {
            if (c.time > maxTime) {
                fleet++;
                maxTime = c.time;
            }
        }
        return fleet;
    }

    class Car {
        public int position;
        public double time;
        public Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
}
