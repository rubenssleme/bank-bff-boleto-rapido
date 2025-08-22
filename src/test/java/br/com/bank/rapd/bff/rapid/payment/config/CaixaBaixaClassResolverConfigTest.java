package br.com.bank.rapd.bff.rapid.payment.config;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaixaBaixaClassResolverConfigTest {
    private CaixaBaixaClassResolverConfig resolverConfig;

    @BeforeEach
    public void setUp() {
        resolverConfig = new CaixaBaixaClassResolverConfig("TESTE");
    }

//    @Test
//    public void testGetConfig() {
//        assertEquals("TESTE", resolverConfig.getConfig());
//    }
//
//    @Test
//    public void testSetConfig() {
//        resolverConfig.setConfig("NOVO_TESTE");
//        assertEquals("NOVO_TESTE", resolverConfig.getConfig());
//    }
//
//    @Test
//    public void testResolve() {
//        assertEquals("teste", resolverConfig.resolve());
//    }
}
