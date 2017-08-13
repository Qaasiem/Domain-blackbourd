package Repository.Impl;

import Domain.Hardware;
import Repository.HardwareRepository;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by qaasiem on 2017-08-13.
 */
public class HardwareRepositoryImpl implements HardwareRepository
{
    private static HardwareRepositoryImpl repository = null;

    private Map<Long, Hardware> hardwareTable;

    private HardwareRepositoryImpl()
    {
        hardwareTable = new HashMap<Long, Hardware>();
    }

    public static HardwareRepositoryImpl getRepository()
    {
        if(repository == null)
        {
            repository = new HardwareRepositoryImpl();
        }
        return repository;
    }

    @Override
    public Hardware create(Hardware hardware) {
        hardwareTable.put(hardware.getID(), hardware);
        Hardware saveHardware = hardwareTable.get(hardware.getID());
        return saveHardware;
    }

    @Override
    public Hardware read(long id) {
        Hardware hardware = hardwareTable.get(id);
        return hardware;
    }

    @Override
    public Hardware update(Hardware hardware) {
        hardwareTable.put(hardware.getID(), hardware);
        Hardware updateHardware = hardwareTable.get(hardware.getID());
        return updateHardware;
    }

    @Override
    public void delete(long id) {
        hardwareTable.remove(id);
    }
}
