package courier;

import org.apache.commons.lang3.RandomStringUtils;

public class CourierGenerator {

    public Courier generic() {
        return new Courier("6ninja0", "1234", "saske");
    }

    public Courier random() {
        return new Courier(RandomStringUtils.randomAlphanumeric(10), "Password", "ivan");
    }
}
