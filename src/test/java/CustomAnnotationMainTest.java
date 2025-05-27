import dev.example.annotation.general.custom.Car;
import dev.example.annotation.general.custom.CarFactory;
import dev.example.annotation.general.custom.CarRequest;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomAnnotationMainTest {

    @Test
    public void testValidYearRange() {
        Car car = CarFactory.createCar(new CarRequest("BMW", 2021));
        assertThat(car.getYear()).isEqualTo(2021);

        System.out.println(car);
    }

    @Test
    public void testInvalidYearRange() {
        assertThatThrownBy(() -> CarFactory.createCar(new CarRequest("BMW", 2026)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
