package world.homans.xunyue.base;

import world.homans.xunyue.util.IdGeneratorUtils;
import org.springframework.beans.factory.annotation.Autowired;


public class BaseController {
    @Autowired
    private IdGeneratorUtils idGeneratorUtils;

    public IdGeneratorUtils getIdGeneratorUtils() {
        return idGeneratorUtils;
    }

}
