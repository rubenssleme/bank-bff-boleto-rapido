package br.com.bank.capd.bff.rapid.payment.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import br.com.bank.capd.bff.rapid.payment.config.CaixaBaixaClassResolverConfig;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaixaBaixaClassResolverConfigTest {
    private CaixaBaixaClassResolverConfig resolverConfig;

    @BeforeEach
    public void setUp() {
        resolverConfig = new br.com.bank.capd.bff.rapid.payment.config.CaixaBaixaClassResolverConfig("TESTE");
    }

    @Test
    public void testGetConfig() {
        assertEquals("TESTE", resolverConfig.getConfig());
    }

    @Test
    public void testSetConfig() {
        resolverConfig.setConfig("NOVO_TESTE");
        assertEquals("NOVO_TESTE", resolverConfig.getConfig());
    }

    @Test
    public void testResolve() {
        assertEquals("teste", resolverConfig.resolve());
    }
}
