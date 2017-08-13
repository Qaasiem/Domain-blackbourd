package Factory;

import Domain.Hardware;

import java.util.Map;
/**
 * Created by qaasiem on 2017-08-13.
 */
public class HardwareFactory
{
    public static Hardware getHardware(Long id, Map<String, String> hardwareValues)
    {
        Hardware hardware = new Hardware.Builder()
                .id(id)
                .manufacturer(hardwareValues.get("manufacturer"))
                .name(hardwareValues.get("name"))
                .category(hardwareValues.get("category"))
                .price(Double.parseDouble(hardwareValues.get("price")))
                .build();
        return hardware;
    }
}