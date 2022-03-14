package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class DernieresNouvellesTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DernieresNouvelles.class);
        DernieresNouvelles dernieresNouvelles1 = new DernieresNouvelles();
        dernieresNouvelles1.setId(1L);
        DernieresNouvelles dernieresNouvelles2 = new DernieresNouvelles();
        dernieresNouvelles2.setId(dernieresNouvelles1.getId());
        assertThat(dernieresNouvelles1).isEqualTo(dernieresNouvelles2);
        dernieresNouvelles2.setId(2L);
        assertThat(dernieresNouvelles1).isNotEqualTo(dernieresNouvelles2);
        dernieresNouvelles1.setId(null);
        assertThat(dernieresNouvelles1).isNotEqualTo(dernieresNouvelles2);
    }
}
