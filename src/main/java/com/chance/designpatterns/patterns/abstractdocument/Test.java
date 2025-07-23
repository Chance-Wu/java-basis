package com.chance.designpatterns.patterns.abstractdocument;

import com.chance.designpatterns.patterns.abstractdocument.domain.Car;
import com.chance.designpatterns.patterns.abstractdocument.domain.enums.CarProperty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 *
 * <p>
 *
 * @author chance
 * @since 2020-06-19
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("构造部件和汽车");
        Map<String, Object> wheelProperties = new HashMap<>();
        wheelProperties.put(CarProperty.TYPE.toString(), "wheel");
        wheelProperties.put(CarProperty.MODEL.toString(), "15C");
        wheelProperties.put(CarProperty.PRICE.toString(), 100L);

        Map<String, Object> doorProperties = new HashMap<>();
        doorProperties.put(CarProperty.TYPE.toString(), "door");
        doorProperties.put(CarProperty.MODEL.toString(), "Lambo");
        doorProperties.put(CarProperty.PRICE.toString(), 300L);

        Map<String, Object> carProperties = new HashMap<>();
        carProperties.put(CarProperty.MODEL.toString(), "300SL");
        carProperties.put(CarProperty.PRICE.toString(), 10000L);
        carProperties.put(CarProperty.PARTS.toString(), Arrays.asList(wheelProperties, doorProperties));

        Car car = new Car(carProperties);
        System.out.println("Here is our car:");
        System.out.println("-> model: " + car.getModel().orElseThrow(() -> new IllegalStateException("Model not found")));
        System.out.println("-> price: " + car.getPrice().orElseThrow(() -> new IllegalStateException("Price not found")));
        System.out.println("-> parts: ");

        car.getParts().forEach(part ->
                System.out.println("\t"
                        + "/" + part.getType().orElse(null)
                        + "/" + part.getModel().orElse(null)
                        + "/" + part.getPrice().orElse(null))
        );
    }
}
