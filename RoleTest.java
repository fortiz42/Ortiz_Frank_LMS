import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RoleTest {
    @Test
    public void testRoleEnumValues() {
        assertEquals(Role.ADMIN, Role.valueOf("ADMIN"));
        assertEquals(Role.SUBSCRIBER, Role.valueOf("SUBSCRIBER"));
    }
}
