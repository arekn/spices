package pl.arekn.oregano.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.util.List;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.ResourceUtils;
import pl.arekn.oregano.persistence.album.Album;
import pl.arekn.oregano.persistence.album.AlbumRepository;
import pl.arekn.oregano.persistence.user.User;
import pl.arekn.oregano.persistence.user.UserRepository;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AlbumRepository albumRepository;

    private List<Album> albums;

    @Before
    public void setUp() throws Exception {
        InputStream usersStream = ApiControllerTest.class.getResourceAsStream("../../../../../resources/albums.json");
        ObjectMapper mapper = new ObjectMapper();
        albums = mapper.readValue(usersStream, new TypeReference<List<Album>>() {
        });
        albumRepository.saveAll(albums);
    }

    @Test
    public void apiUserEndpointShouldReturnSearchedAlbum() throws Exception {
        // given

        // when
        ResultActions perform = mockMvc.perform(get("/api/album")
                .param("search", "id:1")
                .contentType(MediaType.APPLICATION_JSON));

        // then
        perform.andExpect(MockMvcResultMatchers.content().json("[{\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"quidem molestiae enim\"\n" +
                "  }]"));

    }
}