package br.com.bank.capd.bff.rapid.payment.adapter.output;

import br.com.bank.capd.bff.rapid.payment.adapter.exception.handler.BusinessExceptionHandler;
import br.com.bank.capd.bff.rapid.payment.domain.exception.NotFoundException;
import br.com.bank.capd.bff.rapid.payment.domain.exception.ServiceUnavailableException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
class BusinessExceptionHandlerTest {

    private MockMvc mockMvc;

    /**
     * Called before each test.
     */
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(RestProcessingExceptionThrowingController.class)
                .setControllerAdvice(new BusinessExceptionHandler()).build();
    }

    @Test
    void testRequisitaEndpoint_simulaExcecaoLivroNaoEncontradoException_deveRetornarHTTP204() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tests/livroNaoEncontradoException")).andDo(print())
                .andExpect(jsonPath("$.apierro.subErros").exists())
                .andExpect(jsonPath("$.apierro.status").value(NO_CONTENT.name()))
                .andExpect(jsonPath("$.apierro.codigoErro").value(NO_CONTENT.value()))
                .andExpect(jsonPath("$.apierro.timestamp").exists())
                .andExpect(jsonPath("$.apierro.mensagem").exists())
                .andExpect(jsonPath("$.apierro.mensagemDetalhada").exists())
                .andExpect(status().isNoContent());
    }

    @Test
    void testRequisitaEndpoint_simulaExcecaoServicoIndisponivelException_deveRetornarHTTP503() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/tests/servicoIndisponivelException")).andDo(print())
                .andExpect(jsonPath("$.apierro.status").value(SERVICE_UNAVAILABLE.name()))
                .andExpect(jsonPath("$.apierro.codigoErro").value(SERVICE_UNAVAILABLE.value()))
                .andExpect(jsonPath("$.apierro.timestamp").exists())
                .andExpect(jsonPath("$.apierro.mensagem").exists())
                .andExpect(jsonPath("$.apierro.mensagemDetalhada").exists())
                .andExpect(status().isServiceUnavailable());
    }

    @Controller
    @RequestMapping(path = "/tests")
    public static class RestProcessingExceptionThrowingController {
        @GetMapping(value = "/livroNaoEncontradoException")
        public @ResponseBody String getInfrastructureException() {
            throw new NotFoundException("204", "Nao encontrou");
        }

        @GetMapping(value = "/servicoIndisponivelException")
        public @ResponseBody String getServicoIndisponivelException() {
            throw new ServiceUnavailableException("503", "Indisponivel no momento");
        }

        @GetMapping(value = "/exception")
        public @ResponseBody String getException() throws Exception {
            throw new Exception("Algum erro no app");
        }

    }

}
