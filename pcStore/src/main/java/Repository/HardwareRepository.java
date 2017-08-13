package Repository;

import Domain.Hardware;

/**
 * Created by qaasiem on 2017-08-13.
 */
public interface HardwareRepository
{
    Hardware create(Hardware hardware);

    Hardware read(long id);

    Hardware update(Hardware hardware);

    void delete(long id);
}
