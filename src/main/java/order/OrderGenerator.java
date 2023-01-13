package order;

import java.util.Collections;
import java.util.List;

public class OrderGenerator {


    public Order genericWithoutColor() {

        return new Order("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", null);


    }

    public Order genericBlack() {

        return new Order("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", Collections.singletonList("BLACK"));


    }

    public Order genericGrey() {

        return new Order("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", Collections.singletonList("GREY"));


    }

    public Order genericGreyBlack() {

        return new Order("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", List.of("GREY", "BLACK"));


    }

    public Order genericColourNull() {

        return new Order("Naruto", "Uchiha", "Konoha, 142 apt.", 4, "+7 800 355 35 35", 5, "2020-06-06", "Saske, come back to Konoha", Collections.singletonList(null));


    }
}

