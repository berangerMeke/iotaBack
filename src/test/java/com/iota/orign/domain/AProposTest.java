package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class AProposTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(APropos.class);
        APropos aPropos1 = new APropos();
        aPropos1.setId(1L);
        APropos aPropos2 = new APropos();
        aPropos2.setId(aPropos1.getId());
        assertThat(aPropos1).isEqualTo(aPropos2);
        aPropos2.setId(2L);
        assertThat(aPropos1).isNotEqualTo(aPropos2);
        aPropos1.setId(null);
        assertThat(aPropos1).isNotEqualTo(aPropos2);
    }
}
