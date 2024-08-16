package agricol.backend;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControladorTest {

    @Autowired
    
    private MockMvc mockMvc;

    @Test
    public void testGetMethodUsingId_whenUserDoesNotExist_shouldReturn404() throws Exception {
        // Given
        String nonExistingUserId = "non-existing-user-id";

        // When
        mockMvc.perform(MockMvcRequestBuilders.get("/Usuarios/" + nonExistingUserId))
                // Then
                .andExpect(status().isBadRequest());
    }
}