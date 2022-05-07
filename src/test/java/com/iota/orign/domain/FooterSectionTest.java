package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class FooterSectionTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FooterSection.class);
        FooterSection footerSection1 = new FooterSection();
        footerSection1.setId(1L);
        FooterSection footerSection2 = new FooterSection();
        footerSection2.setId(footerSection1.getId());
        assertThat(footerSection1).isEqualTo(footerSection2);
        footerSection2.setId(2L);
        assertThat(footerSection1).isNotEqualTo(footerSection2);
        footerSection1.setId(null);
        assertThat(footerSection1).isNotEqualTo(footerSection2);
    }
}
