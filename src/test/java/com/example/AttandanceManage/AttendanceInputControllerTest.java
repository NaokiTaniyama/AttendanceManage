package com.example.AttandanceManage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc

public class AttendanceInputControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private JdbcTemplate jdbcTemplate;

        @Test
        public void testStartIndex() throws Exception {
            mockMvc.perform(get("/timeManagemant"))
                    .andExpect(status().is(200))
                    .andExpect(content().string(containsString("出勤")))
                    .andExpect(content().string(not(containsString("出勤出勤"))));
        }

        @Test
        public void testEndIndex() throws Exception {
            mockMvc.perform(get("/timeManagemant"))
                    .andExpect(status().is(200))
                    .andExpect(content().string(containsString("退勤")))
                    .andExpect(content().string(not(containsString("退勤退勤"))));
        }
}
