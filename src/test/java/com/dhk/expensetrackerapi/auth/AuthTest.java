package com.dhk.expensetrackerapi.auth;

import com.dhk.expensetrackerapi.expense.controller.ExpenseController;
import com.dhk.expensetrackerapi.expense.service.ExpenseService;
import com.dhk.expensetrackerapi.expense.service.dto.response.ExpenseResponseDto;
import com.dhk.expensetrackerapi.expense.service.dto.response.PageResponseDto;
import com.dhk.expensetrackerapi.user.controller.AuthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@MockBean(JpaMetamodelMappingContext.class)
@WebMvcTest({ExpenseController.class, AuthController.class})
public class AuthTest {

    @Autowired
    MockMvc mockMvc;
    @MockBean
    ExpenseService expenseService;

    @Test
    void unauthorizedTest() throws Exception {

        mockMvc.perform(get("/expenses"))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }

    @Test
    void noAuthorizedTest() throws Exception {
        mockMvc.perform(post("/login"))
                .andExpect(status().isOk())
                .andDo(print());
    }
}
