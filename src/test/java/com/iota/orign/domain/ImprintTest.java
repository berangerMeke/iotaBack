package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class ImprintTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Imprint.class);
        Imprint imprint1 = new Imprint();
        imprint1.setId(1L);
        Imprint imprint2 = new Imprint();
        imprint2.setId(imprint1.getId());
        assertThat(imprint1).isEqualTo(imprint2);
        imprint2.setId(2L);
        assertThat(imprint1).isNotEqualTo(imprint2);
        imprint1.setId(null);
        assertThat(imprint1).isNotEqualTo(imprint2);
    }
}
