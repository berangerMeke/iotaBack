package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class GoogleAnalitcsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(GoogleAnalitcs.class);
        GoogleAnalitcs googleAnalitcs1 = new GoogleAnalitcs();
        googleAnalitcs1.setId(1L);
        GoogleAnalitcs googleAnalitcs2 = new GoogleAnalitcs();
        googleAnalitcs2.setId(googleAnalitcs1.getId());
        assertThat(googleAnalitcs1).isEqualTo(googleAnalitcs2);
        googleAnalitcs2.setId(2L);
        assertThat(googleAnalitcs1).isNotEqualTo(googleAnalitcs2);
        googleAnalitcs1.setId(null);
        assertThat(googleAnalitcs1).isNotEqualTo(googleAnalitcs2);
    }
}
