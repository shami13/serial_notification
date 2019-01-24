package ua.com.shami.serialnotification.seasonvar.api;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import ua.com.shami.serialnotification.seasonvar.dto.SeasonvarSerialJSON;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SeasonvarAPITest {
    @Autowired
    private SeasonvarAPI seasonvarAPI;

    @Test
    public void searchSerial() {
        List<SeasonvarSerialJSON> serials = seasonvarAPI.searchSerial("33");
        System.out.println(serials);
    }
}