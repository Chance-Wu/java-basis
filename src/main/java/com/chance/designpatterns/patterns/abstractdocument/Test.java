package com.chance.designpatterns.patterns.abstractdocument;

import com.chance.designpatterns.patterns.abstractdocument.domain.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

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
        LOGGER.info("Constructing parts and car");
        // 车属性map
        Map<String, Object> carProperties = new HashMap<>(16);
        carProperties.put(HasModel.PROPERTY, "300SL");
        carProperties.put(HasPrice.PROPERTY, 10000L);

        // 轮子属性map
        Map<String, Object> wheelProperties = new HashMap<>(16);
        wheelProperties.put(HasType.PROPERTY, "wheel");
        wheelProperties.put(HasModel.PROPERTY, "15C");
        wheelProperties.put(HasPrice.PROPERTY, 100L);

        // 门属性map
        Map<String, Object> doorProperties = new HashMap<>(16);
        doorProperties.put(HasType.PROPERTY, "door");
        doorProperties.put(HasModel.PROPERTY, "Lambo");
        doorProperties.put(HasPrice.PROPERTY, 300L);

        carProperties.put(HasParts.PROPERTY, Arrays.asList(wheelProperties, doorProperties));

        Car car = new Car(carProperties);

        LOGGER.info("Here is our car:");
        LOGGER.info("-> model: {}" + car.getModel().get());
        LOGGER.info("-> price: {}" + car.getPrice().get());
        LOGGER.info("-> parts: ");
        car.getParts().forEach(p -> LOGGER.info(p.getType().get() + p.getModel().get() + p.getPrice().get()));
    }
}
