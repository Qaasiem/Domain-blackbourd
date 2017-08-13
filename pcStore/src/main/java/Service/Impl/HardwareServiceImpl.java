package Service.Impl;

import Domain.Hardware;
import Repository.HardwareRepository;
import Repository.Impl.HardwareRepositoryImpl;
import Service.HardwareServices;

/**
 * Created by qaasiem on 2017-08-13.
 */
public class HardwareServiceImpl implements HardwareServices
{
    HardwareRepository repository = HardwareRepositoryImpl.getRepository();

    @Override
    public Hardware create(Hardware hardware) {
        return repository.create(hardware);
    }

    @Override
    public Hardware read(long id) {
        return repository.read(id);
    }

    @Override
    public Hardware update(Hardware hardware) {
        return repository.update(hardware);
    }

    @Override
    public void delete(long id) {
        repository.delete(id);
    }
}
