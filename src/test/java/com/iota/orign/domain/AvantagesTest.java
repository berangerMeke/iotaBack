package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class AvantagesTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Avantages.class);
        Avantages avantages1 = new Avantages();
        avantages1.setId(1L);
        Avantages avantages2 = new Avantages();
        avantages2.setId(avantages1.getId());
        assertThat(avantages1).isEqualTo(avantages2);
        avantages2.setId(2L);
        assertThat(avantages1).isNotEqualTo(avantages2);
        avantages1.setId(null);
        assertThat(avantages1).isNotEqualTo(avantages2);
    }
}
