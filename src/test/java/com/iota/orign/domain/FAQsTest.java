package com.iota.orign.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.iota.orign.web.rest.TestUtil;

public class FAQsTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(FAQs.class);
        FAQs fAQs1 = new FAQs();
        fAQs1.setId(1L);
        FAQs fAQs2 = new FAQs();
        fAQs2.setId(fAQs1.getId());
        assertThat(fAQs1).isEqualTo(fAQs2);
        fAQs2.setId(2L);
        assertThat(fAQs1).isNotEqualTo(fAQs2);
        fAQs1.setId(null);
        assertThat(fAQs1).isNotEqualTo(fAQs2);
    }
}
